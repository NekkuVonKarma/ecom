package com.neesis.ecom.infrastructure.rest.mapper;

import com.neesis.ecom.domain.Price;
import com.neesis.ecom.infrastructure.rest.dto.PriceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceDto toDto (Price price);

    Price toDomain (PriceDto priceDto);
}
