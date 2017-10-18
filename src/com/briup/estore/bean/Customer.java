package com.briup.estore.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @ClassName: Customer 顾客类
 *
 */
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 * */
	private Long id;
	/**
	 * 用户名
	 * */
	private String name;
	/**
	 * 密码
	 * */
	private String password;
	/**
	 * 邮编
	 * */
	private String zip;
	/**
	 * 地址
	 * */
	private String address;
	/**
	 * 手机号
	 * */
	private String telephone;
	/**
	 * email
	 * */
	private String email;
	/**
	 * 关联关系 - 一对多
	 * */
	private Set<Order> orders = new HashSet<>();
	
	public Customer(){
		
	}
	public Customer(Long id, String name, String passwd, String zip,
			String address, String telephone, String email, Set<Order> orders) {
		this.id = id;
		this.name = name;
		this.password = passwd;
		this.zip = zip;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.orders = orders;
	}

	public Customer(Long id, String name, String password, String zip, String address, String telephone, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.zip = zip;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}
	public Customer(String name, String password, String zip, String address, 
			String telephone, String email) {
		this.name = name;
		this.password = password;
		this.zip = zip;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", password=" + password + ", zip=" + zip + ", address=" + address
				+ ", telephone=" + telephone + ", email=" + email + "]";
	}
}
