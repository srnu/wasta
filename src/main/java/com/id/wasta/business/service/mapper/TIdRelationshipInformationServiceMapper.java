package com.id.wasta.business.service.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.id.wasta.bean.TIdRelationshipInformation;
import com.id.wasta.bean.jpa.TIdRelationshipInformationEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class TIdRelationshipInformationServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public TIdRelationshipInformationServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'TIdRelationshipInformationEntity' to 'TIdRelationshipInformation'
	 * @param tIdRelationshipInformationEntity
	 */
	public TIdRelationshipInformation mapTIdRelationshipInformationEntityToTIdRelationshipInformation(TIdRelationshipInformationEntity tIdRelationshipInformationEntity) {
		if(tIdRelationshipInformationEntity == null) {
			return null;
		}

		//--- Generic mapping 
		TIdRelationshipInformation tIdRelationshipInformation = map(tIdRelationshipInformationEntity, TIdRelationshipInformation.class);

		return tIdRelationshipInformation;
	}
	
	/**
	 * Mapping from 'TIdRelationshipInformation' to 'TIdRelationshipInformationEntity'
	 * @param tIdRelationshipInformation
	 * @param tIdRelationshipInformationEntity
	 */
	public void mapTIdRelationshipInformationToTIdRelationshipInformationEntity(TIdRelationshipInformation tIdRelationshipInformation, TIdRelationshipInformationEntity tIdRelationshipInformationEntity) {
		if(tIdRelationshipInformation == null) {
			return;
		}

		//--- Generic mapping 
		map(tIdRelationshipInformation, tIdRelationshipInformationEntity);

		//--- Link mapping ( link : tIdRelationshipInformation )

	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}