package br.com.flsoftware.dsvendas.controllers;

import br.com.flsoftware.dsvendas.dto.SaleDTO;
import br.com.flsoftware.dsvendas.dto.SaleSuccessDTO;
import br.com.flsoftware.dsvendas.dto.SaleSumDTO;
import br.com.flsoftware.dsvendas.dto.SellerDTO;
import br.com.flsoftware.dsvendas.service.SaleService;
import br.com.flsoftware.dsvendas.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
    @Autowired
    private SaleService service;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping(value = "/amount-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller(){
        return ResponseEntity.ok(service.amountGroupedBySeller());
    }

    @GetMapping(value = "/success-by-seller")
    public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller(){
        return ResponseEntity.ok(service.successGroupedBySeller());
    }

}
