package com.neesis.ecom.application.service;

import com.neesis.ecom.domain.Price;

public interface IPriceService {

    Price getPriceBySystemDateProductIdAndPriceList(String systemDate, Integer productId, Integer priceList);

}
