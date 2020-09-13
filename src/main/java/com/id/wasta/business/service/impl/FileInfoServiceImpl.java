package com.id.wasta.business.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.id.wasta.bean.FileInfoBean;
import com.id.wasta.bean.jpa.TIdProductAttachmentEntity;
import com.id.wasta.business.service.FileInfoService;
import com.id.wasta.data.repository.jpa.TIdProductAttachmentJpaRepository;

@Service
@Transactional
public class FileInfoServiceImpl implements FileInfoService {
	
	@Resource
	private TIdProductAttachmentJpaRepository tIdProductAttachmentJpaRepository;
	
	@Override
	public boolean saveFileDtls(FileInfoBean fileInfoBean) {
		
			if("PersonalInfo_Photo".equals(fileInfoBean.getReferenceType())) {
				tIdProductAttachmentJpaRepository.deletePersonalInfoDtls(fileInfoBean.getReferenceKey(),
						fileInfoBean.getReferenceType());
			}
			TIdProductAttachmentEntity tIdProductAttachmentEntity = new TIdProductAttachmentEntity();
			tIdProductAttachmentEntity.setPattProductKey(Long.valueOf(1));
			tIdProductAttachmentEntity.setPattReferenceType(fileInfoBean.getReferenceType());
			tIdProductAttachmentEntity.setPattReferenceKey(fileInfoBean.getReferenceKey());
			tIdProductAttachmentEntity.setPattSerial(fileInfoBean.getSerial());
			tIdProductAttachmentEntity.setPattInfobaseKey(Long.valueOf(1));
			tIdProductAttachmentEntity.setPattFilePathKey(Long.valueOf(1));
			tIdProductAttachmentEntity.setPattFileName(fileInfoBean.getFileName());
			tIdProductAttachmentEntity.setPattFileType(fileInfoBean.getFileType());
			tIdProductAttachmentEntity.setPattUploadedBy(fileInfoBean.getProfileKey());
			tIdProductAttachmentEntity.setPattUploadedOn(new Date());
			tIdProductAttachmentEntity.setActiveStatus("A");
			tIdProductAttachmentEntity.setPattInternalFileName(fileInfoBean.getFilePath());
			tIdProductAttachmentEntity.setProfileKey(fileInfoBean.getProfileKey());	
			tIdProductAttachmentJpaRepository.save(tIdProductAttachmentEntity);
		
		return true;
	}
	
	@Override
	public boolean saveFileDtls1(List<FileInfoBean> listOffileInfoBean) {
		TIdProductAttachmentEntity tIdProductAttachmentEntity = null;
		List<TIdProductAttachmentEntity> listOfTIdProductAttachmentEntity = new ArrayList<TIdProductAttachmentEntity>();
		for (FileInfoBean fileInfoBean : listOffileInfoBean) {
			if("PersonalInfo_Photo".equals(fileInfoBean.getReferenceType())) {
				tIdProductAttachmentJpaRepository.deletePersonalInfoDtls(fileInfoBean.getReferenceKey(),
						fileInfoBean.getReferenceType());
			}
			tIdProductAttachmentEntity = new TIdProductAttachmentEntity();
			tIdProductAttachmentEntity.setPattProductKey(Long.valueOf(1));
			tIdProductAttachmentEntity.setPattReferenceType(fileInfoBean.getReferenceType());
			tIdProductAttachmentEntity.setPattReferenceKey(fileInfoBean.getReferenceKey());
			tIdProductAttachmentEntity.setPattSerial(fileInfoBean.getSerial());
			tIdProductAttachmentEntity.setPattInfobaseKey(Long.valueOf(1));
			tIdProductAttachmentEntity.setPattFilePathKey(Long.valueOf(1));
			tIdProductAttachmentEntity.setPattFileName(fileInfoBean.getFileName());
			tIdProductAttachmentEntity.setPattFileType(fileInfoBean.getFileType());
			tIdProductAttachmentEntity.setPattUploadedBy(fileInfoBean.getProfileKey());
			tIdProductAttachmentEntity.setPattUploadedOn(new Date());
			tIdProductAttachmentEntity.setActiveStatus("A");
			tIdProductAttachmentEntity.setPattInternalFileName(fileInfoBean.getFilePath());
			tIdProductAttachmentEntity.setProfileKey(fileInfoBean.getProfileKey());	
			listOfTIdProductAttachmentEntity.add(tIdProductAttachmentEntity);
		}
		tIdProductAttachmentJpaRepository.save(listOfTIdProductAttachmentEntity);
		return true;
	}

	@Override
	public List<TIdProductAttachmentEntity> retrieveFile(Long referenceKey, String referenceType, String fileType) {
		return tIdProductAttachmentJpaRepository.findByRefKeyAndPattRefTypeAndPattFileType(referenceKey, referenceType, fileType);
	}

}
