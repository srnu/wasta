package com.id.wasta.bean;

import java.io.Serializable;
import java.util.Date;

public class Attachment implements Serializable{

	private String filePath;//pfu_FILE_PATH
    private String fileName;//pfu_FILE_NAME
    private String key;//pfu_DOC_NUMBER==Trans Ref ( Customer, Booking, SI )
    private String fileType;//pfu_FILE_TYPE
    private String functionality;//pfu_DOC_CLASSIFICATION-C-Customer, E-Empty Release, D-BL Draft, I-Invoice
    private byte[] fileContent;
    private String wsUrlForTransfer;
    private String fileReference;
   
    
  //The Below common properties are used for file upload
    private String fileMode; 
  	private String productKey; 
  	private String userKey;
    private Date fileModifiedDate;
    private String ipAddress;
  	private String referenceType; 	
    
	public Attachment() {
		super();
	}
	
	public Attachment(String filePath, String fileName, String key,
			String fileType, byte[] fileContent, String wsUrlForTransfer) {
		super();
		this.filePath = filePath;
		this.fileName = fileName;
		this.key = key;
		this.fileType = fileType;
		this.fileContent = fileContent;
		this.wsUrlForTransfer = wsUrlForTransfer;
	}


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
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public byte[] getFileContent() {
		return fileContent;
	}
	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

	public String getWsUrlForTransfer() {
		return wsUrlForTransfer;
	}

	public void setWsUrlForTransfer(String wsUrlForTransfer) {
		this.wsUrlForTransfer = wsUrlForTransfer;
	}

	public String getFunctionality() {
		return functionality;
	}

	public void setFunctionality(String functionality) {
		this.functionality = functionality;
	}

	public String getProductKey() {
		return productKey;
	}

	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public String getFileMode() {
		return fileMode;
	}

	public void setFileMode(String fileMode) {
		this.fileMode = fileMode;
	}
	
	public Date getFileModifiedDate() {
		return fileModifiedDate;
	}

	public void setFileModifiedDate(Date fileModifiedDate) {
		this.fileModifiedDate = fileModifiedDate;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getReferenceType() {
		return referenceType;
	}

	public void setReferenceType(String referenceType) {
		this.referenceType = referenceType;
	}

	public String getFileReference() {
		return fileReference;
	}

	public void setFileReference(String fileReference) {
		this.fileReference = fileReference;
	}
	
}