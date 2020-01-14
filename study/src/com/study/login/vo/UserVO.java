package com.study.login.vo;

public class UserVO {
	
	private String userId;
	private String userPass;
	private String userName;
	private String userRoll;
	
	public UserVO() {

	}

	public UserVO(String userId, String userPass, String userName, String userRoll) {
		super();
		this.userId = userId;
		this.userPass = userPass;
		this.userName = userName;
		this.userRoll = userRoll;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRoll() {
		return userRoll;
	}

	public void setUserRoll(String userRoll) {
		this.userRoll = userRoll;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPass=" + userPass + ", userName=" + userName + ", userRoll="
				+ userRoll + "]";
	}
	
}
