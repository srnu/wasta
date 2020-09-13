package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdCategoryMasterEntity;

/**
 * Repository : TIdCategoryMaster.
 */
public interface TIdCategoryMasterJpaRepository extends BaseRepository<TIdCategoryMasterEntity, Long> {

	@Query("select new com.id.util.bean.common.SelectListBean(e.camKey,e.camName,e.camName) from TIdCategoryMasterEntity as e where e.profileKey=:profileKey and e.activeStatus='A'")
	public List<SelectListBean> getCategoryMastersList(@Param("profileKey")Long profileKey);
	
	
	public List<TIdCategoryMasterEntity> findByCamKeyIn(List<Long> camKey);
	
}
