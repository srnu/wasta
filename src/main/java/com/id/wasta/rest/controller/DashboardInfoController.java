package com.id.wasta.rest.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.id.util.StringUtil;
import com.id.util.bean.common.JsonResponse;
import com.id.util.enums.MessageTypeEnum;
import com.id.wasta.bean.DashBoardRequestBean;
import com.id.wasta.bean.TIdAdditionalInformation;
import com.id.wasta.bean.TIdAwardsInformation;
import com.id.wasta.bean.TIdEducationalInformation;
import com.id.wasta.bean.TIdExperienceInformation;
import com.id.wasta.bean.TIdMiscInformation;
import com.id.wasta.bean.TIdProjectsInformation;
import com.id.wasta.bean.TIdVisitInformation;
import com.id.wasta.business.service.DashboardInfoService;
import com.id.wasta.exception.HandledException;

@Controller
public class DashboardInfoController {

	private static final Logger logger = Logger.getLogger(DashboardInfoController.class);

	@Autowired
	private DashboardInfoService dashboardInfoService;
	
	@RequestMapping( value="/awardInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse awardInfo(@RequestBody DashBoardRequestBean dashBoardRequest) {
		logger.info("Call award info method -->");
		try {
			return new JsonResponse(dashboardInfoService.getAwardInfoDtls(dashBoardRequest), MessageTypeEnum.SUCCESS.getValue(), "awardInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Award info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "awardInfo.failure", "invalid error", false);
	}
	
	@RequestMapping( value="/getExperienceInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse experiencedInfo(@RequestBody DashBoardRequestBean dashBoardRequest)throws JsonParseException,IOException,JsonMappingException {
		logger.info("Call experience info method -->");
		try {
			return new JsonResponse(dashboardInfoService.getExperienceInfoDtls(dashBoardRequest), MessageTypeEnum.SUCCESS.getValue(), "experienceInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Experience info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "experienceInfo.failure", "invalid error", false);
	}
	
	@RequestMapping( value="/experienceInfoView/findById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse experiencedInfoById(@RequestParam(value = "id") Long id) {
		logger.info("Call experience info By Id method -->");
		try {
			return new JsonResponse(dashboardInfoService.getExperienceInfoDtlsById(id), MessageTypeEnum.SUCCESS.getValue(), "experienceInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Experience info by Id method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "experienceInfoById.failure", "invalid error", false);
	}
	
	@RequestMapping( value="/visitInfoView/findById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse visitInfoById(@RequestParam(value = "id") Long id) {
		logger.info("Call visit info By Id method -->");
		try {
			return new JsonResponse(dashboardInfoService.getVisitInfoDtlsById(id), MessageTypeEnum.SUCCESS.getValue(), "visitInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Visit info by Id method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "visitInfoById.failure", "invalid error", false);
	}
	
	@RequestMapping( value="/visitInfoDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse visitInfoDecode(@RequestParam(value = "decode") String decode) {
		logger.info("Call visit info By Id method -->");
		try {
			return new JsonResponse(dashboardInfoService.getVisitInfoDecode(decode), MessageTypeEnum.SUCCESS.getValue(), "visitInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Visit info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "visitInfoById.failure", "invalid error", false);
	}
	
	@RequestMapping( value="/additionalInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse additionalInfo(@RequestBody DashBoardRequestBean dashBoardRequest) {
		logger.info("Call additional experience info method -->");
		try {
			return new JsonResponse(dashboardInfoService.getAdditionalInfoDtls(dashBoardRequest), MessageTypeEnum.SUCCESS.getValue(), "additionalInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Additional Experience info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "additionalInfo.failure", "invalid error", false);
	}
	
	
	@RequestMapping( value="/miscInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse miscInfo(@RequestParam(value = "pinKey") Long pinKey, @RequestParam(value = "miscType") String miscType) {
 		logger.info("Call misc info method -->");
		try {
			return new JsonResponse(dashboardInfoService.getMiscInfoDtls(pinKey, miscType), MessageTypeEnum.SUCCESS.getValue(), "miscInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Misc info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "miscInfo.failure", "invalid error", false);
	}
	
	@RequestMapping( value="/viewProfExpert", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse viewProfExpert(@RequestParam(value = "pinKey") Long pinKey) {
 		logger.info("Call Professional Expert  info view method -->");
		try {
			return new JsonResponse(dashboardInfoService.getViewProfExpert(pinKey), MessageTypeEnum.SUCCESS.getValue(), "viewProfExpert.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Professional Expert info view method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "viewProfExpert.failure", "invalid error", false);
	}
	
	
	@RequestMapping( value="/educationalInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse educationalInfo(@RequestBody DashBoardRequestBean dashBoardRequest) {
		logger.info("Call educational info method -->");
		try {
			
			return new JsonResponse(dashboardInfoService.getEducationalInfoDtls(dashBoardRequest), MessageTypeEnum.SUCCESS.getValue(), "educationalInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Educational info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "educationalInfo.failure", "invalid error", false);
	}
	
	

	@RequestMapping( value="/specializationInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse specializationInfo(@RequestParam(value = "peiKey") Long peiKey) {
		logger.info("Call specialization info method -->");
		try {
			
			return new JsonResponse(dashboardInfoService.getSpecializationlInfoDtls(peiKey), MessageTypeEnum.SUCCESS.getValue(), "specializationInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Specialization info  method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "specializationInfo.failure", "invalid error", false);
	}

	@RequestMapping( value="/getProjectsInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse projectslInfo(@RequestBody DashBoardRequestBean dashBoardRequest) {
		logger.info("Call projects info method -->");
		try {
			return new JsonResponse(dashboardInfoService.getProjectsInfoDtls(dashBoardRequest), MessageTypeEnum.SUCCESS.getValue(), "projectsInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Projects info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "projectsInfo.failure", "invalid error", false);
	}
	
	
	@RequestMapping( value="/getCommunicationInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse communicationInfo(@RequestBody DashBoardRequestBean dashBoardRequest) {
		logger.info("Call communication info method -->");
		try {
			return new JsonResponse(dashboardInfoService.getCommunicationInfoDtls(dashBoardRequest), MessageTypeEnum.SUCCESS.getValue(), "communicationInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Communication info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "communicationInfo.failure", "invalid error", false);
	}
	
	
	@RequestMapping( value="/languageInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse languageInfo(@RequestParam(value = "pinKey") Long pinKey) {
		logger.info("Call language info method -->");
		try {
			return new JsonResponse(dashboardInfoService.getLanguageInfoDtls(pinKey), MessageTypeEnum.SUCCESS.getValue(), "languageInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Language info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "languageInfo.failure", "invalid error", false);
	}
    

	@RequestMapping( value="/getVisitInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse visitInfo(@RequestBody DashBoardRequestBean dashBoardRequestBean) {
		logger.info("Call visit info method -->");
		try {
			return new JsonResponse(dashboardInfoService.getVisitInfoDtls(dashBoardRequestBean), MessageTypeEnum.SUCCESS.getValue(), "visitInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Visit info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "visitInfo.failure", "invalid error", false);
	}
	
	
	@RequestMapping( value="/getRelationshipInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse relationshipInfo(@RequestBody DashBoardRequestBean dashBoardRequestBean) {
		logger.info("Call Relationship info method -->");
		try {
			return new JsonResponse(dashboardInfoService.getRelationshipInfoDtls(dashBoardRequestBean), MessageTypeEnum.SUCCESS.getValue(), "relationshipInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Relationship info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "relationshipInfo.failure", "invalid error", false);
	}
	
	@RequestMapping( value="/relationshipGroupInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse relationshipGrpInfo(@RequestParam(value = "pinKey") Long pinKey, @RequestParam(value = "relationType") String relationType) {
		logger.info("Call Relationship info method -->");
		try {
			return new JsonResponse(dashboardInfoService.getRelationshipGrpInfoDtls(pinKey, relationType), MessageTypeEnum.SUCCESS.getValue(), "relationshipInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Relationship info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "relationshipInfo.failure", "invalid error", false);
	}
	
	@RequestMapping( value="/personalInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse profileInfo(@RequestParam(value = "profileKey") Long profileKey) {
		logger.info("Call Personal Information View info method -->");
		try {
			return new JsonResponse(dashboardInfoService.getPersonalInfoDtls(profileKey), MessageTypeEnum.SUCCESS.getValue(), "personalInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Personal Information View info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "personalInfo.failure", "invalid error", false);
	}
	
	@RequestMapping( value="/instituteViewInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse instituteInfo(@RequestParam(value = "profileKey") Long profileKey) {
		logger.info("Call institute info method -->");
		try {
			return new JsonResponse(dashboardInfoService.getInstituteInfoDtls(profileKey), MessageTypeEnum.SUCCESS.getValue(), "institute.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Institute info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "institute.failure", "invalid error", false);
	}

	@RequestMapping( value="/educationInfo", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveEducationDtls(@RequestBody TIdEducationalInformation tIdEducationalInformation)
	{
		logger.info("call Educational Information save method !!!");
		try{
			String message = null;
			if(tIdEducationalInformation.getPeiKey()!=null) {
				message = "Successfully updated the record";
			} else {
				message = "Successfully save the record";
			}
			return new JsonResponse(dashboardInfoService.saveEducationInfo(tIdEducationalInformation),MessageTypeEnum.SUCCESS.getValue(),"educationInfo.success",message,true);
		}catch(Exception e)
		{
			if(e instanceof DataIntegrityViolationException)
			{
				return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"Educational Information save .failure",e.getMessage(),false);
			}
			logger.info("call Educational Information save method exception -->"+StringUtil.stack2string(e));
			
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"educationInfo.failure","invalid credentials",false);
	}
	
	@RequestMapping( value="/experienceInfo", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveExperienceDtls(@RequestBody TIdExperienceInformation tIdExperienceInformation)
	{
		logger.info("call Experience Information save method !!!");
		String split[];
		try{
			String message = null;
			if(tIdExperienceInformation.getPexKey()!=null) {
				message = "Successfully  updated the record";
			} else {
				message = "Successfully save the record";
			}
			return new JsonResponse(dashboardInfoService.saveExperienceInfo(tIdExperienceInformation),MessageTypeEnum.SUCCESS.getValue(),"experienceInfo.success",message,true);
		}catch(Exception e)
		{
			if(e instanceof DataIntegrityViolationException)
			{
				return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"Experience Information save .failure",e.getMessage(),false);
			}else if(e instanceof HandledException) {
				split= e.getMessage().split("::");
				return new JsonResponse(null, split[0], "duplicate.profile", split[1] , false);
			}
			logger.info("call Experience Information save method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"experienceInfo.failure","invalid credentials",false);
	}	
	
	@RequestMapping( value="/visitInfo", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveVisitDtls(@RequestBody TIdVisitInformation tIdVisitInformation)
	{
		logger.info("call Visit Information save method !!!");
		try{
			String message = null;
			if(tIdVisitInformation.getPivKey()!=null) {
				message = "Successfully updated the record";
			} else {
				message = "Successfully save the record";
			}
			dashboardInfoService.saveVisitInfo(tIdVisitInformation);
			return new JsonResponse(dashboardInfoService.discussionMailConf(tIdVisitInformation),MessageTypeEnum.SUCCESS.getValue(),"visitInfo.success",message,true);
		}catch(Exception e)
		{
			if(e instanceof DataIntegrityViolationException){
				return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"Visit Information save .failure",e.getMessage(),false);
			}
			logger.info("call Visit Information save method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"visitInfo.failure","invalid credentials",false);
		
	}	
	
	@RequestMapping( value="/addnlInfo", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveAdditionalDtls(@RequestBody TIdAdditionalInformation tIdAdditionalInformation)
	{
		logger.info("call Additional Information save method !!!");
		try{
			String message = null;
			if(tIdAdditionalInformation.getPiadKey()!=null) {
				message = "Successfully  updated the record";
			} else {
				message = "Successfully save the record";
			}
			return new JsonResponse(dashboardInfoService.saveAdditionalInfo(tIdAdditionalInformation),MessageTypeEnum.SUCCESS.getValue(),"additionalInfo.success",message,true);
		}catch(Exception e)
		{
			logger.info("call Additional  Information save method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"additionalInfo.failure","invalid credentials",false);
		
	}
	
	@RequestMapping( value="/awardsInfo", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveAwardsDtls(@RequestBody TIdAwardsInformation tIdAwardsInformation)
	{
		logger.info("call Awards Information save method !!!");
		try{
			String message = null;
			if(tIdAwardsInformation.getPiaKey()!=null) {
				message = "Successfully  updated the record";
			} else {
				message = "Successfully save the record";
			}
			return new JsonResponse(dashboardInfoService.saveAwardsInfo(tIdAwardsInformation),MessageTypeEnum.SUCCESS.getValue(),"awardsInfo.success",message,true);
		}catch(Exception e)
		{
			if(e instanceof DataIntegrityViolationException){
				return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"Award Information save .failure",e.getMessage(),false);
			}
			logger.info("call Awards Information save method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"awardsInfo.failure","invalid credentials",false);
		
	}
	
	@RequestMapping( value="/projectsInfo", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveProjectsDtls(@RequestBody TIdProjectsInformation tIdProjectsInformation)
	{
		logger.info("call Projects Information save method !!!");
		try{
			String message = null;
			if(tIdProjectsInformation.getPipKey()!=null) {
				message = "Successfully  updated the record";
			} else {
				message = "Successfully save the record";
			}
			return new JsonResponse(dashboardInfoService.saveProjectsInfo(tIdProjectsInformation),MessageTypeEnum.SUCCESS.getValue(),"projectsInfo.success",message,true);
		}catch(Exception e)
		{
			if(e instanceof DataIntegrityViolationException){
				return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"Projects Information save .failure",e.getMessage(),false);
			}
			logger.info("call Projects Information save method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"projectsInfo.failure","invalid credentials",false);
	}
	
	@RequestMapping( value="/miscInfo", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveMiscInfoDtls(@RequestBody TIdMiscInformation tIdMiscInformation)
	{
		logger.info("call Misc Information save method !!!");
		try{
			String message = null;
			if(tIdMiscInformation.getPimiKey()!=null) {
				message = "Successfully  updated the record";
			} else {
				message = "Successfully save the record";
			}
			return new JsonResponse(dashboardInfoService.saveMiscInfo(tIdMiscInformation),MessageTypeEnum.SUCCESS.getValue(),"miscInfo.success",message,true);
		}catch(Exception e)
		{
			logger.info("call Misc Information save method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"miscInfo.failure","invalid credentials",false);	
	}
	
	@RequestMapping( value="/saveProfExpert", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveMiscProfessionalExpertiseInfoDtls(@RequestBody TIdMiscInformation tIdMiscInformation)
	{
		logger.info("call Misc Professional Expertise Information save method !!!");
		try{
			String message = null;
			if(tIdMiscInformation.getPimiKey()!=null) {
				message = "Successfully  updated the record";
			} else {
				message = "Successfully save the record";
			}
			return new JsonResponse(dashboardInfoService.saveMiscProfessionalExpertiseInfo(tIdMiscInformation),MessageTypeEnum.SUCCESS.getValue(),"saveProfExpert.success",message,true);
		}catch(Exception e)
		{
			logger.info("call Misc Professional Expertise Information save method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"saveProfExpert.failure","invalid credentials",false);
	}
	
	@RequestMapping( value="/getRelationshipGroupInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse relationshipGrpInfoDetails(@RequestBody DashBoardRequestBean dashBoardRequest) {
		logger.info("Call Relationship info method -->");
	try {
		return new JsonResponse(dashboardInfoService.getRelationshipGrpInfoDtl(dashBoardRequest), MessageTypeEnum.SUCCESS.getValue(), "relationshipInfo.success", "record retrieved", true);
	} catch (Exception e) {
		logger.info("Relationship info method exception -->"+StringUtil.stack2string(e));
	}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "relationshipInfo.failure", "invalid error", false);
	}

	@RequestMapping( value="/communicationInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse communicationInfo(@RequestParam(value = "pinKey") Long pinKey) {
		logger.info("Call communication info method -->");
		try {
			return new JsonResponse(dashboardInfoService.getCommunicationInfoDtl(pinKey), MessageTypeEnum.SUCCESS.getValue(), "communicationInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("Communication info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "communicationInfo.failure", "invalid error", false);
	}
	
}
