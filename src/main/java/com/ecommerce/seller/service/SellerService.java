package com.ecommerce.seller.service;

import com.ecommerce.client.ClientDto;
import com.ecommerce.seller.SellerDto;

import java.util.List;

public interface SellerService {
    List<SellerDto> findAllSeller();
    List<SellerDto> findByFirstName(String firstName);
    SellerDto saveSeller(SellerDto sellerDto) ;
    SellerDto updateSeller(SellerDto sellerDto);
    void deleteSeller(String id);
}
