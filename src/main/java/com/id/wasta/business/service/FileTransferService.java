package com.id.wasta.business.service;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;

import javax.servlet.http.HttpServletResponse;

public interface FileTransferService {

	public byte[] download(String fileName);
	
	public void download(Long refKey, String pattType, HttpServletResponse response);
	
	public void download(String fileName, Long filePathKey, HttpServletResponse response);

	public void deleteFile(String fileName);

	public Path upload(String fileName,  byte[] fileContent);
	
	public boolean moveFiles(String origin, String destination);
	
	public boolean copyFiles(String origin, String destination);
	
	public DirectoryStream<Path> getFileList(String filepath, String fileExtn) throws IOException;

}
