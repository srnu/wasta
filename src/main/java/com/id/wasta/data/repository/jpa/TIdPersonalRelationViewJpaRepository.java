package com.id.wasta.data.repository.jpa;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdPersonalRelationViewEntity;

public interface TIdPersonalRelationViewJpaRepository extends BaseRepository<TIdPersonalRelationViewEntity,Long>{

	
	@Query("select e.relationCompanyName from TIdPersonalRelationViewEntity as e where e.pinKey = :pinKey ")
	String getRelationCompanyName(@Param("pinKey") Long pinKey );

	
}
