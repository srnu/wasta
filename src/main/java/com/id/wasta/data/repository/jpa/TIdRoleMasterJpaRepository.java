package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdRoleMasterEntity;

/**
 * Repository : TIdRoleMaster.
 */
public interface TIdRoleMasterJpaRepository extends BaseRepository<TIdRoleMasterEntity, Long> {
	
	@Query("select e.name from TIdRoleMasterEntity e where e.key =?1 and e.activeStatus ='A'") 
	String getFuctionalAreaName(Long Key);

	@Query("select new com.id.util.bean.common.SelectListBean (e.key, e.code,e.name) from TIdRoleMasterEntity as e where e.activeStatus in('A','P') and e.profileKey=?1 and e.name like %?2%")
	List<SelectListBean> getAllData(Long profileKey,String roleVal);

}
