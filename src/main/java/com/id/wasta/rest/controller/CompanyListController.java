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
import com.id.util.bean.common.SelectListBean;
import com.id.util.enums.MessageTypeEnum;
import com.id.wasta.business.service.CompanyListService;

@Controller
public class CompanyListController {

    @Resource
    private CompanyListService companyListService;

	@RequestMapping(value = "autosuggestion/groupcompanies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse createCustomer(@RequestParam(value="searchString") String searchString,@RequestParam(value="profileKey") Long profileKey) throws JsonParseException, JsonMappingException, IOException {
		searchString=searchString+"%";
		List<SelectListBean> selectList=companyListService.getGroupCompaniesList(searchString, profileKey);
		if(selectList.size()>0)
			return new JsonResponse(selectList,MessageTypeEnum.SUCCESS.getValue(),"Group companies retrieved successfully","group company retrieved successfully",true);
		else
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"company.group.not.found","Group companies not available",false);
	}
	
	@RequestMapping(value = "getSelectListGoupCompany", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse retrieveGroupCmp(@RequestParam(value="profileKey") Long profileKey) throws JsonParseException, JsonMappingException, IOException {
		List<SelectListBean> selectList=companyListService.getGroupCompany(profileKey);
		if(selectList.size()>0)
			return new JsonResponse(selectList,MessageTypeEnum.SUCCESS.getValue(),"Group companies retrieved successfully","group company retrieved successfully",true);
		else
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"company.group.not.found","Group companies not available",false);
	}
	
}
