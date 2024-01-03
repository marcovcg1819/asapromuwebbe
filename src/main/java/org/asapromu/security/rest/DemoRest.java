package org.asapromu.security.rest;

import java.util.HashMap;
import java.util.Map;

import org.asapromu.entities.Users;
import org.asapromu.security.model.AuthenticationReq;
import org.asapromu.security.model.TokenInfo;
import org.asapromu.security.service.JwtUtilService;
import org.asapromu.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/asapromu/admin/v1")
public class DemoRest {


  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  UserDetailsService usuarioDetailsService;
  @Autowired
  UserService userService;

  @Autowired
  private JwtUtilService jwtUtilService;
  private static final Logger logger = LoggerFactory.getLogger(DemoRest.class);

  @GetMapping("/mensaje")
  public ResponseEntity<?> getMensaje() {
    logger.info("Obteniendo el mensaje");

    var auth =  SecurityContextHolder.getContext().getAuthentication();
    logger.info("Datos del Usuario: {}", auth.getPrincipal());
    logger.info("Datos de los Roles {}", auth.getAuthorities());
    logger.info("Esta autenticado {}", auth.isAuthenticated());

    Map<String, String> mensaje = new HashMap<>();
    mensaje.put("contenido", "Hola Peru");
    return ResponseEntity.ok(mensaje);
  }

  @GetMapping("/admin")
  public ResponseEntity<?> getMensajeAdmin() {

    var auth =  SecurityContextHolder.getContext().getAuthentication();
    logger.info("Datos del Usuario: {}", auth.getPrincipal());
    logger.info("Datos de los Permisos {}", auth.getAuthorities());
    logger.info("Esta autenticado {}", auth.isAuthenticated());

    Map<String, String> mensaje = new HashMap<>();
    mensaje.put("contenido", "Hola Admin");
    return ResponseEntity.ok(mensaje);
  }

  @GetMapping("/publico")
  public ResponseEntity<?> getMensajePublico() {
    var auth =  SecurityContextHolder.getContext().getAuthentication();
    logger.info("Datos del Usuario: {}", auth.getPrincipal());
    logger.info("Datos de los Permisos {}", auth.getAuthorities());
    logger.info("Esta autenticado {}", auth.isAuthenticated());

    Map<String, String> mensaje = new HashMap<>();
    mensaje.put("contenido", "Hola. esto es publico");
    return ResponseEntity.ok(mensaje);
  }



  @PostMapping("/auth")
  public ResponseEntity<TokenInfo> authenticate(@RequestBody AuthenticationReq authenticationReq) {
    logger.info("Autenticando al usuario {}", authenticationReq.getUser());

    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authenticationReq.getUser(),
            authenticationReq.getPassword()));

    final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(
        authenticationReq.getUser());
    

    final String jwt = jwtUtilService.generateToken(userDetails);
    
    Users usr = userService.getByUser(authenticationReq.getUser());
    usr.setTokenuser(jwt);
    userService.save(usr);
    

    return ResponseEntity.ok(new TokenInfo(jwt));
  }

}
