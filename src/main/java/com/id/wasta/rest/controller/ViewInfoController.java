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
import com.id.wasta.bean.TIdProfileViewDetails;
import com.id.wasta.business.service.ViewInfoService;

@Controller
public class ViewInfoController {
	
	private static final Logger logger = Logger.getLogger(ViewInfoController.class);
	
	@Autowired
	private ViewInfoService  viewInfoService;
		
	@RequestMapping( value="/viewProfileInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse viewProfileInfo(@RequestParam(value = "pinKey") Long pinKey) {
		logger.info("Call View Profile info method -->");
		try {
			return new JsonResponse(viewInfoService.getViewProfileInfoDtls(pinKey), MessageTypeEnum.SUCCESS.getValue(), "viewProfileInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("View Profile info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "viewProfileInfo.failure", "invalid error", false);
	}
	
	@RequestMapping( value="/saveProfileInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveProfileInfoDtls(@RequestBody TIdProfileViewDetails tIdProfileViewDetails ) {
		logger.info("Call Save Profile View Details  info method -->");
		try {
			return new JsonResponse(viewInfoService.saveProfileDtls(tIdProfileViewDetails),MessageTypeEnum.SUCCESS.getValue(),"saveProfileInfo.success","save successfully",true);
		} catch (Exception e) {
			logger.info("Call Profile View Details Info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"saveProfileInfo.failure","invalid save credentials",false);
	}
	
	@RequestMapping( value="/auditLogInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse findAll(@RequestParam("primaryKey")Long primaryKey) {
		logger.info("Call View Audit log info method -->");
		try {
			return new JsonResponse(viewInfoService.getAudiLogInfoDtls(primaryKey), MessageTypeEnum.SUCCESS.getValue(), "auditLogInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("View Audit log info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "auditLogInfo.failure", "invalid error", false);
	}
	
	@RequestMapping( value="/distinctAuditLogInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse findDistinctAll(@RequestParam("primaryKey")Long primaryKey) {
		logger.info("Call View Audit log info method -->");
		try {
			return new JsonResponse(viewInfoService.getDistinctAudiLogInfoDtls(primaryKey), MessageTypeEnum.SUCCESS.getValue(), "auditLogInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("View Audit log info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "auditLogInfo.failure", "invalid error", false);
	}
	
	@RequestMapping( value="/changeLogInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getChangeLogInfoDtls(@RequestParam("screenName")String screenName,@RequestParam("primaryKey")Long primaryKey) {
		logger.info("Call Change Log Info  method -->");
		try {
			return new JsonResponse(viewInfoService.getChangeLogDtls(screenName,primaryKey), MessageTypeEnum.SUCCESS.getValue(), "changeLogInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Change log info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "changeLogInfo.failure", "invalid error", false);
	}

	@RequestMapping( value="/profileCompleteInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getProfileCompletePercentInfoDtls(@RequestParam("pinKey")Long pinKey) {
		logger.info("Call Profile Complete Percent Info  method -->");
		try {
			return new JsonResponse(viewInfoService.getProfileCompletePercentDtls(pinKey), MessageTypeEnum.SUCCESS.getValue(), "profileCompleteInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Profile Complete Percent info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "profileCompleteInfo.failure", "invalid error", false);
	}
	
	@RequestMapping( value="/CompletedProfilePercentage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getCompletedProfilePercentageInfo(@RequestParam("pinKey")Long pinKey) {
		logger.info("Call Profile Completed Profile Percentage Info  method -->");
		try {
			return new JsonResponse(viewInfoService.getCompletedProfilePercentageInfo(pinKey), MessageTypeEnum.SUCCESS.getValue(), "CompletedProfilePercentageInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Profile Completed Percent info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "getCompletedProfilePercentageInfo.failure", "invalid error", false);
	}
}
