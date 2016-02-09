package com.yihuan.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.yihuan.util.BaseLog;

@Controller
public class UploadAction extends ActionSupport{
	 	private File file;
	    private String fileFileName;
	    private String fileFileContentType;
	    private String result; 
	    private String filePath;

	    public String getFilePath() {
	        return filePath;
	    }

	    public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}

		public void setFilePath(String filePath) {
	        this.filePath = filePath;
	    }

	    public File getFile() {
	        return file;
	    }

	    public void setFile(File file) {
	        this.file = file;
	    }

	    public String getFileFileName() {
	        return fileFileName;
	    }

	    public void setFileFileName(String fileFileName) {
	        this.fileFileName = fileFileName;
	    }

	    public String getFileFileContentType() {
	        return fileFileContentType;
	    }

	    public void setFileFileContentType(String fileFileContentType) {
	        this.fileFileContentType = fileFileContentType;
	    }

	    public String execute() throws Exception {
	    	String mkdir="/upload_image";
	        String path = ServletActionContext.getRequest().getRealPath(mkdir);
	        File file = new File(path); // 判断文件夹是否存在,如果不存在则创建文件夹
	        if (!file.exists()) {
	            file.mkdir();
	        }
	        String[] fileSuffix = new String[] { ".png",".jpg",".gif" ,".jpeg",".bmp"};// 禁止文件
	        try {
	            File f = this.getFile();
	            // 判断文件格式
	            boolean flog=false;
	            for (int i = 0; i < fileSuffix.length; i++) {
	                if (fileFileName.endsWith(fileSuffix[i])) {
	                    flog=true;
	                }
	            }
	            if(!flog){
	            	result="格式不对！";
	            	getFile().delete();
	            	return SUCCESS;
	            }
	            System.out.println("文件容量："+getFile().length());
	            if(getFile().length()>=10971520){
	            	result="文件容量太大！";
	            	getFile().delete();
	            	return SUCCESS;
	            }
	            FileInputStream inputStream = new FileInputStream(f);
	            FileOutputStream outputStream = new FileOutputStream(path + File.separator
	                    + fileFileName);
	            byte[] buf = new byte[1024];
	            int length = 0;
	            while ((length = inputStream.read(buf)) != -1) {
	                outputStream.write(buf, 0, length);
	            }
	            inputStream.close();
	            outputStream.flush();
	            outputStream.close();
	            result="上传成功！";
	            result+="  图片路径：  ";
	            result+=path + File.separator + this.getFileFileName();
	            result+="  复制：   ";
	            result+=mkdir+"/" + this.getFileFileName();
	        } catch (Exception e) {
	        	getFile().delete();
	        	BaseLog.logger.error("上传发生异常："+e);
	        	BaseLog.logger.error("删除临时文件："+getFile().getName());
	    		StackTraceElement[] st = e.getStackTrace();
	    		for(StackTraceElement el : st){
	    			BaseLog.logger.error(el);
	    		}
	            result="上传出错！";
	            throw e;
	        }
	        return SUCCESS;
	    }
}
