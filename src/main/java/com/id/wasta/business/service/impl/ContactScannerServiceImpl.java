package com.id.wasta.business.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.id.nlp.bean.CardDetailsBean;
import com.id.wasta.bean.CustomerInfoBean;
import com.id.wasta.bean.jpa.TIdCityMasterEntity;
import com.id.wasta.bean.jpa.TIdCompanyMasterEntity;
import com.id.wasta.bean.jpa.TIdCountryMasterEntity;
import com.id.wasta.bean.jpa.TIdDesignationMasterEntity;
import com.id.wasta.business.service.ContactScannerService;
import com.id.wasta.data.repository.jpa.TIdCityMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCompanyMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCountryMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdDesignationMasterJpaRepository;

@Service
public class ContactScannerServiceImpl implements ContactScannerService{
	private static final Logger logger = Logger.getLogger(ContactScannerService.class);
	
	@Resource
	private TIdCompanyMasterJpaRepository tIdCompanyMasterJpaRepository; 
	
	@Resource
	private TIdDesignationMasterJpaRepository tIdDesignationMasterJpaRepository;
	
	@Resource 
	private TIdCityMasterJpaRepository tIdCityMasterJpaRepository;
	
	@Resource
	private TIdCountryMasterJpaRepository tIdCountryMasterJpaRepository;
	
	@Override
	public CustomerInfoBean convertCardToCustomerBean(CardDetailsBean cardDetailsBean) {
		logger.info("convertCardToCustomerBean method called");
		CustomerInfoBean customerInfoBean=new CustomerInfoBean();
		
		if(!cardDetailsBean.getCompanyName().isEmpty()) {
			TIdCompanyMasterEntity companyKeyList = tIdCompanyMasterJpaRepository.findByCompany(cardDetailsBean.getCompanyName());
			if(companyKeyList!=null) {
				customerInfoBean.setCompanyKey(companyKeyList.getKey());
				customerInfoBean.setCompanyName(companyKeyList.getName());
			}else {
				customerInfoBean.setOtherCompanyName(cardDetailsBean.getCompanyName());
			}
		}
		
		if(!cardDetailsBean.getCity().isEmpty()) {
			TIdCityMasterEntity tIdCityMasterEntityList = tIdCityMasterJpaRepository.findByCity(cardDetailsBean.getCity());
			if(tIdCityMasterEntityList!=null) {
				customerInfoBean.setCityKey(tIdCityMasterEntityList.getKey());
				customerInfoBean.setCity(cardDetailsBean.getCity());
			} else {
				customerInfoBean.setOtherCityName(cardDetailsBean.getCity());
			}
		}
		
		if(!cardDetailsBean.getCountry().isEmpty()) {
			TIdCountryMasterEntity tIdCountryMasterEntityList = tIdCountryMasterJpaRepository.findByCountry(cardDetailsBean.getCountry());
			if(tIdCountryMasterEntityList!=null) {
				customerInfoBean.setCountryKey(tIdCountryMasterEntityList.getKey());
				customerInfoBean.setCountry(cardDetailsBean.getCountry());
			} 
		}
		
		if(!cardDetailsBean.getDesignation().isEmpty()) {
			TIdDesignationMasterEntity designKeyList = tIdDesignationMasterJpaRepository.findByDesignation(cardDetailsBean.getDesignation());
			if(designKeyList!=null) {
				customerInfoBean.setDesignKey(designKeyList.getKey());
				customerInfoBean.setDesignName(designKeyList.getName());
			} else {
				customerInfoBean.setOtherDesignName(cardDetailsBean.getDesignation());
			}
		}
		
		if(cardDetailsBean.getEmail()!=null && cardDetailsBean.getEmail().size()>0) {
			customerInfoBean.setEmailId(cardDetailsBean.getEmail().get(0));
		}
		if(cardDetailsBean.getPhoneMobile()!=null){
			customerInfoBean.setMobile(cardDetailsBean.getPhoneMobile());
		}
		if(cardDetailsBean.getPhoneNumbers()!=null && cardDetailsBean.getPhoneNumbers().size()>0){
			Set<String> set = cardDetailsBean.getPhoneNumbers();
			List<String> list = new ArrayList<String>(set);
			customerInfoBean.setLandLine(list.get(0));
		}
		if(cardDetailsBean.getContactPerson()!=null && cardDetailsBean.getContactPerson().split(" ").length>1){
			customerInfoBean.setLastName(cardDetailsBean.getContactPerson().substring(cardDetailsBean.getContactPerson().lastIndexOf(" ")+1));
			customerInfoBean.setFirstName (cardDetailsBean.getContactPerson().substring(0, cardDetailsBean.getContactPerson().lastIndexOf(' ')));
		}else{
		     customerInfoBean.setFirstName(cardDetailsBean.getContactPerson());
		}		
		
		if(cardDetailsBean.getAddress()!=null && cardDetailsBean.getAddress().size()>0) {
			customerInfoBean.setAddress(cardDetailsBean.getAddress().get(0));
		}
		logger.info("convertCardToCustomerBean method ended....");
		
		return customerInfoBean;  
	}

}
