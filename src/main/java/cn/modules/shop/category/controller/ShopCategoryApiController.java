package cn.modules.shop.category.controller;

import cn.base.AbstractController;
import cn.common.utils.Result;
import cn.modules.shop.category.entity.ShopCategoryEntity;
import cn.modules.shop.category.service.ShopCategoryService;
import cn.modules.shop.goods.entity.ShopGoodsEntity;
import cn.modules.shop.goods.entity.ViewShopGoodsEntity;
import cn.modules.shop.goods.service.ShopGoodsService;
import cn.modules.shop.goods.service.ViewShopGoodsService;
import cn.modules.shop.member.vo.wxLoginVo;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品类别API
 *
 * @author jianconglee
 * @date 2019-04-08
 */
@RestController
@RequestMapping("/api")
public class ShopCategoryApiController extends AbstractController {

	@Autowired
	private ShopCategoryService shopCategoryService;
	@Autowired
	private ViewShopGoodsService viewShopGoodsService;
	@Autowired
	private ShopGoodsService shopGoodsService;

	@GetMapping("/category/list")
	public Object getCategoryListApi(Integer level) {
		if (level == null) {
			return Result.error(-1,"");
		}
		EntityWrapper<ShopCategoryEntity> wrapper = new EntityWrapper<>();
		wrapper.eq("level",level);
		List<ShopCategoryEntity> list = shopCategoryService.selectList(wrapper);
		return Result.ok().put("list", list);
	}

	@GetMapping("/category/detail")
	public Object getDetailDataApi(Long parentId) {
		if (parentId == null) {
			return Result.error(-1,"");
		}
		ShopCategoryEntity parent = shopCategoryService.selectById(parentId);

		EntityWrapper<ShopCategoryEntity> wrapper = new EntityWrapper<>();
		wrapper.eq("parent_id",parentId);
		List<ShopCategoryEntity> cList = shopCategoryService.selectList(wrapper);
		return Result.ok().put("parent", parent).put("childrenList",cList);
	}

	@GetMapping("/category/categoryNav")
	public Object categoryNav(Long categoryId) {
		if (categoryId == null) {
			return Result.error(-1,"");
		}
		ShopCategoryEntity category = shopCategoryService.selectById(categoryId);
		Long parentId = 0L;
		if (category != null) {
			parentId = category.getParentId();
		}
		EntityWrapper<ShopCategoryEntity> wrapper = new EntityWrapper<>();
		wrapper.eq("parent_id",parentId);
		List<ShopCategoryEntity> categoryList = shopCategoryService.selectList(wrapper);
		return Result.ok().put("currentNav", category).put("navListData",categoryList);
	}
	/**
	 * 根据类别Id获取底下的商品
	 */
	@GetMapping("/category/getGoodsList")
	public Object getGoodsList(Long categoryId) {
		if (categoryId == null) {
			return Result.error(-1,"");
		}
		ShopCategoryEntity category = shopCategoryService.selectById(categoryId);
		Long parentId = 0L;
		if (category != null) {
			parentId = category.getParentId();
		}
		EntityWrapper<ViewShopGoodsEntity> wrapper = new EntityWrapper<>();
		wrapper.eq("second_level_category_id",categoryId);
		List<ViewShopGoodsEntity> goodsList = viewShopGoodsService.selectList(wrapper);
		return Result.ok().put("currentNav", category).put("data",goodsList);
	}
	/**
	 * 获取一级类别的商品
	 */
	@GetMapping("/category/getFirstLevelGoodsList")
	public Object getGoodsListByFirstLevelCategoryId() {
		EntityWrapper<ShopCategoryEntity> wrapper = new EntityWrapper<>();
		wrapper.eq("level",0);
		List<ShopCategoryEntity> first = shopCategoryService.selectList(wrapper);
		List<Map<String,Object>> list = new ArrayList<>();
		for (ShopCategoryEntity category : first) {
			Map<String, Object> subMap = new HashMap<>();
			subMap.put("id", category.getId());
			subMap.put("name", category.getName());
			EntityWrapper<ShopGoodsEntity> _wrapper = new EntityWrapper<>();
			_wrapper.eq("first_level_category_id",category.getId());
			//TODO 这里先写死四条
			_wrapper.last("limit 5");
			List<ShopGoodsEntity> goodsList = shopGoodsService.selectList(_wrapper);
			subMap.put("goodsList", goodsList);
			list.add(subMap);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		return Result.ok(map);
	}

}
