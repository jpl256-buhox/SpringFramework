/**
 * 
 */
package com.devs4j.users.models;

/**
 * @author Buhox
 *
 */
public class User {
	private String username;
	private String nickName;
	private String password;

	
	
	public User() {
	}
	public User(String nickName,  String username,String password) {
		this.username = username;
		this.nickName = nickName;
		this.password = password;
	
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


}
