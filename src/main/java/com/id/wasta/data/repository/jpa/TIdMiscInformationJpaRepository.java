package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdMiscInformationEntity;

/**
 * Repository : TIdMiscInformation.
 * @param <MiscInformationEntity>
 */
public interface TIdMiscInformationJpaRepository extends BaseRepository<TIdMiscInformationEntity, Long> {

	List<TIdMiscInformationEntity> findByPimiPinKeyAndActiveStatusAndPimiRecreationIsNotNullOrderByPimiKeyDesc(Long pinKey,String status);

	List<TIdMiscInformationEntity> findByPimiPinKeyAndActiveStatusAndPimiProfessionalExpertiseIsNotNullOrderByPimiKeyDesc(Long pinKey,String status);

	List<TIdMiscInformationEntity> findByPimiPinKeyAndActiveStatusAndPimiProfessionalInterestsIsNotNullOrderByPimiKeyDesc(Long pinKey,String status);

	List<TIdMiscInformationEntity> findByPimiPinKeyAndActiveStatusAndPimiPersonalInterestsIsNotNullOrderByPimiKeyDesc(Long pinKey,String status);
	
    List<TIdMiscInformationEntity> findByPimiPinKeyAndActiveStatusAndPimiPersonalPrioritiesIsNotNullOrderByPimiKeyDesc(Long pinKey,String status);
    
    List<TIdMiscInformationEntity> findByPimiPinKeyAndActiveStatusAndPimiBusinessPotentialIsNotNullOrderByPimiKeyDesc(Long pinKey,String status);
    
    List<TIdMiscInformationEntity> findByPimiPinKeyAndActiveStatusAndPimiBusinessOpportunitiesIsNotNullOrderByPimiKeyDesc(Long pinKey,String status);

	List<TIdMiscInformationEntity> findByPimiPinKeyAndActiveStatusAndPimiProfessionalExpertiseKeyIsNotNull(Long pimiPinKey,String status);
	
}
