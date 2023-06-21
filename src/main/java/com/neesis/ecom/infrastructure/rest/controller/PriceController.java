package com.neesis.ecom.infrastructure.rest.controller;

import com.neesis.ecom.application.service.PriceService;
import com.neesis.ecom.infrastructure.rest.dto.PriceDto;
import com.neesis.ecom.infrastructure.rest.mapper.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PriceController {

    private final PriceMapper priceMapper;

    private final PriceService priceService;

    @GetMapping(value = "prices/get", params = {"systemDate", "productId", "priceList"})
    public ResponseEntity<PriceDto> getPriceBySystemDateProductIdAndPriceList(@RequestParam String systemDate,
                                                                              @RequestParam Integer productId,
                                                                              @RequestParam Integer priceList) {
        return new ResponseEntity<>(priceMapper.toDto(priceService.getPriceBySystemDateProductIdAndPriceList(systemDate, productId, priceList)), HttpStatus.OK);
    }
}
