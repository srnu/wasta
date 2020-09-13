package com.id.wasta.rest.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.id.util.StringUtil;
import com.id.util.bean.common.JsonResponse;
import com.id.util.enums.MessageTypeEnum;
import com.id.wasta.bean.TIdGroupHeader;
import com.id.wasta.business.service.GroupService;
import com.id.wasta.exception.HandledException;

@Controller
public class GroupController {
	
	private static final Logger logger = Logger.getLogger(GroupController.class);
	
	@Autowired
	private GroupService headerService;
	
	@RequestMapping(value = "/saveGroupDetails", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveOrUpdateGroupDetails(@RequestBody TIdGroupHeader tIdGroupHeader) {// it saves the parent and child records, if already available deletes the existing and saves the newly 
		try {
			logger.info("call saveOrUpdateGroupDetails method");
			return new JsonResponse(headerService.saveOrUpdateGroupDetails(tIdGroupHeader), MessageTypeEnum.SUCCESS.getValue(), "saveorupdate.rel.success", "saveorupdate Successful", true);			
		} catch (Exception e) { 
			logger.info("saveOrUpdateGroupDetails method throws Exception"+StringUtil.stack2string(e));
			if(e instanceof HandledException){
				return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"saveorupdate.rel.failure",e.getMessage(),false);
			}
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "saveorupdate.rel.failure", "saveorupdate failed", false);	
	}
		
	
	@RequestMapping( value="/getGroupList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getGroupList(@RequestParam(value = "createdBy") Long createdBy, @RequestParam(value = "searchString") String searchString) { //get list of parents along with their child records, based on parent createdBy
		logger.info("Call getHeaderAndChild By Id method -->");
		try {
			return new JsonResponse(headerService.getHeaderAndChild(createdBy, searchString), MessageTypeEnum.SUCCESS.getValue(), "getHeaderAndChild.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("getHeaderAndChild by Id method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "getHeaderAndChildById.failure", "invalid error", false);
	}
	
	@RequestMapping( value="/getGroupDtls", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getGroupDtls(@RequestParam(value = "id") Long id) {// get list of child records, based on parent primary key
		logger.info("Call getChildOnly By Id method -->");
		try {
			return new JsonResponse(headerService.retrieveChildOnly(id), MessageTypeEnum.SUCCESS.getValue(), "getChildOnly.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("getChildOnly by Id method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "getChildOnly.failure", "invalid error", false);
	}
	
	
	@RequestMapping(value = "/deleteGroup", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)	
	@ResponseBody
	public JsonResponse deleteGroupHeader(@RequestParam("groupKey") List<Long> groupKey) {//delete parent and child by passing parent primary key
		try {
			return new JsonResponse(headerService.deleteGroup(groupKey), MessageTypeEnum.SUCCESS.getValue(), "group.success", "group deleted successfully", true);
		}catch(Exception e) {
			logger.info("delete method throws Exception"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "delete.rel.failure", "deletion failed", false);
	}
	
	@RequestMapping(value = "/deleteGroupDtls", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)	
	@ResponseBody
	public JsonResponse deleteGroupDtls(@RequestParam("id") Long id) {// delete the child records, based on primary key
		try {
			return new JsonResponse(headerService.deleteGroupDtls(id), MessageTypeEnum.SUCCESS.getValue(), "child.success", "child deleted successfully", true);
		}catch(Exception e) {
			logger.info("delete method throws Exception"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "delete.rel.failure", "deletion failed", false);
	}
	
	//http://172.17.56.120:8080/wasta/searchGroupHeader?searchString=
	@RequestMapping(value = "/searchGroupHeader", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse searchGroupHeader(@RequestParam(value="searchString") String searchString) throws JsonParseException, JsonMappingException, IOException {
		searchString="%"+searchString+"%";
		try {
			return new JsonResponse(headerService.findByGroupHeaderName(searchString),MessageTypeEnum.SUCCESS.getValue(),"findByGroupHeaderName.success","findByGroupHeaderName retrieved successfully",true);
		} catch(Exception e) {
			logger.info("searchGroupHeader throws Exception"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"findByGroupHeaderName.not.found","findByGroupHeaderName not available",false);
	}
	
}
