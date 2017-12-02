package com.increpas.therecipe.dto;

public class UploadFileDTO {
	String originalFilename;
	String systemFilename;
	long fileSize;
	
	
	public String getOriginalFilename() {
		return originalFilename;
	}
	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}
	public String getSystemFilename() {
		return systemFilename;
	}
	public void setSystemFilename(String systemFilename) {
		this.systemFilename = systemFilename;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	@Override
	public String toString() {
		return "UploadFileDTO [originalFilename=" + originalFilename + ", systemFilename=" + systemFilename
				+ ", fileSize=" + fileSize + "]";
	}
	
}
