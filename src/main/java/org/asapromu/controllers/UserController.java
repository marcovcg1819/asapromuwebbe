package org.asapromu.controllers;

import org.asapromu.entities.Users;
import org.asapromu.models.ChangePassModel;
import org.asapromu.security.enc.BcryptGenerator;
import org.asapromu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/asapromu/admin/v1/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private BcryptGenerator bcryptGenerator;
	
	@PatchMapping
	@RequestMapping("/changePassword")
	public ResponseEntity changePassword(@RequestBody ChangePassModel changePassModel, @RequestHeader("Authorization") String bearerToken) {
		Users usr = userService.getByToken(bearerToken);
		
		
		if(!bcryptGenerator.passwordDecoder(changePassModel.getLastPass(), usr.getPassworduser())){
			return new ResponseEntity("Las contraseñas no coinciden", HttpStatus.NOT_FOUND);
		}
		
		usr.setPassworduser(bcryptGenerator.passwordEncoder(changePassModel.getNewPass()));
		
		userService.save(usr);
		
		
		return new ResponseEntity(usr, HttpStatus.OK);
	}

}
