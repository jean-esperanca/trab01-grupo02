package br.edu.ifrs.canoas.lds.webapp.repository;

import br.edu.ifrs.canoas.lds.webapp.domain.PurchaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseStatusRepository extends JpaRepository<PurchaseStatus, Long> {

}
