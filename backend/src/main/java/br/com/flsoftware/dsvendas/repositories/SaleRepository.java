package br.com.flsoftware.dsvendas.repositories;

import br.com.flsoftware.dsvendas.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Long> {
}
