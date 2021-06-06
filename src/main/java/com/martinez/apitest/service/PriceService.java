package com.martinez.apitest.service;

import com.martinez.apitest.dto.PriceDTO;
import com.martinez.apitest.models.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceService {

    List<Price> getAll();
    PriceDTO getByDate(LocalDateTime localDateTime, int productId, int brandId);
}
