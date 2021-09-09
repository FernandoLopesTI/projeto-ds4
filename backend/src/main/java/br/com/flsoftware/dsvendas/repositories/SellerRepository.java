package br.com.flsoftware.dsvendas.repositories;

import br.com.flsoftware.dsvendas.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
