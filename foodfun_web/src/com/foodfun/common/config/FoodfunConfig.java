package com.foodfun.common.config;

import com.foodfun.hello.HelloController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
/**
 * API����ʽ����
 */
public class FoodfunConfig extends JFinalConfig{
	/**
	 * ���ó���
	 */
	public void configConstant(Constants me) {
		me.setDevMode(true);  
	}
	/**
	 * ����·��
	 */
	public void configRoute(Routes me) {
		me.add("/hello", HelloController.class);  
	}
	/**
	 * ���ò��
	 */
	public void configPlugin(Plugins me) {}
	/**
	 * ����ȫ��������
	 */
	public void configInterceptor(Interceptors me) {}
	/**
	 * ���ô�����
	 */
	public void configHandler(Handlers me) {}
	/**
	 * ����ʹ�� JFinal �ֲ��Ƽ��ķ�ʽ������Ŀ
	 * ���д� main ��������������Ŀ����main�������Է����������Class�ඨ���У���һ��Ҫ���ڴ�
	 */
	public static void main(String[] args) {
		JFinal.start("WebRoot", 80, "/", 5);
	}
}
