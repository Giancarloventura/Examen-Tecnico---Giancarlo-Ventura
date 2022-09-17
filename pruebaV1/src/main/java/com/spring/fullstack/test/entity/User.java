package com.spring.fullstack.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="t_user")
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id_user")
	private Long idUser;
	
	@Column(name="tx_uid", nullable = false)
	private String txUID;
	
	@Column(name="tx_user", nullable = false)
	private String txUser;
	
	@Column(name="tx_email", nullable = false)
	private String txEmail;
	
	@Column(name="tx_pass", nullable = false)
	private String txPass;
	
	@Column(name="tx_rol", nullable = false)
	private String txRol;
	
	@Column(name="tx_fullName")
	private String txFullName;
	
	@Column(name="tx_avatar")
	private String txAvatar;
}
