package br.com.flsoftware.dsvendas.repositories;

import br.com.flsoftware.dsvendas.dto.SaleSuccessDTO;
import br.com.flsoftware.dsvendas.dto.SaleSumDTO;
import br.com.flsoftware.dsvendas.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale,Long> {
    @Query("SELECT new br.com.flsoftware.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) " +
            " FROM Sale AS obj GROUP BY obj.seller ")
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT new br.com.flsoftware.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) " +
            " FROM Sale AS obj GROUP BY obj.seller ")
    List<SaleSuccessDTO> successGroupedBySeller();
}
