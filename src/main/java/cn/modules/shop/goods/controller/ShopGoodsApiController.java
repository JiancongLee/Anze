package cn.modules.shop.goods.controller;

import cn.common.factory.PageFactory;
import cn.common.utils.PageUtils;
import cn.common.utils.Result;
import cn.modules.shop.goods.entity.ShopGoodsEntity;
import cn.modules.shop.goods.service.ShopGoodsService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品API控制器
 *
 * @author jianconglee
 * @date 2019-04-10 14:48:47
 */
@RestController
@RequestMapping("/api")
public class ShopGoodsApiController {

	@Autowired
	private ShopGoodsService shopGoodsService;

	/**
	 * 获取新品商品
	 * @return Object 分页信息
	 */
	@GetMapping(value = "/goods/newGoodsList")
	public Object getNewGoodsList() {
		EntityWrapper<ShopGoodsEntity> wrapper = new EntityWrapper<>();
		wrapper.eq("is_new",1);
		//TODO 这里先写死四条
		wrapper.last("limit 4");
		List<ShopGoodsEntity> newGoods = shopGoodsService.selectList(wrapper);
		return Result.ok().put("newGoods", newGoods);
	}

	/**
	 * 获取新品商品
	 * @return Object 分页信息
	 */
	@GetMapping(value = "/goods/hotGoodsList")
	public Object getHotGoodsList() {
		EntityWrapper<ShopGoodsEntity> wrapper = new EntityWrapper<>();
		wrapper.eq("is_hot",1);
		//TODO 这里先写死四条
		wrapper.last("limit 4");
		List<ShopGoodsEntity> hotGoods = shopGoodsService.selectList(wrapper);
		return Result.ok().put("hotGoods", hotGoods);
	}


}
