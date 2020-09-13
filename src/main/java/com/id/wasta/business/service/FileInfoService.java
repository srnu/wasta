package com.id.wasta.business.service;

import java.util.List;

import com.id.wasta.bean.FileInfoBean;
import com.id.wasta.bean.jpa.TIdProductAttachmentEntity;

public interface FileInfoService {

	public boolean saveFileDtls1(List<FileInfoBean> listOffileInfoBean);
	
	public boolean saveFileDtls(FileInfoBean listOffileInfoBean);
	
	public List<TIdProductAttachmentEntity> retrieveFile(Long referenceKey, String referenceType, String fileType);
	
}
