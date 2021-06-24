package com.martinez.apitest.controller;

import com.martinez.apitest.dto.PriceDTO;
import com.martinez.apitest.exception.PriceNotFoundException;
import com.martinez.apitest.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping(path = "/prices")
public class PriceController {

    private PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService){
        this.priceService = priceService;
    }

    @Operation(summary = "Get a price by date, product and brand")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Price found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PriceDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Price not found", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {@Content(mediaType = "application/json")})
    })
    @GetMapping
    ResponseEntity<PriceDTO> get(@RequestParam("date")
                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
                               @RequestParam("productId") int productId, @RequestParam("brandId") int brandId) throws PriceNotFoundException {
        return new ResponseEntity<>(priceService.findPriceByDateProductAndBrand(date, productId, brandId), HttpStatus.OK);
    }
}
