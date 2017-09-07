package br.edu.ifrs.canoas.lds.webapp.service;

import br.edu.ifrs.canoas.lds.webapp.domain.Purchase;
import br.edu.ifrs.canoas.lds.webapp.domain.PurchaseStatus;
import br.edu.ifrs.canoas.lds.webapp.repository.PurchaseRepository;
import br.edu.ifrs.canoas.lds.webapp.repository.PurchaseStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseStatusService {
    private final PurchaseStatusRepository purchaseStatusRepository;
    private final PurchaseRepository purchaseRepository;

    public PurchaseStatusService(PurchaseStatusRepository purchaseStatusRepository, PurchaseRepository purchaseRepository) {
        this.purchaseStatusRepository = purchaseStatusRepository;
        this.purchaseRepository = purchaseRepository;
    }

    public PurchaseStatus save(PurchaseStatus purchaseStatus) {
        return purchaseStatusRepository.save(purchaseStatus);
    }

    public PurchaseStatus getOne(PurchaseStatus purchaseStatus) {
        return purchaseStatusRepository.findById(purchaseStatus.getId()).get();
    }

    public void delete(Long id) {
        purchaseStatusRepository.deleteById(id);
    }

    public PurchaseStatus getId(Long id) {
        return purchaseStatusRepository.getOne(id);
    }

    public List<PurchaseStatus> list() {
        return purchaseStatusRepository.findAll();
    }

    public List<Purchase> listPurchases() {return purchaseRepository.findAll(); }
}
