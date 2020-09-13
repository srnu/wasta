package com.id.wasta.business.service.impl;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.EnumSet;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.id.util.StringUtil;
import com.id.wasta.bean.jpa.TIdInfoBaseMasterEntity;
import com.id.wasta.bean.jpa.TIdProductAttachmentEntity;
import com.id.wasta.business.service.FileTransferService;
import com.id.wasta.data.repository.jpa.TIdInfoBaseMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProductAttachmentJpaRepository;
import com.id.wasta.util.action.CopyDirectory;
import com.id.wasta.util.action.MoveDirectory;

@Service
public class FileTransferServiceImpl implements FileTransferService {
	
	@Resource
	private TIdProductAttachmentJpaRepository tIdProductAttachmentJpaRepository; 
	
	@Resource
	private TIdInfoBaseMasterJpaRepository tIdInfoBaseMasterJpaRepository;

	private static final Logger logger = Logger.getLogger(FileTransferServiceImpl.class) ;

	@Override
	public byte[] download(String fileNameAndPath) {
		try {
			return Files.readAllBytes(Paths.get(fileNameAndPath));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(fileNameAndPath+" Error Downloading File -->"+StringUtil.stack2string(e));
		}
		return null;
	}
	
	@Override
	public void download(String fileName, Long filePathKey, HttpServletResponse response) {
		try {
			TIdInfoBaseMasterEntity ibme =   tIdInfoBaseMasterJpaRepository.findOne(filePathKey);
			byte[] byteData = Files.readAllBytes(Paths.get(ibme.getName() + fileName));
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=\"" +fileName);
			response.getOutputStream().write(byteData);
			response.flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void download(Long refKey, String pattType, HttpServletResponse response) {
		try {
			List<TIdProductAttachmentEntity> list = tIdProductAttachmentJpaRepository.findByRefKeyAndPattRefType(refKey, pattType);
			if(list!=null && list.size()>0){
				TIdProductAttachmentEntity obj = list.get(0);
				TIdInfoBaseMasterEntity ibme =   tIdInfoBaseMasterJpaRepository.findOne(obj.getPattFilePathKey());
				byte[] byteData = Files.readAllBytes(Paths.get(ibme.getName() + obj.getPattFileName()));
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + obj.getPattFileName());
				response.getOutputStream().write(byteData);
				response.flushBuffer();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void deleteFile(String fileNameAndPath) {
		try {
			Files.delete(Paths.get(fileNameAndPath));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(fileNameAndPath+" Error Deleting File -->"+StringUtil.stack2string(e));
		}
		
	}

	@Override
	public Path upload(String fileNameAndPath, byte[] fileContent) {
		try {
			Path path = Files.write(Paths.get(fileNameAndPath), fileContent);
			return path;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(fileNameAndPath+" Error Uploading File -->"+StringUtil.stack2string(e));
		}
		return null;
	}
	
	@Override
	public DirectoryStream<Path> getFileList(String filepath, String fileExtn) throws IOException {
		Path dir = FileSystems.getDefault().getPath(filepath);
		return Files.newDirectoryStream( dir, "*.{"+fileExtn+"}" );
	}
	 
	
	@Override
	public boolean moveFiles(String origin, String destination) {
		Path source = Paths.get(origin);
		Path target = Paths.get(destination);
		try {
			Files.walkFileTree(source, new MoveDirectory(source, target, StandardCopyOption.REPLACE_EXISTING));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean copyFiles(String origin, String destination) {
		Path source = Paths.get(origin);
		Path target = Paths.get(destination);
		try {
			Files.walkFileTree(source, EnumSet.of(FileVisitOption.FOLLOW_LINKS),Integer.MAX_VALUE, new CopyDirectory(source, target));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
