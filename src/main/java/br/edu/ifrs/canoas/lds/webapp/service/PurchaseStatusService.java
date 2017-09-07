package br.edu.ifrs.canoas.lds.webapp.service;

import br.edu.ifrs.canoas.lds.webapp.domain.Purchase;
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

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public Purchase getOne(Purchase purchase) {
        return purchaseRepository.findById(purchase.getId()).get();
    }

    public void delete(Long id) {
        purchaseRepository.deleteById(id);
    }

    public Purchase getId(Long id) {
        return purchaseRepository.getOne(id);
    }

    public List<Purchase> list() {
        return purchaseRepository.findAll();
    }

}
