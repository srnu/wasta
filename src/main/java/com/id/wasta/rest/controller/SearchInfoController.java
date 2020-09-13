package com.id.wasta.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.id.util.StringUtil;
import com.id.util.bean.common.JsonResponse;
import com.id.util.enums.MessageTypeEnum;
import com.id.wasta.business.service.SearchInfoService;

@Controller
public class SearchInfoController {

	private static final Logger logger = Logger.getLogger(SearchInfoController.class);
	
	@Autowired
	private SearchInfoService searchInfoService;
	
	@RequestMapping( value="/searchInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse searchInfo(@RequestParam(value = "searchKey") String searchKey,@RequestParam(value = "adminRole") boolean admin) {
		logger.info("Call search info method -->");
		try {
			return new JsonResponse(searchInfoService.getSearchInfoDtls(searchKey,admin), MessageTypeEnum.SUCCESS.getValue(), "searchInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.error("Search info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "searchInfo.failure", "invalid error", false);
	}
	
	
	/*
	@RequestMapping( value="/searchInfo_old", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse searchInfo2(@RequestParam(value = "searchKey") String searchKey,@RequestParam(value = "adminRole") boolean admin) {
		logger.info("Call search info method -->");
		try {
			return new JsonResponse(searchInfoService.getSearchInfoDtls2(searchKey,admin), MessageTypeEnum.SUCCESS.getValue(), "searchInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.error("Search info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "searchInfo.failure", "invalid error", false);
	}*/
	
}
