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
import com.id.wasta.bean.LandingInfoBean;
import com.id.wasta.bean.TIdLandingNotification;
import com.id.wasta.bean.ToolTipNotificationLandBean;
import com.id.wasta.business.service.LandingInfoService;

 

@Controller
public class LandingInfoController {

	private static final Logger logger = Logger.getLogger(LandingInfoController.class);

	@Autowired
	private LandingInfoService landingInfoService;
	
	@RequestMapping( value="/landPageLeftMenu",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse landMenuCount(@RequestBody LandingInfoBean landingInfoBean) {
		logger.info("Call land master count method -->");
		try {
			return new JsonResponse(landingInfoService.getLandMenuCount(landingInfoBean.getCreatedOn(), landingInfoBean.getLoggedPinKey()),MessageTypeEnum.SUCCESS.getValue(),"land.master.success","successfully retrieved",true);
		} catch (Exception e) {
			logger.info("Land master method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"land.master.failure",e.getLocalizedMessage(),false);
		}
	}
	
	@RequestMapping( value="/landPageList",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse landPageList(@RequestBody LandingInfoBean landingInfoBean) {
		logger.info("Call land page list method -->");
		try {
			return new JsonResponse(landingInfoService.getLandPageList(landingInfoBean.getLdBoxName(),landingInfoBean.getCreatedOn(),landingInfoBean.getLoggedPinKey(),
					landingInfoBean.getPage(),landingInfoBean.getSize()),MessageTypeEnum.SUCCESS.getValue(),"land.page.success","successfully retrieved",true);
		} catch (Exception e) {
			logger.info("Land page list method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"land.page.failure",e.getLocalizedMessage(),false);
		}
	}
	
	@RequestMapping( value="/landPageList1",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse landPageList1(@RequestBody LandingInfoBean landingInfoBean) {
		logger.info("Call land page list method -->");
		try {
			ToolTipNotificationLandBean toolTipNotificationLandBean = landingInfoService.getToolTipDataLanding(landingInfoBean.getLdBoxName(),landingInfoBean.getCreatedOn(),landingInfoBean.getLoggedPinKey(),
					landingInfoBean.getPage(),landingInfoBean.getSize());
			if(toolTipNotificationLandBean!=null) {
				return new JsonResponse(toolTipNotificationLandBean,MessageTypeEnum.SUCCESS.getValue(),"land.page.success","successfully retrieved",true);
			}
			else {
				return new JsonResponse(toolTipNotificationLandBean,MessageTypeEnum.SUCCESS.getValue(),"land.page.success","Data Not Available",false);
			}
		} catch (Exception e) {
			logger.info("Land page list method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"land.page.failure",e.getLocalizedMessage(),false);
		}
	}
	
	@RequestMapping( value="/getAuditLogList",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getAuditLogList(@RequestParam(value = "pinKey") Long pinKey, @RequestParam(value = "page") int page,
			@RequestParam(value = "size") int size) {
		logger.info("Call getAuditLogList method -->");
		try {
			return new JsonResponse(landingInfoService.getAuditLogList(pinKey, page, size),MessageTypeEnum.SUCCESS.getValue(),"audit.logs.success","successfully retrieved",true);
		} catch (Exception e) {
			logger.info("getAuditLogList method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"audit.log.failure",e.getLocalizedMessage(),false); 
		}
	}
	
	@RequestMapping( value="/saveNotification",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveNotification(@RequestBody TIdLandingNotification tIdLandingNotification) {
		logger.info("Call saveNotification method -->");
		try {
			return new JsonResponse(landingInfoService.saveNotification(tIdLandingNotification),MessageTypeEnum.SUCCESS.getValue(),"land.page.success","successfully retrieved",true);
		} catch (Exception e) {
			logger.info("saveNotification method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"land.page.failure",e.getLocalizedMessage(),false);
		}
	}
	
	@RequestMapping( value="/removeNotification",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse removeRejNotification(@RequestBody TIdLandingNotification tIdLandingNotification) {
		logger.info("Call saveNotification method -->");
		try {
			return new JsonResponse(landingInfoService.removeNotification(tIdLandingNotification),MessageTypeEnum.SUCCESS.getValue(),"land.page.success","successfully retrieved",true);
		} catch (Exception e) {
			logger.info("saveNotification method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"land.page.failure",e.getLocalizedMessage(),false);
		}
	}
	
	//3. getNotificationLeftMenu -- left menu
	@RequestMapping( value="/getNotificationLeftMenu",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getNotificationLeftMenu(@RequestBody LandingInfoBean landingInfoBean) {
		logger.info("Call getNotification method -->");
		try {
			return new JsonResponse(landingInfoService.getNotificationLeftMenu(landingInfoBean.getLoggedPinKey()),MessageTypeEnum.SUCCESS.getValue(),"getNotification.logs.success","successfully retrieved",true);
		} catch (Exception e) {
			logger.info("getNotification method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"getNotification.log.failure",e.getLocalizedMessage(),false); 
		}
	}
	
	//4. getNotificationLandList -- landing list
	@RequestMapping( value="/getNotificationList",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getNotificationList(@RequestBody LandingInfoBean landingInfoBean) {
		logger.info("Call getNotification method -->");
		try {
			return new JsonResponse(landingInfoService.getNotificationList(landingInfoBean.getLdBoxName(),landingInfoBean.getLoggedPinKey(),
					landingInfoBean.getPage(), landingInfoBean.getSize()),MessageTypeEnum.SUCCESS.getValue(),"getNotification.logs.success","successfully retrieved",true);
		} catch (Exception e) {
			logger.info("getNotification method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"getNotification.log.failure",e.getLocalizedMessage(),false); 
		}
	}
	
	//4. getNotificationLandList -- landing list
		@RequestMapping( value="/getNotificationList1",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public JsonResponse getNotificationList1(@RequestBody LandingInfoBean landingInfoBean) {
			logger.info("Call getNotification method -->");
			try {
				
				ToolTipNotificationLandBean toolTipNotificationLandBean = landingInfoService.getToolTipDataNotification(landingInfoBean.getLdBoxName(),landingInfoBean.getLoggedPinKey(),
						landingInfoBean.getPage(), landingInfoBean.getSize());
				if(toolTipNotificationLandBean!=null) {
					return new JsonResponse(toolTipNotificationLandBean,MessageTypeEnum.SUCCESS.getValue(),"getNotificationList1.logs.success","successfully retrieved",true);
				}
				else {
					return new JsonResponse(toolTipNotificationLandBean,MessageTypeEnum.SUCCESS.getValue(),"getNotificationList1.logs.success","Data Not Available",false);
				}
				
			} catch (Exception e) {
				logger.info("getNotification method exception -->"+StringUtil.stack2string(e));
				return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"getNotification.log.failure",e.getLocalizedMessage(),false); 
			}
		}
	

	//Read the notificaiton list
	@RequestMapping( value="/updateNotification",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse updateNotification(@RequestParam(value = "ldKey") Long ldKey) {
		logger.info("Call updateNotification method -->");
		try {
			return new JsonResponse(landingInfoService.updateNotification(ldKey),MessageTypeEnum.SUCCESS.getValue(),"updateNotification.logs.success","successfully retrieved",true);
		} catch (Exception e) {
			logger.info("updateNotification method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"updateNotification.log.failure",e.getLocalizedMessage(),false); 
		}
	}
	
	//1.landTopMenuCount:
	@RequestMapping( value="/getTopMenuCount",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getTopMenuCount(@RequestBody LandingInfoBean landingInfoBean) {
		logger.info("Call getTopMenuCount method -->");
		try {
			return new JsonResponse(landingInfoService.getTopMenuCount(landingInfoBean.getLdUserPinKey(),landingInfoBean.getCreatedOn()),MessageTypeEnum.SUCCESS.getValue(),"getTopMenuCount.logs.success","successfully retrieved",true);
		} catch (Exception e) {
			logger.info("getTopMenuCount method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"getTopMenuCount.log.failure",e.getLocalizedMessage(),false); 
		}
	}//It gets the list of top menu names and its count
	
	//2.getContactsInfo(on MouseOver)
	@RequestMapping( value="/getContactsInfo",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getContactsInfo() {
		logger.info("Call getContactsInfo method -->");
		try {
			return new JsonResponse(landingInfoService.getContactsInfo(),MessageTypeEnum.SUCCESS.getValue(),"getContactsInfo.logs.success","successfully retrieved",true);
		} catch (Exception e) {
			logger.info("getContactsInfo method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"getContactsInfo.log.failure",e.getLocalizedMessage(),false); 
		}
	}//It shows the traceable and non-traceable count when we mouse over on contacts menu
	
	//7. getMyContactInfoList - service for mouse over
	@RequestMapping( value="/getMyContactInfoList",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getMyContactInfoList(@RequestParam(value = "pinKey") Long pinKey) {
		logger.info("Call getContacts info list method -->");
		try {
			return new JsonResponse(landingInfoService.getMyContactInfoList(pinKey),MessageTypeEnum.SUCCESS.getValue(),"getMyContactInfoList.logs.success","successfully retrieved",true);
		} catch (Exception e) {
			logger.info("getMyContactInfoList method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"getMyContactInfoList.log.failure",e.getLocalizedMessage(),false); 
		}
	}//It shows the list of contacts of his/her followers when we mouse over on MyContacts menu 
	
	//8. getMyContactFollowList - follow service -- mouser over
	@RequestMapping( value="/getMyContactFollowList",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getMyContactFollowList(@RequestParam(value = "pinKey") Long pinKey) {
		logger.info("Call getMyContactFollowList info list method -->");
		try {
			return new JsonResponse(landingInfoService.getMyContactFollowList(pinKey),MessageTypeEnum.SUCCESS.getValue(),"getMyContactFollowList.logs.success","successfully retrieved",true);
		} catch (Exception e) {
			logger.info("getMyContactFollowList method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"getMyContactFollowList.log.failure",e.getLocalizedMessage(),false); 
		}
	}//It shows list of favorites contacts when we mouse over on child my contact menu
	
	//getFavoriteList - follow service -- mouser over
	@RequestMapping( value="/getFavoriteFollowList",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getFavoriteFollowList(@RequestParam(value = "pinKey") Long pinKey) {
		logger.info("Call getFavoriteFollowList info list method -->");
		try {
			return new JsonResponse(landingInfoService.getFavoriteFollowList(pinKey),MessageTypeEnum.SUCCESS.getValue(),"getFavoriteFollowList.logs.success","successfully retrieved",true);
		} catch (Exception e) {
			logger.info("getFavoriteFollowList method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"getFavoriteFollowList.log.failure",e.getLocalizedMessage(),false); 
		}
	}//It shows list of favorites contacts when we mouse over on Favorites menu	
		
		
	//5. getMyContactLeftMenu -- left menu List
	@RequestMapping( value="/getMyContactLeftMenu",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getMyContactLeftMenu(@RequestBody LandingInfoBean landingInfoBean) {
		logger.info("Call getMyContactLeftMenu info list method -->");
		try {
			return new JsonResponse(landingInfoService.getMyContactLeftMenu(landingInfoBean.getCreatedOn(),landingInfoBean.getLoggedPinKey(), landingInfoBean.getTopMenuType()),MessageTypeEnum.SUCCESS.getValue(),"getMyContactLeftMenu.logs.success","successfully retrieved",true);
		} catch (Exception e) {
			logger.info("getMyContactLeftMenu method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"getMyContactLeftMenu.log.failure",e.getLocalizedMessage(),false); 
		}
	}//It is for both MyContact left menu and Favorite left menu
	
	//6. getMyContactLandList - landing  page list
	@RequestMapping( value="/getMyContactLandList",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getMyContactLandList(@RequestBody LandingInfoBean landingInfoBean) {
		logger.info("Call getMyContactLandList info list method -->");
		try {
			return new JsonResponse(landingInfoService.getMyContactLandList(landingInfoBean.getCreatedOn(),landingInfoBean.getLoggedPinKey(), landingInfoBean.getLdBoxName(),landingInfoBean.getTopMenuType()),MessageTypeEnum.SUCCESS.getValue(),"getMyContactLandList.logs.success","successfully retrieved",true);
		} catch (Exception e) {
			logger.info("getMyContactLandList method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"getMyContactLandList.log.failure",e.getLocalizedMessage(),false); 
		}
	}//It is for both MyContact landing page list and Favorite landing page list	
	
	//Save the child link table for all left menu except notification left menu.
	@RequestMapping( value="/saveLandPageLink",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveLandPageLink(@RequestBody LandingInfoBean landingInfoBean) {
		logger.info("Call saveLandPageLink info list method -->");
		try {
			return new JsonResponse(landingInfoService.saveLandPageLink(landingInfoBean.getLdKey(),landingInfoBean.getLoggedPinKey(),landingInfoBean.getLdBoxName()),MessageTypeEnum.SUCCESS.getValue(),"saveLandPageLink.logs.success","successfully retrieved",true);
		} catch (Exception e) {
			logger.info("saveLandPageLink method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"saveLandPageLink.log.failure",e.getLocalizedMessage(),false); 
		}
	}
	
}
