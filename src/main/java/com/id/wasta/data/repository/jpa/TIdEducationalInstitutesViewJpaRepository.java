package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdEducationalInstitutesViewEntity;

public interface TIdEducationalInstitutesViewJpaRepository extends BaseRepository<TIdEducationalInstitutesViewEntity, Long> {
	
	List<TIdEducationalInstitutesViewEntity> findByProfileKeyAndActiveStatus(Long profileKey, String status);

}
