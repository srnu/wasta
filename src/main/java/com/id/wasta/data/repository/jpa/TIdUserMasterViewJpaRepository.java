package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdUserMasterViewEntity;

/**
 * Repository : TIdUserMaster.
 */
public interface TIdUserMasterViewJpaRepository extends BaseRepository<TIdUserMasterViewEntity, Long> {
	
	public List<TIdUserMasterViewEntity> findByKeyIn(List<Long> key);
	
	@Query("select new com.id.util.bean.common.SelectListBean (e.key, e.userPinKey||'', e.name||' - '|| e.designation||' - '|| e.company ) from TIdUserMasterViewEntity as e")
	public List<SelectListBean> getUserInfoAll();
	
	@Query("select e.userPinKey from TIdUserMasterViewEntity as e where e.key=?1")
	public Long getUserPinKey(Long userKey);
	
}
