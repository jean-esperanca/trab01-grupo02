package br.edu.ifrs.canoas.lds.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.service.PieceService;

/*
 *  Create by Edward Ramos Aug/10/2017
 *  
 */
@Controller
@RequestMapping("/piece/")
public class PieceController {

	private final Messages messages;
	private final PieceService pieceService;
	
	public PieceController(Messages messages, PieceService pieceService) {
		this.messages = messages;
		this.pieceService = pieceService;
	}
	
	
}
