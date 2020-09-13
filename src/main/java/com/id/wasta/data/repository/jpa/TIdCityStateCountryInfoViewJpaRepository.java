package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.id.wasta.bean.jpa.TIdCityStateCountryInfoViewEntity;

public interface TIdCityStateCountryInfoViewJpaRepository extends PagingAndSortingRepository<TIdCityStateCountryInfoViewEntity, Long>{
	
public List<TIdCityStateCountryInfoViewEntity> findByCityNameLike(String cityName);	

}
