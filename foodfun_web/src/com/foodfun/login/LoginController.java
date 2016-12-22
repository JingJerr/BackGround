package com.foodfun.login;

import com.foodfun.common.model.Admin;
import com.foodfun.index.IndexController;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;

public class LoginController extends Controller{
	@Clear
	public void index(){
		render("login.html");
	}
	@Clear
	public void login(){
		String username = getPara("uname");
		String password = getPara("pwd");
		String pwd =  Admin.dao.findFirst("select password from admin where username="+"\""+username +"\"").getPassword();
		if(pwd != null){
			if(pwd.equals(password)){
				setSessionAttr("user", username);//����session�������¼�û����ǳ�
				setAttr("msg","success");
			}else{
				setAttr("msg","�������");
			}
		}else{
			setAttr("msg","�޴��û���");
		}
		renderJson();
	}
}
