package cn.modules.shop.brand.controller;

import cn.base.AbstractController;
import cn.common.factory.PageFactory;
import cn.common.utils.PageUtils;
import cn.common.utils.Result;
import cn.modules.shop.brand.entity.ShopBrandEntity;
import cn.modules.shop.brand.service.ShopBrandService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShopBrandApiController extends AbstractController {
	@Autowired
	private ShopBrandService shopBrandService;

	/**
	 * 获取品牌列表（4个）
	 * @return Object 分页信息
	 */
	@GetMapping(value = "/brand/list")
	public Object page() {
		EntityWrapper<ShopBrandEntity> wrapper = new EntityWrapper<>();
		//TODO 这里先写死四条
		wrapper.last("limit 4");
		List<ShopBrandEntity> list = shopBrandService.selectList(wrapper);
		return Result.ok().put("list", list);
	}
}
