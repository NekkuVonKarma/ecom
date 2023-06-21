package com.neesis.ecom.application.repository;

import com.neesis.ecom.domain.Price;

import java.time.Instant;
import java.util.List;

public interface PriceRepository {

    List<Price> getPriceBySystemDateProductIdAndBrandId(Instant systemDate, Integer productId, Integer brandId);
}
