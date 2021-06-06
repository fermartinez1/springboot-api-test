package com.martinez.apitest.repository;

import com.martinez.apitest.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {

    @Query(value = "SELECT * FROM prices p WHERE :date>=p.START_DATE " +
            "and :date<=p.END_DATE and product_id=:productId " +
            "and brand_id=:brandId " +
            "order by p.priority desc limit 1", nativeQuery = true)
    Price findAllPricesByParam(@Param("date") LocalDateTime date, @Param("productId") int productId,
                                     @Param("brandId") int brandId);

}
