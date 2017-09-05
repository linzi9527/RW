package com.recycle.service.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.recycle.service.ProductServiceImpl;
import com.recycle.service.utils.Utils;
import com.summaryday.framework.db.JsonUtil;

/**
 * 主要处理和产品相关的服务
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/api")
public class ProductManagerController {

	private static final Logger log = Logger.getLogger(ProductManagerController.class);
	
	@Resource
	private ProductServiceImpl productService;
	
	/**
	 * e.g:select * from table_name limit 10,5

		limit关键字的用法：
		
		LIMIT [offset,] rows
		
		offset指定要返回的第一行的偏移量，rows第二个指定返回行的最大数目。初始行的偏移量是0(不是1)。
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/product/querys")
	public void list_service_products(HttpServletRequest request,HttpServletResponse response){
		//if(null==productService)productService=SpringBeanHelper.getBean("productService");
		log.info("\nproductService:"+productService);
		Map<String,Object> map=new HashMap<String,Object>();
		JSONObject obj=Utils.jsonObjectFromJSONString(request);
		map=productService.service_products(obj);
		JsonUtil.returnMap(response, map);
	}
	
}
