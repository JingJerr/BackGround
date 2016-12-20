package com.foodfun.common.config;

import com.foodfun.classify.ClassifyController;
import com.foodfun.collect.CollectController;
import com.foodfun.commend.CommendController;
import com.foodfun.common.model._MappingKit;
import com.foodfun.fun.FunController;
import com.foodfun.funcollect.FuncollectController;
import com.foodfun.hello.HelloController;
import com.foodfun.http.HttpController;
import com.foodfun.index.IndexController;
import com.foodfun.mclassify.MclassifyController;
import com.foodfun.openuser.OpenuserController;
import com.foodfun.recipes.RecipesController;
import com.foodfun.test.TestController;
import com.foodfun.user.UserController;
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
		me.add("/", IndexController.class, "/index");	// ����������Ϊ��Controller����ͼ���·��
		// ����������ʡ��ʱĬ�����һ������ֵ��ͬ���ڴ˼�Ϊ "/hello"
		me.add("/hello", HelloController.class);
		me.add("/test", TestController.class);
		me.add("/mclassify", MclassifyController.class);
		me.add("/classify", ClassifyController.class);
		me.add("/recipes", RecipesController.class);
		me.add("/fun", FunController.class);
		me.add("/commend", CommendController.class);
		me.add("/user", UserController.class);
		me.add("/collect", CollectController.class);
		me.add("/http", HttpController.class);
		me.add("/openuser", OpenuserController.class);
		me.add("/funcollect", FuncollectController.class);
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
