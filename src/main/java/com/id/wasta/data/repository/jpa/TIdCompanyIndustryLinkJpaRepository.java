package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.id.wasta.bean.jpa.TIdCompanyIndustryLinkEntity;

public interface TIdCompanyIndustryLinkJpaRepository extends
		JpaRepository<TIdCompanyIndustryLinkEntity,Long> {
	List<TIdCompanyIndustryLinkEntity>findByCilPexKey(Long cilPexKey);

}
