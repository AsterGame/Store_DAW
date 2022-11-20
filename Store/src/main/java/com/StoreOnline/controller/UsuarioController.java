package com.StoreOnline.controller;
//atributo de tipo sesión


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.StoreOnline.entity.Enlace;
import com.StoreOnline.entity.Usuario;
import com.StoreOnline.service.UsuarioService;


@SessionAttributes({"ENLACES","USUARIO"})
@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService servicio;
	
	@RequestMapping("/login")
	public String login(){
		
		return "login";
	}
	
	@RequestMapping("/index")
	public String intranet(Authentication  auth,Model model){
		//obtener nombre del usuario
		String vLogin=auth.getName();
		Usuario u=servicio.loginUsuario(vLogin);
		List<Enlace> lista=servicio.enlacesDelUsuario(u.getRol().getCodigo());
		model.addAttribute("ENLACES",lista);
		
		return "tables";
	}
}
