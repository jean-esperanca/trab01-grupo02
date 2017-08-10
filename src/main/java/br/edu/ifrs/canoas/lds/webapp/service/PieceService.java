package br.edu.ifrs.canoas.lds.webapp.service;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.repository.PieceRepository;

/*
 *  Create by Edward Ramos Aug/10/2017
 *  
 */
@Service
public class PieceService {

	private final PieceRepository pieceRepository;

	public PieceService(PieceRepository pieceRepository) {
		this.pieceRepository = pieceRepository;
	}
	
}
