package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdLanguageInformationViewEntity;

/**
 * Repository : TIdLanguageInformation.
 */
public interface TIdLanguageInformationViewJpaRepository extends BaseRepository<TIdLanguageInformationViewEntity,Long>{
	

	List<TIdLanguageInformationViewEntity>findByPliPinKey(Long pinKey);
	

}
