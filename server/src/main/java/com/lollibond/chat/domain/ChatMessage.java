package com.lollibond.chat.domain;

import java.util.Date;

public class ChatMessage {

	private String u1;
	private String u2;
	private String body;
	private String fromUser;
	private Date time;

	public String getU1() {
		return u1;
	}

	public void setU1(String u1) {
		this.u1 = u1;
	}

	public String getU2() {
		return u2;
	}

	public void setU2(String u2) {
		this.u2 = u2;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
