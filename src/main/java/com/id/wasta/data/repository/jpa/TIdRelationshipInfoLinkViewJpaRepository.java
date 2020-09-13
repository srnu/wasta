package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdRelationshipInfoLinkViewEntity;

public interface TIdRelationshipInfoLinkViewJpaRepository extends BaseRepository<TIdRelationshipInfoLinkViewEntity,Long> {

	List<TIdRelationshipInfoLinkViewEntity> findByPrlkToPinKey(Long prlkToPinKey);
	
	@Query("select new com.id.util.bean.common.SelectListBean (rl.prlkKey,'REL',rl.prlkRelationship||' of '||rl.pinFirstName||' '||rl.pinLirstName) from TIdRelationshipInfoLinkViewEntity as rl"
			+ " where rl.prlkToPinKey = :prlkToPinKey")
	public List<SelectListBean> getRetriveRelationship(@Param("prlkToPinKey") Long prlkToPinKey);
}
