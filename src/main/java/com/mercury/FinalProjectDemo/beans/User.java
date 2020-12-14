package com.mercury.FinalProjectDemo.beans;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "msi_user")
public class User implements UserDetails{
	@SequenceGenerator(name = "msi_user_id_seq", sequenceName = "MSI_USER_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator="msi_user_id_seq", strategy = GenerationType.AUTO)
	@Id
	private int id;
	@Column
	private String username;
	@Column 
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade= CascadeType.DETACH)
	@JoinTable(
		name = "msi_user_profile",
		joinColumns = {
			@JoinColumn(name="user_id", referencedColumnName="id")
		},
		inverseJoinColumns= {
			@JoinColumn(name="profile_id", referencedColumnName="id")
		}
	)
	
	private List<Profile> profiles;
	
	public User() {
		super();
	}
	
	public User(int id, String username, String password, List<Profile> profiles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.profiles = profiles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Profile> getProfiles() {
		return profiles;
	}
	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", profiles=" + profiles + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return profiles;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
