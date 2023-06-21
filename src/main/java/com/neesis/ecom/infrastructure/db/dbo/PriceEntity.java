package com.neesis.ecom.infrastructure.db.dbo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@IdClass(PriceEntityId.class)
@Table(name = "PRICES")
@Getter
@Setter
@NoArgsConstructor
public class PriceEntity {
    @Id
    private Integer brandId;
    @Id
    private Integer priceList;
    @Id
    private Integer productId;

    private Instant startDate;
    private Instant endDate;
    private Integer priority;
    private BigDecimal price;
    private String currency;
}
