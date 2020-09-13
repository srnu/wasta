package com.id.wasta.business.service;

import java.util.List;

import com.id.util.bean.common.SelectListBean;
import com.id.wasta.bean.TIdGroupHeader;
import com.id.wasta.bean.TIdGroupLink;

public interface GroupService {

	public Long saveOrUpdateGroupDetails(TIdGroupHeader tIdGroupHeader) throws Exception;
	
	public String deleteGroup(List<Long> groupKey);
	
	public String deleteGroupDtls(Long childPrimaryKey);
	
	public List<TIdGroupHeader> getHeaderAndChild(Long createdBy, String searchString);
	
	public List<TIdGroupLink> retrieveChildOnly(Long id);
	
	public List<SelectListBean> findByGroupHeaderName(String searchString);
}
