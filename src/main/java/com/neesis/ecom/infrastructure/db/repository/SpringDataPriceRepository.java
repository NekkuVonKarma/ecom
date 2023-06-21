package com.neesis.ecom.infrastructure.db.repository;

import com.neesis.ecom.infrastructure.db.dbo.PriceEntity;
import com.neesis.ecom.infrastructure.db.dbo.PriceEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface SpringDataPriceRepository extends JpaRepository<PriceEntity, PriceEntityId> {

    @Query("SELECT p " +
            "FROM PRICES p " +
            "WHERE :systemDate BETWEEN p.START_DATE AND p.END_DATE " +
            "   AND p.PRODUCT_ID = :productId " +
            "   AND p.PRICE_LIST = :priceList")
    List<PriceEntity> getPriceBySystemDateProductIdAndPriceList(Instant systemDate, Integer productId, Integer priceList);

}
