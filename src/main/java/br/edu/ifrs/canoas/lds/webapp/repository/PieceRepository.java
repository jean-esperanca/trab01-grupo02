package br.edu.ifrs.canoas.lds.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.canoas.lds.webapp.domain.Piece;

/*
 *  Create by Edward Ramos Aug/10/2017
 *  
 */
@Repository
public interface PieceRepository extends JpaRepository<Piece, Long>{

}
