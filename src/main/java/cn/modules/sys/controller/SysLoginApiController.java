package cn.modules.sys.controller;

import cn.base.AbstractController;
import cn.common.utils.HttpKit;
import cn.common.utils.JwtUtils;
import cn.common.utils.Result;
import cn.modules.shop.member.entity.ShopMemberEntity;
import cn.modules.shop.member.service.ShopMemberService;
import cn.modules.shop.member.vo.wxLoginVo;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.toolkit.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SysLoginApiController extends AbstractController {
	@Autowired
	private ShopMemberService shopMemberService;
	@Autowired
	private JwtUtils jwtUtils;
	/**
	 * 请求的网址
	 */
	public static final String WX_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session";
	/**
	 * 你的appid
	 */
	public static final String WX_LOGIN_APPID = "wx0319e7108d769f0d";
	/**
	 * 你的密匙
	 */
	public static final String WX_LOGIN_SECRET = "aba3f5cb11d793f0b1d9159068b19595";
	/**
	 * 固定参数
	 */
	public static final String WX_LOGIN_GRANT_TYPE = "authorization_code";

	@PostMapping("/auth/login")
	public Object loginByWeixin(@RequestBody wxLoginVo vo) {
		Map<String,String> map = new HashMap<>();
		String code = vo.getCode();
		System.out.println(code);

		map.put("appid",WX_LOGIN_APPID);
		map.put("secret",WX_LOGIN_SECRET);
		map.put("js_code",code);
		map.put("grant_type",WX_LOGIN_GRANT_TYPE);

		String result  =  HttpKit.sendGet(WX_LOGIN_URL, map);
		System.out.println(result);
		JSONObject jsonObject = JSONObject.parseObject(result);
		String sessionKey = jsonObject.get("session_key").toString();
		String openId = jsonObject.get("openid").toString();

		Wrapper<ShopMemberEntity> wrapper = new EntityWrapper<>();
		wrapper.eq("weixin_open_id",openId);
		ShopMemberEntity entity = shopMemberService.selectOne(wrapper);
		System.out.println(entity);
		Long memberId = 0L;
		if (entity != null) {
			// 存在用户则更新登陆时间
			memberId = entity.getId();
			entity.setLastLoginTime(new Date());
			shopMemberService.updateById(entity);
		} else {
			// 不存在用户则新增

			ShopMemberEntity member = new ShopMemberEntity();
			member.setNickName(vo.getNickName());
			member.setAvatar(vo.getAvatarUrl());
			member.setCountry(vo.getCountry());
			member.setProvince(vo.getProvince());
			member.setCity(vo.getCity());
			member.setGender(vo.getGender());
			member.setLanguage(vo.getCountry());
			member.setWeixinOpenId(openId);
			member = (ShopMemberEntity)shopMemberService.insertAndReturn(member);
			memberId = member.getId();
		}
		System.out.println("memberId"+memberId);
		String token = jwtUtils.generateToken(memberId);
		System.out.println(token);
		System.out.println("根据微信登陆");
		return Result.ok().put("session_key",sessionKey).put("open_id",openId);
	}
}
