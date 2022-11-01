package com.StoreOnline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/usuario")

public class UsuarioController {

	@RequestMapping("/perfil")
	public String listarMenu( Model model ) {
	
		return "register";
		
	}
	
}
