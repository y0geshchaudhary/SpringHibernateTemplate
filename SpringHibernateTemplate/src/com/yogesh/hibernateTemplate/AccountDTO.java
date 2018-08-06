package com.yogesh.hibernateTemplate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account1")
public class AccountDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="AccountId")
	private String accountId;
	
	
	public int getId() {
		return id;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	

}
