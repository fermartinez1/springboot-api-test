package com.martinez.apitest.controller;

import com.martinez.apitest.dto.PriceDTO;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceControllerTestIT {

    private final LocalDateTime TEST_DATE_1 = LocalDateTime.of(2020,06,14,10,00);
    private final LocalDateTime TEST_DATE_2 = LocalDateTime.of(2020,06,14,16,00);
    private final LocalDateTime TEST_DATE_3 = LocalDateTime.of(2020,06,14,21,00);
    private final LocalDateTime TEST_DATE_4 = LocalDateTime.of(2020,06,15,10,00);
    private final LocalDateTime TEST_DATE_5 = LocalDateTime.of(2020,06,16,21,00);
    private final int TEST_PRODUCT = 35455;
    private final int TEST_BRAND = 1;

    @Autowired
    PriceController priceController;

    @Test
    @SneakyThrows
    public void get(){
        ResponseEntity<PriceDTO> result = priceController.get(TEST_DATE_5, TEST_PRODUCT, TEST_BRAND);
        Assert.notNull(result.getBody());
    }

    //Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    @SneakyThrows
    public void test_1(){
        ResponseEntity<PriceDTO> result = priceController.get(TEST_DATE_1, TEST_PRODUCT, TEST_BRAND);
        Assert.notNull(result);
        Assert.isTrue(result.getBody().getPrice() == 35.50D);
    }

    //Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    @SneakyThrows
    public void test_2(){
        ResponseEntity<PriceDTO> result = priceController.get(TEST_DATE_2, TEST_PRODUCT, TEST_BRAND);
        Assert.notNull(result);
        Assert.isTrue(result.getBody().getPrice() == 25.45D);
    }

    //Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    @SneakyThrows
    public void test_3(){
        ResponseEntity<PriceDTO> result = priceController.get(TEST_DATE_3, TEST_PRODUCT, TEST_BRAND);
        Assert.notNull(result);
        Assert.isTrue(result.getBody().getPrice() == 35.50D);
    }

    //Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
    @Test
    @SneakyThrows
    public void test_4(){
        ResponseEntity<PriceDTO> result = priceController.get(TEST_DATE_4, TEST_PRODUCT, TEST_BRAND);
        Assert.notNull(result);
        Assert.isTrue(result.getBody().getPrice() == 30.50d);
    }

    //Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
    @Test
    @SneakyThrows
    public void test_5(){
        ResponseEntity<PriceDTO> result = priceController.get(TEST_DATE_5, TEST_PRODUCT, TEST_BRAND);
        Assert.notNull(result);
        Assert.isTrue(result.getBody().getPrice() == 38.95d);
    }
}
