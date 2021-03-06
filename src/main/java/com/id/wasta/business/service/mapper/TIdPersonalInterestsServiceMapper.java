/*
 * Created on 20 Feb 2017 ( Time 18:45:16 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.business.service.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.id.wasta.bean.TIdPersonalInterests;
import com.id.wasta.bean.jpa.TIdPersonalInterestsEntitySearch;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class TIdPersonalInterestsServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public TIdPersonalInterestsServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'TIdPersonalInterestsEntity' to 'TIdPersonalInterests'
	 * @param tIdPersonalInterestsEntity
	 */
	public TIdPersonalInterests mapTIdPersonalInterestsEntitySearchToTIdPersonalInterests(TIdPersonalInterestsEntitySearch tIdPersonalInterestsEntitySearch) {
		if(tIdPersonalInterestsEntitySearch == null) {
			return null;
		}

		//--- Generic mapping 
		TIdPersonalInterests tIdPersonalInterests = map(tIdPersonalInterestsEntitySearch, TIdPersonalInterests.class);

		return tIdPersonalInterests;
	}
	
	/**
	 * Mapping from 'TIdPersonalInterests' to 'TIdPersonalInterestsEntity'
	 * @param tIdPersonalInterests
	 * @param tIdPersonalInterestsEntity
	 */
	public void mapTIdPersonalInterestsToTIdPersonalInterestsEntitySearch(TIdPersonalInterests tIdPersonalInterests, TIdPersonalInterestsEntitySearch tIdPersonalInterestsEntitySearch) {
		if(tIdPersonalInterests == null) {
			return;
		}

		//--- Generic mapping 
		map(tIdPersonalInterests, tIdPersonalInterestsEntitySearch);

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