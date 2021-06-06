package com.martinez.apitest.service;

import com.martinez.apitest.dto.PriceDTO;
import com.martinez.apitest.models.Price;
import com.martinez.apitest.repository.PriceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

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
    public PriceDTO getByDate(LocalDateTime date, int productId, int brandId){
        Price price = priceRepository.findAllPricesByParam(date, productId, brandId);
        if(price == null)
            return null;
        return priceMapper.map(price, PriceDTO.class);
    }
}
