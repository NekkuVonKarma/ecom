package com.neesis.ecom.application.service;

import com.neesis.ecom.application.repository.PriceRepository;
import com.neesis.ecom.domain.Price;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class PriceService {

    private final PriceRepository priceDao;

    public Price getPriceBySystemDateProductIdAndBrandId(String systemDate, Integer productId, Integer brandId) {
        Instant filterDate = OffsetDateTime.parse(systemDate).atZoneSameInstant(ZoneId.systemDefault()).toInstant();
        List<Price> dbPrices = priceDao.getPriceBySystemDateProductIdAndBrandId(filterDate, productId, brandId);

        if(!dbPrices.isEmpty())
            return dbPrices.stream()
                    .reduce((a,b) -> a.getPriority() > b.getPriority() ? a : b)
                    .get();
        return null;
    }
}
