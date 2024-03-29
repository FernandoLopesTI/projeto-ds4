package br.com.flsoftware.dsvendas.service;

import br.com.flsoftware.dsvendas.dto.SaleDTO;
import br.com.flsoftware.dsvendas.dto.SaleSuccessDTO;
import br.com.flsoftware.dsvendas.dto.SaleSumDTO;
import br.com.flsoftware.dsvendas.repositories.SaleRepository;
import br.com.flsoftware.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable){
        sellerRepository.findAll();
        return repository
                .findAll(pageable)
                .map(s -> new SaleDTO(s));
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller() {
        return repository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupedBySeller() {
        return repository.successGroupedBySeller();
    }
}
