package br.edu.ifrs.canoas.lds.webapp.service;

import br.edu.ifrs.canoas.lds.webapp.domain.Client;
import br.edu.ifrs.canoas.lds.webapp.domain.Product;
import br.edu.ifrs.canoas.lds.webapp.domain.Purchase;
import br.edu.ifrs.canoas.lds.webapp.domain.PurchaseStatus;
import br.edu.ifrs.canoas.lds.webapp.repository.ClientRepository;
import br.edu.ifrs.canoas.lds.webapp.repository.ProductRepository;
import br.edu.ifrs.canoas.lds.webapp.repository.PurchaseStatusRepository;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.repository.PurchaseRepository;

import java.util.ArrayList;
import java.util.List;

/*
 *  Create by Lauro Pereira Sep/06/2017
 *  
 */
@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final PurchaseStatusRepository purchaseStatusRepository;

    public PurchaseService(PurchaseRepository purchaseRepository,ClientRepository clientRepository,ProductRepository productRepository, PurchaseStatusRepository purchaseStatusRepository
    ) {
        this.purchaseRepository = purchaseRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
        this.purchaseStatusRepository = purchaseStatusRepository ;
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

    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    public List<Client> listClients() {
        return clientRepository.findAll();
    }

    public List<PurchaseStatus> listPurchaseStatus() {
        return purchaseStatusRepository.findAll();
    }

    public List<PurchaseStatus> getInitialPurchaseStatus() {
        List<PurchaseStatus> initialStatus = new ArrayList();
        initialStatus.add(purchaseStatusRepository.getOne((long) 1));

        return initialStatus;
    }

}
