package com.yogesh.hibernateTemplate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee1")
public class PersonDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Email")
	private String email;
	
	@OneToOne()
	@JoinTable(name="Employee_Account", joinColumns = @JoinColumn(name="EmployeeID"),
	inverseJoinColumns = @JoinColumn(name="AccountID"))
	private AccountDTO account;
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public int getId() {
		return id;
	}
	public AccountDTO getAccount() {
		return account;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAccount(AccountDTO account) {
		this.account = account;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
