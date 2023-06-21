package com.neesis.ecom.application.service;

import com.neesis.ecom.application.repository.PriceRepository;
import com.neesis.ecom.domain.Price;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class PriceService {

    private final PriceRepository priceDao;

    public Price getPriceBySystemDateProductIdAndPriceList(String systemDate, Integer productId, Integer priceList) {
        Instant filterDate = Instant.parse(systemDate);
        List<Price> dbPrices = priceDao.getPriceBySystemDateProductIdAndPriceList(filterDate, productId, priceList);

        if(!dbPrices.isEmpty())
            return dbPrices.stream()
                    .reduce((a,b) -> a.getPriority() > b.getPriority() ? a : b)
                    .get();
        return null;
    }
}
