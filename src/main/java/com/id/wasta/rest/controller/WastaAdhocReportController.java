package com.id.wasta.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.id.wasta.business.service.WastaAdhocReportService;

@RestController
public class WastaAdhocReportController {
	
	public static final Logger logger = Logger.getLogger(WastaAdhocReportController.class);
	
	@Autowired
	WastaAdhocReportService wastaAdhocReportService;
	
	@SuppressWarnings("static-access")
	@RequestMapping(value="/wastaUsageReport",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public void wastaUsageReport() {
		logger.getLogger("wastaUsageReport method executed in controller");
		wastaAdhocReportService.wastaUsageReport();
	}
	
	

}
