package com.martinez.apitest.repository;

import com.martinez.apitest.models.Price;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PriceRepositoryTest {

    @Autowired
    PriceRepository repository;

    private final LocalDateTime TEST_END_DATE = LocalDateTime.of(2020, 06, 16, 21, 00);
    private final int TEST_PRODUCT = 35455;
    private final int TEST_BRAND = 1;

    @Test
    public void testRepository() {
        List<Price> result = repository.findAll();
        Assert.assertNotNull(result.get(0));
    }

    @Test
    public void testFindAllPricesByParam() {
        Price result = repository.findAllPricesByParam(TEST_END_DATE, TEST_PRODUCT, TEST_BRAND);
        Assert.assertNotNull(result);
    }
}
