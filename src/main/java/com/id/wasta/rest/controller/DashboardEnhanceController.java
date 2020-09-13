package com.id.wasta.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.id.util.StringUtil;
import com.id.util.bean.common.JsonResponse;
import com.id.util.enums.MessageTypeEnum;
import com.id.wasta.bean.DashBoardRequestBean;
import com.id.wasta.business.service.DashboardEnhanceService;

@RestController
public class DashboardEnhanceController {
	private static final Logger logger = Logger.getLogger(DashboardEnhanceController.class);
	
	@Autowired
	private DashboardEnhanceService dashboardEnhanceService;
	
	@RequestMapping(value="/dashBoardEnhanceProfile", method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse dashBoardProfile(@RequestBody DashBoardRequestBean dashBoardRequestBean) {
		logger.info("Called dashBoardProfile  method -->");
		try {
			return new JsonResponse(dashboardEnhanceService.getDashBoardProfile(dashBoardRequestBean), MessageTypeEnum.SUCCESS.getValue(), "communicationInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("dashBoardProfile method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "dashBoardProfile.failure", "invalid error", false);
		
	}
	
	@RequestMapping(value="/completedashBoardProfile", method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse completeDashBoardProfile(@RequestBody DashBoardRequestBean dashBoardRequestBean) {
		logger.info("Called completeDashBoardProfile  method -->");
		try {
			return new JsonResponse(dashboardEnhanceService.getCompleteDashBoardProfile(dashBoardRequestBean), MessageTypeEnum.SUCCESS.getValue(), "communicationInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("completeDashBoardProfile method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "completeDashBoardProfile.failure", "invalid error", false);
		
	}

}
