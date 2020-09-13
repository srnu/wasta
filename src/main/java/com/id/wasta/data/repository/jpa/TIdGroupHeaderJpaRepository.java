package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdGroupHeaderEntity;

public interface TIdGroupHeaderJpaRepository extends BaseRepository<TIdGroupHeaderEntity, Long>{

	void deleteByGhKeyIn(List<Long> groupKey);
	
	@Query("select e from TIdGroupHeaderEntity e where e.createdBy=?1 and e.ghName like ?2")
	List<TIdGroupHeaderEntity> getGroupList(Long createdBy, String searchString);
	
	@Query("select new com.id.util.bean.common.SelectListBean(e.ghKey, e.ghName, e.ghName) from TIdGroupHeaderEntity e where e.ghKey in (?1)")
	List<SelectListBean> getGroupDtls(List<Long> ghKey);
	
	@Query("select new com.id.util.bean.common.SelectListBean(e.ghKey, e.ghName, e.ghName) from TIdGroupHeaderEntity e where e.ghName like (?1)")
	List<SelectListBean> getGroupName(String searchString);
	
	
	@Query("select count(e) from TIdGroupHeaderEntity e where e.createdBy=?1 and e.ghName=?2 and e.ghKey not in (?3)")
	int chkDuplicateGroup(Long createdBy, String ghName, Long ghKey);
}
