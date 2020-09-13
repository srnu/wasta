package com.id.wasta.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.id.util.business.service.mapping.GenericServiceMapper;
import com.id.wasta.bean.TIdCityStateCountryInfoView;
import com.id.wasta.bean.jpa.TIdCityStateCountryInfoViewEntity;
import com.id.wasta.business.service.CityStateCountryService;
import com.id.wasta.data.repository.jpa.TIdCityMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCityStateCountryInfoViewJpaRepository;

@Component
public class CityStateCountryServiceImpl implements CityStateCountryService{
	private static final Logger logger=Logger.getLogger(CityStateCountryService.class);
	
	@Resource	
	private TIdCityStateCountryInfoViewJpaRepository tIdCityStateCountryInfoViewJpaRepository;
	
	@Resource	
	private TIdCityMasterJpaRepository tIdCityMasterJpaRepository;
	
	@Autowired
	private GenericServiceMapper genericServiceMapper;

	@Override
	public List<TIdCityStateCountryInfoView> findCityByName(String cityName) {
		List<TIdCityStateCountryInfoViewEntity> cityList=tIdCityStateCountryInfoViewJpaRepository.findByCityNameLike(cityName);
		ArrayList<TIdCityStateCountryInfoView> cityBeanlist = null;
		if(cityList!=null && cityList.size()>0) {
			cityBeanlist = new ArrayList<TIdCityStateCountryInfoView>();
			for(TIdCityStateCountryInfoViewEntity entity: cityList){
			 
			 TIdCityStateCountryInfoView tIdCityStateCountryInfoView=genericServiceMapper.map(entity, TIdCityStateCountryInfoView.class );
			 cityBeanlist.add(tIdCityStateCountryInfoView);
			}
		}else {
			logger.info("No data avilable in CityStateCountryInfoViewEntit with CityName:"+cityName);
		}
		return cityBeanlist;
	}
	/*
	@Override
	public List<TIdCityStateCountryInfoView> findCityByName1(String cityName) {
		List<TIdCityMasterEntity> cityList= tIdCityMasterJpaRepository.findByNameLike("%"+cityName+"%");
		ArrayList<TIdCityStateCountryInfoView> cityBeanlist = null;
		if(cityList!=null && cityList.size()>0) {
			cityBeanlist = new ArrayList<TIdCityStateCountryInfoView>();
			for(TIdCityMasterEntity entity: cityList){
				cityBeanlist.add(new TIdCityStateCountryInfoView(entity.getKey(),entity.getName()));
			}
		}else {
			logger.info("No data avilable in CityStateCountryInfoViewEntit with CityName:"+cityName);
		}
		return cityBeanlist;
	}
	*/
	
	
}
