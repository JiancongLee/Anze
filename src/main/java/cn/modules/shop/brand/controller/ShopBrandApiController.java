package cn.modules.shop.brand.controller;

import cn.base.AbstractController;
import cn.common.factory.PageFactory;
import cn.common.utils.PageUtils;
import cn.common.utils.Result;
import cn.modules.shop.brand.entity.ShopBrandEntity;
import cn.modules.shop.brand.service.ShopBrandService;
import cn.modules.shop.goods.entity.ViewShopGoodsEntity;
import cn.modules.shop.goods.service.ViewShopGoodsService;
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
	@Autowired
	private ViewShopGoodsService viewShopGoodsService;

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
	/**
	 * 获取分页信息
	 * @param entity 对象
	 * @return Object 分页信息
	 */
	@GetMapping(value = "/brand/page")
	public Object page(ShopBrandEntity entity) {
		Page<ShopBrandEntity> page = new PageFactory<ShopBrandEntity>().defaultPage();
		page.setRecords(shopBrandService.selectPage(page,entity,new EntityWrapper<ShopBrandEntity>()));
		return Result.ok().put("page", new PageUtils(page));
	}

	/**
	 * 获取品牌信息以及该品牌下的商品
	 * @param id brandId
	 * @return Object 分页信息
	 */
	@GetMapping(value = "/brand/info")
	public Object getBrandInfoById(Long id) {
		ShopBrandEntity entity = shopBrandService.selectById(id);
		if (entity == null) {
			return Result.error(-1,"找不到brandInfo");
		}
		EntityWrapper<ViewShopGoodsEntity> wrapper = new EntityWrapper<>();
		wrapper.eq("brand_id",id);
		List<ViewShopGoodsEntity> list = viewShopGoodsService.selectList(wrapper);
		return Result.ok().put("brandInfo",entity).put("goodsList",list);
	}

}
