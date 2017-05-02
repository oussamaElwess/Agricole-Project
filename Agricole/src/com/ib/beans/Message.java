package com.ib.beans;

import java.sql.Timestamp;

public class Message {
private int msg_id;
private String msg_content;
private int msg_from;
private int msg_to;
private Timestamp msg_created;
public int getMsg_id() {
	return msg_id;
}
public void setMsg_id(int msg_id) {
	this.msg_id = msg_id;
}
public String getMsg_content() {
	return msg_content;
}
public void setMsg_content(String msg_content) {
	this.msg_content = msg_content;
}
public int getMsg_from() {
	return msg_from;
}
public void setMsg_from(int msg_from) {
	this.msg_from = msg_from;
}
public int getMsg_to() {
	return msg_to;
}
public void setMsg_to(int msg_to) {
	this.msg_to = msg_to;
}
public Timestamp getMsg_created() {
	return msg_created;
}
public void setMsg_created(Timestamp msg_created) {
	this.msg_created = msg_created;
}

}
