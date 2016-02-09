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
	        File file = new File(path); // �ж��ļ����Ƿ����,����������򴴽��ļ���
	        if (!file.exists()) {
	            file.mkdir();
	        }
	        String[] fileSuffix = new String[] { ".png",".jpg",".gif" ,".jpeg",".bmp"};// ��ֹ�ļ�
	        try {
	            File f = this.getFile();
	            // �ж��ļ���ʽ
	            boolean flog=false;
	            for (int i = 0; i < fileSuffix.length; i++) {
	                if (fileFileName.endsWith(fileSuffix[i])) {
	                    flog=true;
	                }
	            }
	            if(!flog){
	            	result="��ʽ���ԣ�";
	            	getFile().delete();
	            	return SUCCESS;
	            }
	            System.out.println("�ļ�������"+getFile().length());
	            if(getFile().length()>=10971520){
	            	result="�ļ�����̫��";
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
	            result="�ϴ��ɹ���";
	            result+="  ͼƬ·����  ";
	            result+=path + File.separator + this.getFileFileName();
	            result+="  ���ƣ�   ";
	            result+=mkdir+"/" + this.getFileFileName();
	        } catch (Exception e) {
	        	getFile().delete();
	        	BaseLog.logger.error("�ϴ������쳣��"+e);
	        	BaseLog.logger.error("ɾ����ʱ�ļ���"+getFile().getName());
	    		StackTraceElement[] st = e.getStackTrace();
	    		for(StackTraceElement el : st){
	    			BaseLog.logger.error(el);
	    		}
	            result="�ϴ�����";
	            throw e;
	        }
	        return SUCCESS;
	    }
}
