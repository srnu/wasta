package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdDesignationMasterEntity;

/**
 * Repository : TIdDesignationMaster.
 */
public interface TIdDesignationMasterJpaRepository extends BaseRepository<TIdDesignationMasterEntity, Long> {

	@Query("select dm from TIdDesignationMasterEntity dm where dm.name=?1 and dm.activeStatus='A' ")
	TIdDesignationMasterEntity findByDesignation(String designation);
	
	
	@Query("select e.name from TIdDesignationMasterEntity e where e.key=?1 and e.activeStatus in ('A','P')")
	String getDesignationName(Long key);

	@Query("select new com.id.util.bean.common.SelectListBean (e.key, e.code,e.name) from TIdDesignationMasterEntity as e where e.activeStatus in('A','P') and e.profileKey=?1 and e.name like %?2%")
	List<SelectListBean> getAllData(Long profileKey,String desigNation);

}
