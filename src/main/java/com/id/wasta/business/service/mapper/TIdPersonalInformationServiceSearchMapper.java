package com.id.wasta.business.service.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.id.wasta.bean.TIdPersonalInformationSearch;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntitySearch;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class TIdPersonalInformationServiceSearchMapper extends AbstractServiceMapper {

 /**
  * ModelMapper : bean to bean mapping library.
  */
 private ModelMapper modelMapper;
 
 /**
  * Constructor.
  */
 public TIdPersonalInformationServiceSearchMapper() {
  modelMapper = new ModelMapper();
  modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
 }

 /**
  * Mapping from 'TIdPersonalInformationEntitySearch' to 'TIdPersonalInformationSearch'
  * @param TIdPersonalInformationEntitySearch
  */
 public TIdPersonalInformationSearch mapTIdPersonalInformationEntitySearchToTIdPersonalInformationSearch(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch) {
  if(tIdPersonalInformationEntitySearch == null) {
   return null;
  }

  //--- Generic mapping
  TIdPersonalInformationSearch tIdPersonalInformationSearch = map(tIdPersonalInformationEntitySearch, TIdPersonalInformationSearch.class);

  return tIdPersonalInformationSearch;
 }
 
 /**
  * Mapping from 'TIdPersonalInformationSearch' to 'TIdPersonalInformationEntitySearch'
  * @param TIdPersonalInformationSearch
  * @param TIdPersonalInformationEntitySearch
  */
 public void mapTIdPersonalInformationSearchToTIdPersonalInformationEntitySearch(TIdPersonalInformationSearch tIdPersonalInformationSearch, TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch) {
  if(tIdPersonalInformationSearch == null) {
   return;
  }

  //--- Generic mapping
  map(tIdPersonalInformationSearch, tIdPersonalInformationEntitySearch);

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