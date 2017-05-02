package com.ib.beans;

import java.sql.Timestamp;

public class Operations {
		
	private int op_id;
	private String op_type;
	private int ope_amount;
	private String opDescription;
	private int opeAccountId;
	private Timestamp  opeCreated;
	private Timestamp  opeUpdated;
	private int ope_dispute;
	
	public int getOp_id() {
	    return op_id;
	}
	public void setOp_id(int op_id) {
	    this.op_id = op_id;
	}
	public String getOp_type() {
	    return op_type;
	}
	public void setOp_type(String op_type) {
	    this.op_type = op_type;
	}
	public int getOpe_amount() {
	    return ope_amount;
	}
	public void setOpe_amount(int ope_amount) {
	    this.ope_amount = ope_amount;
	}
	public String getOpDescription() {
	    return opDescription;
	}
	public void setOpDescription(String opDescription) {
	    this.opDescription = opDescription;
	}
	public int getOpeAccountId() {
	    return opeAccountId;
	}
	public void setOpeAccountId(int opeAccountId) {
	    this.opeAccountId = opeAccountId;
	}
	public Timestamp getOpeCreated() {
	    return opeCreated;
	}
	public void setOpeCreated(Timestamp opeCreated) {
	    this.opeCreated = opeCreated;
	}
	public Timestamp getOpeUpdated() {
	    return opeUpdated;
	}
	public void setOpeUpdated(Timestamp opeUpdated) {
	    this.opeUpdated = opeUpdated;
	}
	public int getOpe_dispute() {
	    return ope_dispute;
	}
	public void setOpe_dispute(int ope_dispute) {
	    this.ope_dispute = ope_dispute;
	}

}