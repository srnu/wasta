package com.id.wasta.rest.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.id.util.StringUtil;
import com.id.util.bean.common.JsonResponse;
import com.id.util.bean.common.SelectListBean;
import com.id.util.enums.MessageTypeEnum;
import com.id.wasta.business.service.DiscussionInfoService;
import com.id.wasta.exception.HandledException;

@Controller
public class DiscussionInfocontroller {
	
	private static final Logger logger = Logger.getLogger(DiscussionInfocontroller.class);

	@Autowired
	private DiscussionInfoService discussionInfoService;
	
	
	@RequestMapping(value = "/discussionRelationInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getDiscussionRelationInfo(@RequestParam(value = "pinKey") Long pinKey)
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call discussionRelationInfo  ");
		try {
			
			return new JsonResponse(discussionInfoService.getDiscussionRelation(pinKey), MessageTypeEnum.SUCCESS.getValue(), "discussionRelationInfo.success", "record retrieved", true);
		} catch (Exception e) {
			if(e instanceof HandledException) {
				return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "getDiscussionRelationInfo.failure", e.getMessage(), false);
			}
			logger.info("getDiscussionRelationInfo -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "getDiscussionRelationInfo.failure", "unable to retrieve", false);
	}
	
	
	@RequestMapping(value = "/discussionCustInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getDiscussionCustInfo(@RequestParam(value = "profileKey") Long profileKey)
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call discussionRelationInfo  ");
		try {
			
			return new JsonResponse(discussionInfoService.getDiscussionCustInfo(profileKey), MessageTypeEnum.SUCCESS.getValue(), "discussionRelationInfo.success", "record retrieved", true);
		} catch (Exception e) {
			if(e instanceof HandledException) {
				return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "getDiscussionRelationInfo.failure", e.getMessage(), false);
			}
			logger.info("getDiscussionCustInfo -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "getDiscussionRelationInfo.failure", "unable to retrieve", false);
	}
	
	@RequestMapping(value = "/discussionCustInfoAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getDiscussionCustInfoAll()
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call discussionCustInfo All-->  ");
		try {
			List<SelectListBean> selectListBeanList=discussionInfoService.getDiscussionCustInfoAllDtls();
			if(selectListBeanList!=null && selectListBeanList.size()>0){
			return new JsonResponse(selectListBeanList, MessageTypeEnum.SUCCESS.getValue(), "discussionCustInfoAll.success", "record retrieved", true);
			}
		} catch (Exception e) {
			
			logger.info("getDiscussionCustInfo All -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "discussionCustInfoAll.failure", "unable to retrieve", false);
	}
	
	@RequestMapping(value = "/discussionUserInfoAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getDiscussionUserInfoAll()
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call discussionUserInfo All-->  ");
		try {
			List<SelectListBean> selectListBeanList=discussionInfoService.getDiscussionUserInfoAllDtls();
			if(selectListBeanList!=null && selectListBeanList.size()>0){
			return new JsonResponse(selectListBeanList, MessageTypeEnum.SUCCESS.getValue(), "discussionUserInfoAll.success", "record retrieved", true);
			}
		} catch (Exception e) {
			
			logger.info("getDiscussionUserInfo All -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "discussionUserInfoAll.failure", "unable to retrieve", false);
	}
	
	@RequestMapping(value = "/chkDiscApproval", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public  JsonResponse chkDiscussionApproval(@RequestParam(value = "pinKey") Long pinKey) throws JsonParseException, JsonMappingException, IOException{
		logger.info("Call chkDiscussionApproval All-->  ");		
			
		try{			
			 return new JsonResponse(discussionInfoService.chkDiscussionApprovalDtls(pinKey),MessageTypeEnum.SUCCESS.getValue(), "chkDiscussionApprovalDtls.success", "record retrieved", true);
		
		}catch(Exception e){
			logger.info("chkDiscussionApprovalDtls All -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "chkDiscussionApprovalDtls.failure", "unable to retrieve", false);		
		
	}
	
	@RequestMapping(value = "/getDiscApprovInfoDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getDiscApprovInfoDetails(@RequestParam(value = "pinKey") Long pinKey,@RequestParam(value = "status") String status) throws JsonParseException, JsonMappingException, IOException{
		logger.info("Call getVisitedCustInfoDetails All-->  ");
		try{
			return new JsonResponse(discussionInfoService.getDiscApprovInfoDetails(pinKey, status),MessageTypeEnum.SUCCESS.getValue(), "getDiscApprovInfoDetails.success", "record retrieved", true);
			
		}catch(Exception e){
			logger.info("getDiscApprovInfoDetails All -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "getDiscApprovInfoDetails.failure", "unable to retrieve", false);
	}
	
}
