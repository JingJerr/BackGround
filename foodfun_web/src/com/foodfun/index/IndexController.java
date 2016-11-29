package com.foodfun.index;

import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

/**
 * IndexController
 */
public class IndexController extends Controller {
	public void index() {
		render("index.html");
	}
	public void upload() {
		// ��ȡ�ϴ����ļ�
		UploadFile uf = getFile("Filedata");

		// ƴ���ļ��ϴ�������·��
		String fileName = "http://" + this.getRequest().getRemoteHost() + ":"
				+ this.getRequest().getLocalPort() + "/upload/"
				+ uf.getFileName();
		
		this.setAttr("fileName", fileName);
		System.out.println("================fileName:"+fileName);
		
		//��json��ʽ������Ⱦ
		renderJson();
	}
}
