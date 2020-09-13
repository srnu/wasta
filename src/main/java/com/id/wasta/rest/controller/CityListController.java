package com.id.wasta.rest.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.id.util.bean.common.JsonResponse;
import com.id.util.enums.MessageTypeEnum;
import com.id.wasta.bean.TIdCityStateCountryInfoView;
import com.id.wasta.business.service.CityStateCountryService;

@Controller
public class CityListController {

    @Resource
	private CityStateCountryService cityStateCountryService;

	@RequestMapping(value = "/autosuggestion/cities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse createCustomer(@RequestParam(value="searchString") String searchString) throws JsonParseException, JsonMappingException, IOException {
		searchString="%"+searchString+"%";
		List<TIdCityStateCountryInfoView> cityList=cityStateCountryService.findCityByName(searchString);
		if(cityList.size()>0)
			return new JsonResponse(cityList,MessageTypeEnum.SUCCESS.getValue(),"city retrieved successfully","city retrieved successfully",true);
		else
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"city.not.found","City not available",false);
	}
	/*
	@RequestMapping(value = "/autosuggestion/city", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getCities(@RequestParam(value="searchString") String searchString) throws JsonParseException, JsonMappingException, IOException {
		searchString="%"+searchString+"%";
		List cityList=cityStateCountryService.findCityByName1(searchString);
		if(cityList.size()>0)
			return new JsonResponse(cityList,MessageTypeEnum.SUCCESS.getValue(),"city retrieved successfully","city retrieved successfully",true);
		else
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"city.not.found","City not available",false);
	}
	*/
}
