package com.foodfun.common.model;

import com.foodfun.common.model.base.BaseAdmin;
import com.jfinal.plugin.activerecord.Page;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Admin extends BaseAdmin<Admin> {
	public static final Admin dao = new Admin();
	
	public Page<Admin> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from admin");
	}
}