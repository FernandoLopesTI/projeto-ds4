package br.com.flsoftware.dsvendas.service;

import br.com.flsoftware.dsvendas.dto.SellerDTO;
import br.com.flsoftware.dsvendas.model.Seller;
import br.com.flsoftware.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    public List<SellerDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(s -> new SellerDTO(s))
                .collect(Collectors.toList());
    }
}
