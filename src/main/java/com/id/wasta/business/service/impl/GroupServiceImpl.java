package com.id.wasta.business.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.id.util.bean.common.SelectListBean;
import com.id.util.business.service.mapping.GenericServiceMapper;
import com.id.wasta.bean.TIdGroupHeader;
import com.id.wasta.bean.TIdGroupLink;
import com.id.wasta.bean.jpa.TIdGroupHeaderEntity;
import com.id.wasta.bean.jpa.TIdGroupLinkEntity;
import com.id.wasta.bean.jpa.TIdGroupLinkViewEntity;
import com.id.wasta.business.service.GroupService;
import com.id.wasta.data.repository.jpa.TIdGroupHeaderJpaRepository;
import com.id.wasta.data.repository.jpa.TIdGroupLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdGroupLinkViewJpaRepository;
import com.id.wasta.exception.HandledException;
import com.id.wasta.util.action.ParametersHash;



@Service
@Transactional
public class GroupServiceImpl implements GroupService{

	@Resource
	private GenericServiceMapper genericServiceMapper;
	@Resource
	private TIdGroupHeaderJpaRepository tIdGroupHeaderJpaRepository;
	@Resource
	private TIdGroupLinkJpaRepository tIdGroupLinkJpaRepository;
	@Resource
	private TIdGroupLinkViewJpaRepository tIdGroupLinkViewJpaRepository;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public Long saveOrUpdateGroupDetails(TIdGroupHeader tIdGroupHeader) throws Exception {
		if(validGroup(tIdGroupHeader)) {
			throw new HandledException("Group name already available!!!");
		}
		TIdGroupHeaderEntity  tIdGroupHeaderEntity = null;
		if(tIdGroupHeader.getGhKey()!=null) {
			tIdGroupHeaderEntity = tIdGroupHeaderJpaRepository.findOne(tIdGroupHeader.getGhKey());
			List<TIdGroupLinkEntity> ListOftIdGroupLinkEntity=tIdGroupHeaderEntity.getListOfTIdGroupLink();			
			if(ListOftIdGroupLinkEntity.size()>0) {
				tIdGroupLinkJpaRepository.delete(ListOftIdGroupLinkEntity);
			}
		}		
		tIdGroupHeaderEntity = genericServiceMapper.map(tIdGroupHeader, TIdGroupHeaderEntity.class);
		List<TIdGroupLink> listOfGroupLink = tIdGroupHeader.getListOfTIdGroupLink();
		List<TIdGroupLinkEntity> listOfGroupLinkEntity = new ArrayList<TIdGroupLinkEntity>();
		for(TIdGroupLink tIdGroupLink : listOfGroupLink){
			TIdGroupLinkEntity tIdGroupLinkEntity =  genericServiceMapper.map(tIdGroupLink,TIdGroupLinkEntity.class);
			tIdGroupLinkEntity.setTIdGroupHeader(tIdGroupHeaderEntity);
			listOfGroupLinkEntity.add(tIdGroupLinkEntity);
		} 
		tIdGroupHeaderEntity.setListOfTIdGroupLink(listOfGroupLinkEntity);
		tIdGroupHeaderEntity=tIdGroupHeaderJpaRepository.save(tIdGroupHeaderEntity);
		return tIdGroupHeaderEntity.getGhKey();
	}
	
	public boolean validGroup(TIdGroupHeader tIdGroupHeader) {
		Long key = tIdGroupHeader.getGhKey()!=null?tIdGroupHeader.getGhKey():0L;
		int i = tIdGroupHeaderJpaRepository.chkDuplicateGroup(tIdGroupHeader.getCreatedBy(), tIdGroupHeader.getGhName(), key);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public String deleteGroup(List<Long> groupKey) {
		tIdGroupHeaderJpaRepository.deleteByGhKeyIn(groupKey);
		return "Success";
	}

	@Override
	public String deleteGroupDtls(Long childPrimaryKey) {
		int a = tIdGroupLinkJpaRepository.deleteByGlKey(childPrimaryKey);
		if(a>0) {
			return "Success";
		}else {
			return "No Data Found";
		}
	}

	@Override
	public List<TIdGroupHeader> getHeaderAndChild(Long createdBy, String searchString) {
		List<TIdGroupHeader> tIdGroupHeaderList = null;		
		List<TIdGroupHeaderEntity> tIdGroupHeaderEntityList = tIdGroupHeaderJpaRepository.getGroupList(createdBy,"%"+searchString+"%");	
		if(tIdGroupHeaderEntityList.size()>0) {
			tIdGroupHeaderList = new ArrayList<TIdGroupHeader>();
			List<TIdGroupLinkViewEntity> tIdGroupLinkViewEntityList = null;
			List<TIdGroupLink> tIdGroupLinkList = null;
			for(TIdGroupHeaderEntity tIdGroupHeaderEntity : tIdGroupHeaderEntityList) {
				TIdGroupHeader tIdGroupHeader = genericServiceMapper.map(tIdGroupHeaderEntity, TIdGroupHeader.class);
				tIdGroupLinkList = new ArrayList<TIdGroupLink>(); 
				tIdGroupLinkViewEntityList = tIdGroupLinkViewJpaRepository.findByGlGhKey(tIdGroupHeader.getGhKey());
				tIdGroupLinkViewEntityList = tIdGroupLinkViewEntityList.stream().filter(ParametersHash.distinctByKey(p -> p.getGlPinKey())).collect(Collectors.toList());
				tIdGroupLinkList.addAll(objectMapper.convertValue(tIdGroupLinkViewEntityList, new TypeReference<List<TIdGroupLink>>() { }));
				tIdGroupHeader.setListOfTIdGroupLink(tIdGroupLinkList);			
				tIdGroupHeaderList.add(tIdGroupHeader);
			}	
		} 
		return tIdGroupHeaderList;
	}

	@Override
	public List<TIdGroupLink>  retrieveChildOnly(Long glGhKey) {
		List<TIdGroupLink> tIdGroupLinkList = new ArrayList<TIdGroupLink>();
		List<TIdGroupLinkViewEntity> tIdGroupLinkViewEntityList = tIdGroupLinkViewJpaRepository.findByGlGhKey(glGhKey);
		tIdGroupLinkList.addAll(objectMapper.convertValue(tIdGroupLinkViewEntityList, new TypeReference<List<TIdGroupLink>>() { }));
		return tIdGroupLinkList;
	}

	@Override
	public List<SelectListBean> findByGroupHeaderName(String searchString) {
		return tIdGroupHeaderJpaRepository.getGroupName(searchString);
	}
}
