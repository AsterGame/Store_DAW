package com.StoreOnline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/usuario")

public class UsuarioController {

	@RequestMapping("/registro")
	public String registro( Model model ) {
	
		return "register";
		
	}
	
	@RequestMapping("/login")
	public String login( Model model ) {
	
		return "login";
		
	}
	
}
