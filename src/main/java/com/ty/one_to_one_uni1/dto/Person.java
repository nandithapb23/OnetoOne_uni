package com.ty.one_to_one_uni1.dto;

	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.OneToOne;

	@Entity
	public class Person {
		@Id
	private int id;
	private String name;
	private String address;
	private long phone;
	private String fathername;
	@OneToOne
	private PanCard pancard;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public PanCard getPancard() {
		return pancard;
	}
	public void setPancard(PanCard pancard) {
		this.pancard = pancard;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", fathername="
				+ fathername + ", pancard=" + pancard + "]";
	}

	}


