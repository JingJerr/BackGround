package com.foodfun.common.model;

import com.foodfun.common.model.base.BaseCommend;
import com.jfinal.plugin.activerecord.Page;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Commend extends BaseCommend<Commend> {
	public static final Commend dao = new Commend();
	
	public Page<Commend> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from commend");
	}
}