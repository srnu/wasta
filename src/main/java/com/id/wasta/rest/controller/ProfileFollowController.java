package com.id.wasta.rest.controller;

import org.apache.log4j.Logger;
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
import com.id.wasta.bean.TIdProfileFollowDetails;
import com.id.wasta.business.service.ProfileFollowService;

@Controller
public class ProfileFollowController {
	
	private static final Logger logger = Logger.getLogger(ProfileFollowController.class);
	
	@Autowired
	private ProfileFollowService  profileFollowService;
		
	@RequestMapping( value="/profileFollowInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveProfileFollowInfo(@RequestBody TIdProfileFollowDetails tIdProfileFollowDetails) {
		logger.info("Call Profile Follow info method -->");
		try {
			Long key=Long.valueOf(profileFollowService.saveProfileFollowInfoDtls(tIdProfileFollowDetails));
			if(key!=null){
			return new JsonResponse(key, MessageTypeEnum.SUCCESS.getValue(), "profileFollowInfo.success", "record saved successfully", true);
			}
		} catch (Exception e) {
			logger.info("Profile Follow info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "profileFollowInfo.failure", "invalid error", false);
	}
	
	@RequestMapping( value="/profileUnfollowInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveProfileUnfollowInfo(@RequestBody TIdProfileFollowDetails tIdProfileFollowDetails) {
		logger.info("Call Profile Unfollow info method -->");
		try {
			return new JsonResponse(profileFollowService.saveProfileUnfollowInfoDtls(tIdProfileFollowDetails), MessageTypeEnum.SUCCESS.getValue(), "profileUnfollowInfo.success", "record deleted successfully", true);
		} catch (Exception e) {
			logger.info("Profile Unfollow info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "profileUnfollowInfo.failure", "invalid error", false);
	}
	
	@RequestMapping( value="/getFollowInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getProfileFollowInfo(@RequestParam("pinKey") Long pinKey) {
		logger.info("Call follow profile search info method -->");
		try {
			return new JsonResponse(profileFollowService.getProfileFollowInfoDtls(pinKey), MessageTypeEnum.SUCCESS.getValue(), "getFollowInfo.success", "record retrieved successfully", true);
		} catch (Exception e) {
			logger.info("Follow Profile Search info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "getFollowInfo.failure", "invalid error", false);
	}
	
	@RequestMapping( value="/getUniqueFollowInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getProfileUniqueFollowInfo(@RequestParam("pinKey") Long pinKey,@RequestParam("followedByKey") Long followedByKey) {
		logger.info("Call follow profile Unique search info method -->");
		try {
			return new JsonResponse(profileFollowService.getProfileUniqueFollowInfoDtls(pinKey,followedByKey), MessageTypeEnum.SUCCESS.getValue(), "getUniqueFollowInfo.success", "record retrieved successfully", true);
		} catch (Exception e) {
			logger.info("Follow Profile Unique Search info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "getUniqueFollowInfo.failure", "invalid error", false);
	}
}
