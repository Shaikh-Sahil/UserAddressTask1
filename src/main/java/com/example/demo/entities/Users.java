package com.example.demo.entities;



import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "UserNew")
public class Users
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private  Integer userId;
	
	public int getUserId() {
		return userId;
	}

	

	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	
	@Column(name = "password")
	private String password;
	
	
	  @OneToMany (cascade = CascadeType.ALL)
	  @JoinColumn(name = "userId")
	 private List<Address> address;



	  

}

