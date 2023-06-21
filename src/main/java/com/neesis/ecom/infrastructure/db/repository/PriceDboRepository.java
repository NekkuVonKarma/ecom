package com.neesis.ecom.infrastructure.db.repository;

import com.neesis.ecom.application.repository.PriceRepository;
import com.neesis.ecom.domain.Price;
import com.neesis.ecom.infrastructure.db.dbo.PriceEntity;
import com.neesis.ecom.infrastructure.db.mapper.PriceEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PriceDboRepository implements PriceRepository {

    private final SpringDataPriceRepository priceRepository;
    private final PriceEntityMapper entityMapper;

    @Override
    public List<Price> getPriceBySystemDateProductIdAndPriceList(Instant systemDate, Integer productId, Integer priceList) {
        List<Price> resultPrices = new ArrayList<>();
        List<PriceEntity> dbPrices = priceRepository.getPriceBySystemDateProductIdAndPriceList(systemDate, productId, priceList);

        dbPrices.forEach(dbPrice -> resultPrices.add(entityMapper.toDomain(dbPrice)));

        return resultPrices;
    }
}
