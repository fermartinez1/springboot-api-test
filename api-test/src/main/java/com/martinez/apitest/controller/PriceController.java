package com.martinez.apitest.controller;

import com.martinez.apitest.dto.PriceDTO;
import com.martinez.apitest.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/prices")
public class PriceController {

    private PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService){
        this.priceService = priceService;
    }

    @GetMapping
    PriceDTO get(@RequestParam("date")
                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
                         @RequestParam("productId") int productId, @RequestParam("brandId") int brandId){
        return priceService.getByDate(date,productId,brandId);
    }
}
