package com.summer.gateway.entity.security;



public class SysRole implements Comparable<SysRole>{
	private Integer id;
	private String name;
	private Integer roleLevel;
	private String description;
	private String menuItems;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRoleLevel() {
		return roleLevel;
	}
	public void setRoleLevel(Integer roleLevel) {
		this.roleLevel = roleLevel;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(String menuItems) {
		this.menuItems = menuItems;
	}

	@Override
	public int compareTo(SysRole o) {
		if(id == o.getId()){
			return 0;
		}else if(id > o.getId()){
			return 1;
		}else{
			return -1;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof SysRole){
			if(this.id == ((SysRole)obj).getId()){
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "SysRole{" +
			"id=" + id +
			", name=" + name +
			", roleLevel=" + roleLevel +
			", description=" + description +
			'}';
		}
}