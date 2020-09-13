package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdExperienceInformationViewEntity;

/**
 * Repository : TIdExperienceInformation.
 */
public interface TIdExperienceInformationViewJpaRepository extends BaseRepository<TIdExperienceInformationViewEntity, Long> {
	
	List<TIdExperienceInformationViewEntity> findByPexPinKeyAndActiveStatusOrderByPexKeyDesc(Long pexPinKey,String status);
	
	@Query("select new com.id.util.bean.common.SelectListBean (e.pexDesignationKey, e.designation,e.designation) from TIdExperienceInformationViewEntity as e "
			+ " where e.pexPinKey = :pexPinKey and e.pexDesignationKey!=null GROUP BY e.pexDesignationKey ORDER BY e.pexDesignationKey")
	public List<SelectListBean> getRetrievePosition(@Param("pexPinKey") Long pexPinKey);
	
	@Query("select new com.id.util.bean.common.SelectListBean (e.pexKey,'COMP',e.company) from TIdExperienceInformationViewEntity as e "
			+ "where e.pexPinKey = :pexPinKey GROUP BY e.pexKey ORDER BY e.pexKey")
	public List<SelectListBean> getRetrieveProvidedBy(@Param("pexPinKey") Long pexPinKey);
	
	@Query("select e.company from TIdExperienceInformationViewEntity as e where e.pexKey=?1")
	String findCompany(Long key);
	
}
