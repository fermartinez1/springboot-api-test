package com.martinez.apitest.service;

import com.martinez.apitest.dto.PriceDTO;
import com.martinez.apitest.exception.PriceNotFoundException;
import com.martinez.apitest.models.Price;
import com.martinez.apitest.repository.PriceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    private PriceRepository priceRepository;
    private ModelMapper priceMapper;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository, ModelMapper priceMapper){
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
    }

    @Override
    public List<Price> getAll(){
        return priceRepository.findAll();
    }

    @Override
    public PriceDTO findPriceByDateProductAndBrand(LocalDateTime date, int productId, int brandId) throws PriceNotFoundException {
        Optional<Price> price = priceRepository.findPriceByDateProductAndBrand(date, productId, brandId);
        if (price.isEmpty())
            throw new PriceNotFoundException("Price not found");
        return priceMapper.map(price.get(),PriceDTO.class);
    }
}
