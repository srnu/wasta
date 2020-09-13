/*
 * Created on 8 Dec 2016 ( Time 10:48:43 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.business.service.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.id.wasta.bean.TIdAdditionalInformation;
import com.id.wasta.bean.jpa.TIdAdditionalInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntitySearch;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class TIdAdditionalInformationSearchServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public TIdAdditionalInformationSearchServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'TIdAdditionalInformationEntitySearch' to 'TIdAdditionalInformation'
	 * @param tIdAdditionalInformationEntitySearch
	 */
	public TIdAdditionalInformation mapTIdAdditionalInformationEntitySearchToTIdAdditionalInformation(TIdAdditionalInformationEntitySearch tIdAdditionalInformationEntitySearch) {
		if(tIdAdditionalInformationEntitySearch == null) {
			return null;
		}

		//--- Generic mapping 
		TIdAdditionalInformation tIdAdditionalInformation = map(tIdAdditionalInformationEntitySearch, TIdAdditionalInformation.class);

		//--- Link mapping ( link to TIdPersonalInformation )
		if(tIdAdditionalInformationEntitySearch.getTIdPersonalInformation() != null) {
			tIdAdditionalInformation.setPiadPinKey(tIdAdditionalInformationEntitySearch.getTIdPersonalInformation().getPinKey());
		}
		return tIdAdditionalInformation;
	}
	
	/**
	 * Mapping from 'TIdAdditionalInformation' to 'TIdAdditionalInformationEntitySearch'
	 * @param tIdAdditionalInformation
	 * @param tIdAdditionalInformationEntitySearch
	 */
	public void mapTIdAdditionalInformationToTIdAdditionalInformationEntitySearch(TIdAdditionalInformation tIdAdditionalInformation, TIdAdditionalInformationEntitySearch tIdAdditionalInformationEntitySearch) {
		if(tIdAdditionalInformation == null) {
			return;
		}

		//--- Generic mapping 
		map(tIdAdditionalInformation, tIdAdditionalInformationEntitySearch);

		//--- Link mapping ( link : tIdAdditionalInformation )
		if( hasLinkToTIdPersonalInformation(tIdAdditionalInformation) ) {
			TIdPersonalInformationEntitySearch tIdPersonalInformation1 = new TIdPersonalInformationEntitySearch();
			tIdPersonalInformation1.setPinKey( tIdAdditionalInformation.getPiadPinKey() );
			tIdAdditionalInformationEntitySearch.setTIdPersonalInformation( tIdPersonalInformation1);
		} else {
			tIdAdditionalInformationEntitySearch.setTIdPersonalInformation( null );
		}

	}
	
	/**
	 * Verify that TIdPersonalInformation id is valid.
	 * @param TIdPersonalInformation TIdPersonalInformation
	 * @return boolean
	 */
	private boolean hasLinkToTIdPersonalInformation(TIdAdditionalInformation tIdAdditionalInformation) {
		if(tIdAdditionalInformation.getPiadPinKey() != null) {
			return true;
		}
		return false;
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