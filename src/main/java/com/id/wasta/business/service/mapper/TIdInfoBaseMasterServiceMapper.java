package com.id.wasta.business.service.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.id.wasta.bean.TIdInfoBaseMaster;
import com.id.wasta.bean.jpa.TIdInfoBaseMasterEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class TIdInfoBaseMasterServiceMapper extends AbstractServiceMapper {

 /**
  * ModelMapper : bean to bean mapping library.
  */
 private ModelMapper modelMapper;
 
 /**
  * Constructor.
  */
 public TIdInfoBaseMasterServiceMapper() {
  modelMapper = new ModelMapper();
  modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
 }

 /**
  * Mapping from 'TIdInfoBaseMasterEntity' to 'TIdInfoBaseMaster'
  * @param tIdInfoBaseMasterEntity
  */
 public TIdInfoBaseMaster mapTIdInfoBaseMasterEntityToTIdInfoBaseMaster(TIdInfoBaseMasterEntity tIdInfoBaseMasterEntity) {
  if(tIdInfoBaseMasterEntity == null) {
   return null;
  }

  //--- Generic mapping
  TIdInfoBaseMaster tIdInfoBaseMaster = map(tIdInfoBaseMasterEntity, TIdInfoBaseMaster.class);

  return tIdInfoBaseMaster;
 }
 
 /**
  * Mapping from 'TIdInfoBaseMaster' to 'TIdInfoBaseMasterEntity'
  * @param tIdInfoBaseMaster
  * @param tIdInfoBaseMasterEntity
  */
 public void mapTIdInfoBaseMasterToTIdInfoBaseMasterEntity(TIdInfoBaseMaster tIdInfoBaseMaster, TIdInfoBaseMasterEntity tIdInfoBaseMasterEntity) {
  if(tIdInfoBaseMaster == null) {
   return;
  }

  //--- Generic mapping
  map(tIdInfoBaseMaster, tIdInfoBaseMasterEntity);

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