package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.id.wasta.bean.jpa.TIdCompanyIndustryLinkViewEntity;

public interface TIdCompanyIndustryLinkViewJpaRepository extends JpaRepository<TIdCompanyIndustryLinkViewEntity, Long> {
	
	List<TIdCompanyIndustryLinkViewEntity> findByCilPexKey(Long pexKey);

	@Query(value="select group_concat(name) from t_id_company_industry_link_view where cil_pex_key=?1 ", nativeQuery=true)
	String getName(Long cilPexKey);
}
