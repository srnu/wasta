package com.id.wasta.business.service;

import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface SearchInfoService {
	
	Map<String, Object> getSearchInfoDtls(String SearchKey,boolean admin)  throws InterruptedException, ExecutionException ;
	
	//Map<String, Object> getSearchInfoDtls2(String SearchKey,boolean admin);
	
	//Map<String, Object> getSearchInfoDtls3(String SearchKey,boolean admin)  throws InterruptedException, ExecutionException ;
}