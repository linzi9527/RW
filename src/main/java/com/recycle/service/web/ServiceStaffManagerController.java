package com.recycle.service.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.recycle.service.ServiceStaffImpl;
import com.recycle.service.model.MaintenancePoint;
import com.recycle.service.utils.Utils;
import com.summaryday.framework.d.IBaseDao;
import com.summaryday.framework.db.JsonUtil;
import com.summaryday.framework.db.SpringBeanHelper;


@Controller
@RequestMapping("/api")
public class ServiceStaffManagerController  {

	private static final Logger log = Logger.getLogger(ServiceStaffManagerController.class);
	
	@Resource
	private ServiceStaffImpl serviceStaff;
	/**
	 * e.g:select * from table_name limit 10,5

		limit关键字的用法：
		
		LIMIT [offset,] rows
		
		offset指定要返回的第一行的偏移量，rows第二个指定返回行的最大数目。初始行的偏移量是0(不是1)。
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/store/query/info")
	public void list_service_store_info(HttpServletRequest request,HttpServletResponse response){
		MaintenancePoint mp=Utils.beanFromJSONString(request, MaintenancePoint.class);
		List<MaintenancePoint> listmp=serviceStaff.list_service_store_info(mp);
		log.info("listmp.size:"+listmp.size());
		JsonUtil.returnData(response, listmp);

	}


	/**
	 * e.g:select * from table_name limit 10,5

		limit关键字的用法：
		
		LIMIT [offset,] rows
		
		offset指定要返回的第一行的偏移量，rows第二个指定返回行的最大数目。初始行的偏移量是0(不是1)。
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/store/querys")
	public void list_service_store(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		JSONObject obj=Utils.jsonObjectFromJSONString(request);
		 map=serviceStaff.service_store_info(obj);
		 log.info("map.size:"+map.size());
	    JsonUtil.returnMap(response, map);
	}
	
	
	@RequestMapping(value = "/store/update")
	public void update_service_store(HttpServletRequest request, HttpServletResponse response) {
		// TODO 自动生成的方法存根
		
	}
	
}
