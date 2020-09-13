package com.id.wasta.business.service.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.id.wasta.bean.TIdPersonalInformation;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class TIdPersonalInformationServiceMapper extends AbstractServiceMapper {

 /**
  * ModelMapper : bean to bean mapping library.
  */
 private ModelMapper modelMapper;
 
 /**
  * Constructor.
  */
 public TIdPersonalInformationServiceMapper() {
  modelMapper = new ModelMapper();
  modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
 }

 /**
  * Mapping from 'TIdPersonalInformationEntity' to 'TIdPersonalInformation'
  * @param tIdPersonalInformationEntity
  */
 public TIdPersonalInformation mapTIdPersonalInformationEntityToTIdPersonalInformation(TIdPersonalInformationEntity tIdPersonalInformationEntity) {
  if(tIdPersonalInformationEntity == null) {
   return null;
  }

  //--- Generic mapping
  TIdPersonalInformation tIdPersonalInformation = map(tIdPersonalInformationEntity, TIdPersonalInformation.class);

  return tIdPersonalInformation;
 }
 
 /**
  * Mapping from 'TIdPersonalInformation' to 'TIdPersonalInformationEntity'
  * @param tIdPersonalInformation
  * @param tIdPersonalInformationEntity
  */
 public void mapTIdPersonalInformationToTIdPersonalInformationEntity(TIdPersonalInformation tIdPersonalInformation, TIdPersonalInformationEntity tIdPersonalInformationEntity) {
  if(tIdPersonalInformation == null) {
   return;
  }

  //--- Generic mapping
  map(tIdPersonalInformation, tIdPersonalInformationEntity);

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