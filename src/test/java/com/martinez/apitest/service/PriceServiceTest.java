package com.martinez.apitest.service;

import com.martinez.apitest.dto.PriceDTO;
import com.martinez.apitest.models.Price;
import com.martinez.apitest.repository.PriceRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
public class PriceServiceTest {

    @InjectMocks
    PriceServiceImpl priceService;

    @Mock
    PriceRepository priceRepository;

    @Mock
    ModelMapper modelMapper;

    private final LocalDateTime TEST_START_DATE = LocalDateTime.of(2020,06,16,21,00);
    private final LocalDateTime TEST_END_DATE = LocalDateTime.of(2020,06,16,21,00);
    private final int TEST_PRODUCT = 35455;
    private final int TEST_BRAND = 1;
    private final Double TEST_PRICE = 10d;
    private final int TEST_PRICE_LIST = 1;
    private final int TEST_PRIORITY = 1;
    private final String TEST_CURR = "EUR";

    @Test
    public void getByDateTest(){
        Price price = new Price();
        price.setPrice(TEST_PRICE);
        price.setPriceList(TEST_PRICE_LIST);
        price.setEndDate(TEST_END_DATE);
        price.setStartDate(TEST_START_DATE);
        price.setCurr(TEST_CURR);
        price.setPriority(TEST_PRIORITY);
        price.setBrandId(TEST_BRAND);
        price.setProductId(TEST_PRODUCT);
        Mockito.when(priceRepository.findAllPricesByParam(TEST_START_DATE,TEST_PRODUCT, TEST_BRAND)).thenReturn(price);

        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setPrice(TEST_PRICE);
        priceDTO.setPriceList(TEST_PRICE_LIST);
        priceDTO.setBrandId(TEST_BRAND);
        priceDTO.setEndDate(TEST_END_DATE);
        priceDTO.setStartDate(TEST_START_DATE);
        priceDTO.setProductId(TEST_PRODUCT);
        Mockito.when(modelMapper.map(Mockito.any(Price.class), Mockito.any())).thenReturn(priceDTO);

        PriceDTO result = priceService.getByDate(TEST_START_DATE, TEST_PRODUCT, TEST_BRAND);
        Assert.assertEquals(TEST_PRICE, result.getPrice());
        Assert.assertEquals(TEST_PRICE_LIST, result.getPriceList());
        Assert.assertEquals(TEST_END_DATE, result.getEndDate());
        Assert.assertEquals(TEST_BRAND, result.getBrandId());
        Assert.assertEquals(TEST_START_DATE, result.getStartDate());
        Assert.assertEquals(TEST_PRODUCT, result.getProductId());
    }
}
