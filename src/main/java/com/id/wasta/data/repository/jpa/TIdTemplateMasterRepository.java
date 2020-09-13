package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdTemplateMasterEntity;

public interface TIdTemplateMasterRepository extends BaseRepository<TIdTemplateMasterEntity,Long> {
	
	@Query("select tm.tmSubject, tm.tmContent from TIdTemplateMasterEntity tm where tm.tmCode=:tmCode and tm.tmType=:tmType and tm.tmStatus='A'")
	public List<Object[]> getTemplateSubjectAndContent(@Param("tmCode")String tmCode,@Param("tmType")String tmType);

}
