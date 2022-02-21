package com.fakegram.microservices.auth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="profile")
public class Profile {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="id_profile")
	private String idProfile;
	
	@Column(name="profile_name")
	private String name;
	
	@Column(name="nickname")
	private String nickname;
	
	@Column(name="bio")
	private String bio;
	
	@Column(name="profile_pic")
	private String proPic;
	
	@Column(name="email")
	private String email;
	
	@Column(name="profile_password")
	private String password;

	public Profile() {
		super();
	}

	public Profile(String idProfile, String name, String nickname, String bio, String proPic, String email,
			String password) {
		super();
		this.idProfile = idProfile;
		this.name = name;
		this.nickname = nickname;
		this.bio = bio;
		this.proPic = proPic;
		this.email = email;
		this.password = password;
	}

	public String getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(String idProfile) {
		this.idProfile = idProfile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getProPic() {
		return proPic;
	}

	public void setProPic(String proPic) {
		this.proPic = proPic;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Profile [idProfile=" + idProfile + ", name=" + name + ", nickname=" + nickname + ", bio=" + bio
				+ ", proPic=" + proPic + ", email=" + email + ", password=" + password + "]";
	}
}
