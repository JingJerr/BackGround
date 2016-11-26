package com.foodfun.common.config;

import com.foodfun.common.model._MappingKit;
import com.foodfun.hello.HelloController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
/**
 * API����ʽ����
 */
public class FoodfunConfig extends JFinalConfig{
	/**
	 * ���ó���
	 */
	public void configConstant(Constants me) {
		// ����������Ҫ���ã�������PropKit.get(...)��ȡֵ
		PropKit.use("a_little_config.txt");
		me.setDevMode(PropKit.getBoolean("devMode", false));
	}
	/**
	 * ����·��
	 */
	public void configRoute(Routes me) {
		me.add("/hello", HelloController.class);  
	}
	
	public static C3p0Plugin createC3p0Plugin() {
		return new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
	}
	
	/**
	 * ���ò��
	 */
	public void configPlugin(Plugins me) {
		// ����C3p0���ݿ����ӳز��
		C3p0Plugin C3p0Plugin = createC3p0Plugin();
		me.add(C3p0Plugin);
		
		// ����ActiveRecord���
		ActiveRecordPlugin arp = new ActiveRecordPlugin(C3p0Plugin);
		me.add(arp);
		
		// ���������� MappingKit �и㶨
		_MappingKit.mapping(arp);
	}
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
