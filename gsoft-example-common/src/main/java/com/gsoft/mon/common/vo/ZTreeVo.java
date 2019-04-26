package com.gsoft.mon.common.vo;

import java.io.Serializable;

/**
 * Ztree映射对象
 * 
 * @author LiuPeng
 * @date 2018年4月14日
 * 
 */
public class ZTreeVo implements Serializable {

	private static final long serialVersionUID = 6492342895441269363L;

	private String id;

	private String pId;
	
	private String name;
	
	private boolean open;
	
	private boolean checked;
	
	private String type;

	public ZTreeVo() {
	}
	
	public ZTreeVo(String id, String pId, String name) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
	}
	
	public ZTreeVo(String id, String pId, String name, boolean open, boolean checked) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.open = open;
		this.checked = checked;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
