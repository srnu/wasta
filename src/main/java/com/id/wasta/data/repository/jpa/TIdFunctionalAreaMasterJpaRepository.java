package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdFunctionalAreaMasterEntity;

/**
 * Repository : TIdFunctionalAreaMaster.
 */
public interface TIdFunctionalAreaMasterJpaRepository extends BaseRepository<TIdFunctionalAreaMasterEntity, Long> {
	  
	@Query("select e.name from TIdFunctionalAreaMasterEntity e where e.key =?1 and e.activeStatus in ('A','P')") 
	String getFuctionalAreaName(Long Key);

	@Query("select new com.id.util.bean.common.SelectListBean (e.key, e.code,e.name) from TIdFunctionalAreaMasterEntity as e where e.activeStatus in('A','P') and e.profileKey=?1 and e.name like %?2%")
	List<SelectListBean> getAllData(Long profileKey,String funtionArea);
	 
}
