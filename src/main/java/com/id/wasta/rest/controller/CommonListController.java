package com.id.wasta.rest.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.id.util.bean.common.JsonResponse;
import com.id.util.bean.common.SelectListBean;
import com.id.util.enums.MessageTypeEnum;
import com.id.wasta.business.service.CommonListService;

@Controller
public class CommonListController {

    @Resource
	private CommonListService commonListService;

	@RequestMapping(value = "getRetrievePosition", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse retrievePosition(@RequestParam(value="pinKey") Long pinKey) throws JsonParseException, JsonMappingException, IOException {
		List<SelectListBean> selectList=commonListService.getRetrievePosition(pinKey);
		if(selectList.size()>0)
			return new JsonResponse(selectList,MessageTypeEnum.SUCCESS.getValue(),"retrieved successfully","retrieved successfully",true);
		else
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"retrieve.error","retrieve error",false);
	}
	
	@RequestMapping(value = "getRetriveProvidedBy", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse retrieveProvidedBy(@RequestParam(value="pinKey") Long pinKey) throws JsonParseException, JsonMappingException, IOException {
		List<SelectListBean> selectList=commonListService.getRetrieveProvidedBy(pinKey);
		if(selectList.size()>0)
			return new JsonResponse(selectList,MessageTypeEnum.SUCCESS.getValue(),"retrieved successfully","retrieved successfully",true);
		else
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"retrieve.error","retrieve error",false);
	}
	
	@RequestMapping(value = "getRetriveRelationship", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse retriveRelationship(@RequestParam(value="pinKey") Long pinKey) throws JsonParseException, JsonMappingException, IOException {
		List<SelectListBean> selectList=commonListService.getRetriveRelationship(pinKey);
		if(selectList.size()>0)
			return new JsonResponse(selectList,MessageTypeEnum.SUCCESS.getValue(),"retrieved successfully","retrieved successfully",true);
		else
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"retrieve.error","retrieve error",false);
	}
}
