package com.action;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;

public class FileUpLoadAction extends ActionSupport{
	   private static final long serialVersionUID = 1L;
	   // �û��ϴ����ļ�
	    private File                 uploadFile;      
	    // �ϴ��ļ����ļ���
	    private String              uploadFileFileName;  
	    // �ϴ��ļ�������  
	    private String              uploadFileContentType;                     
	    //uploadfile ����getter����
		public File getUploadFile() {
			return uploadFile;
		}
		//uploadfile����setter����
		public void setUploadFile(File uploadFile) {
			this.uploadFile = uploadFile;
		}
		//uploadfilefilename����getter����
		public String getUploadFileFileName() {
			return uploadFileFileName;
		}
		//uploadfilefilename����setter����
		public void setUploadFileFileName(String uploadFileFileName) {
			this.uploadFileFileName = uploadFileFileName;
		}
		//uploadfilecontenttype����getter����
		public String getUploadFileContentType() {
			return uploadFileContentType;
		}
		//uploadfilecontenttype����setter����
		public void setUploadFileContentType(String uploadFileContentType) {
			this.uploadFileContentType = uploadFileContentType;
		}
		//����execute����
		public String execute() throws Exception
	    {		
	        if (uploadFile!= null)
	        {      	  
	        	// �ϴ��ļ���ŵ�Ŀ¼
	            String dataDir = "d:\\upload\\";
	            // �ϴ��ļ��ڷ����������λ��
	            File savedFile = new File(dataDir, uploadFileFileName);
	            // ���ϴ��ļ�����ʱ�ļ����Ƶ�ָ���ļ�
	            uploadFile.renameTo(savedFile);
	        }
	        else
	        {
	            return INPUT;
	        }

	        return SUCCESS;
	    }
}
