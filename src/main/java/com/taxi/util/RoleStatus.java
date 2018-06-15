package com.taxi.util;

public enum RoleStatus {
	SUPER_ADMIN(1) , ADMIN(2) , USER(3) , REST_STAFF(4);
	
	
	private final int id;
	private RoleStatus(int id){
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public static String getRoleName(int id) {
		String state = null;
		if (id == SUPER_ADMIN.getId()) {
			state = "Super Admin";
		}
		if (id == ADMIN.getId()) {
			state = "Admin";
		}
		if (id == USER.getId()) {
			state = "User";
		}
		if (id == REST_STAFF.getId()) {
			state = "Restaurant Staff";
		}
		return state;
	}
	
}
