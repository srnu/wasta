package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdCommunicationInformationEntity;

/**
 * Repository : TIdCommunicationInformation.
 */
public interface TIdCommunicationInformationJpaRepository extends BaseRepository<TIdCommunicationInformationEntity, Long> {

	
	List<TIdCommunicationInformationEntity> findByPcmPinKey(Long pinKey);
	
	List<TIdCommunicationInformationEntity> findByPcmPinKeyNotInAndPcmDescriptionContainsAndPcmType(Long pcmPinKey, String pcmDescription, String pcmType);

	List<TIdCommunicationInformationEntity> findByPcmDescriptionContains(String pcmDescription);	
	
	@Query("select e.pcmKey from TIdCommunicationInformationEntity as e where e.pcmPinKey = ?1")
	List<Long> getPrimaryKeyByPcmPinKey(Long pinKey); 
	
	
}
