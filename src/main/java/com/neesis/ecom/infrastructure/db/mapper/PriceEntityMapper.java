package com.neesis.ecom.infrastructure.db.mapper;

import com.neesis.ecom.domain.Price;
import com.neesis.ecom.infrastructure.db.dbo.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {

    Price toDomain(PriceEntity priceEntity);

    PriceEntity toDbo(Price price);
}
