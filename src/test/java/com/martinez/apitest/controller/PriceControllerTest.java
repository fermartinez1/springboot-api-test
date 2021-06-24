package com.martinez.apitest.controller;

import com.martinez.apitest.dto.PriceDTO;
import com.martinez.apitest.exception.PriceNotFoundException;
import com.martinez.apitest.service.PriceServiceImpl;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
public class PriceControllerTest {

    private final LocalDateTime TEST_START_DATE = LocalDateTime.of(2020,06,16,21,00);
    private final LocalDateTime TEST_END_DATE = LocalDateTime.of(2020,06,16,21,00);
    private final int TEST_PRODUCT = 35455;
    private final int TEST_BRAND = 1;
    private final Double TEST_PRICE = 10d;
    private final int TEST_PRICE_LIST = 1;

    @InjectMocks
    PriceController priceController;

    @Mock
    PriceServiceImpl priceService;

    @Test
    @SneakyThrows
    public void getTest(){

        PriceDTO priceDTOExpected = new PriceDTO();
        priceDTOExpected.setPrice(TEST_PRICE);
        priceDTOExpected.setPriceList(TEST_PRICE_LIST);
        priceDTOExpected.setProductId(TEST_PRODUCT);
        priceDTOExpected.setEndDate(TEST_END_DATE);
        priceDTOExpected.setStartDate(TEST_START_DATE);
        priceDTOExpected.setBrandId(TEST_BRAND);
        Mockito.when(priceService.findPriceByDateProductAndBrand(TEST_END_DATE,TEST_PRODUCT, TEST_BRAND)).thenReturn(priceDTOExpected);

        ResponseEntity<PriceDTO> result = priceController.get(TEST_END_DATE, TEST_PRODUCT, TEST_BRAND);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(priceDTOExpected.getPrice(), result.getBody().getPrice());
        Assert.assertEquals(priceDTOExpected.getPriceList(), result.getBody().getPriceList());
        Assert.assertEquals(priceDTOExpected.getBrandId(), result.getBody().getBrandId());
        Assert.assertEquals(priceDTOExpected.getEndDate(), result.getBody().getEndDate());
        Assert.assertEquals(priceDTOExpected.getProductId(), result.getBody().getProductId());
        Assert.assertEquals(priceDTOExpected.getStartDate(), result.getBody().getStartDate());
    }

}
