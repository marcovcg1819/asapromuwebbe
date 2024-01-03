package org.asapromu.security.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class AuthenticationReq implements Serializable {

	private static final long serialVersionUID = 1L;

	private String user;

	private String password;


}
