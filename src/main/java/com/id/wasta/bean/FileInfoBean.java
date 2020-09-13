package com.id.wasta.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileInfoBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private String filePath;
	private String fileName;
	private String fileType;
	private Long profileKey;
	private Long serial;
	private Long referenceKey;
	private String referenceType;
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Long getProfileKey() {
		return profileKey;
	}
	public void setProfileKey(Long profileKey) {
		this.profileKey = profileKey;
	}
	public Long getSerial() {
		return serial;
	}
	public void setSerial(Long serial) {
		this.serial = serial;
	}
	public Long getReferenceKey() {
		return referenceKey;
	}
	public void setReferenceKey(Long referenceKey) {
		this.referenceKey = referenceKey;
	}
	public String getReferenceType() {
		return referenceType;
	}
	public void setReferenceType(String referenceType) {
		this.referenceType = referenceType;
	}
	

}
