package com.ecommerce.seller.service;

import com.ecommerce.client.ClientDto;
import com.ecommerce.client.exceptions.ClientAlreadyExistsException;
import com.ecommerce.seller.Seller;
import com.ecommerce.seller.SellerDto;
import com.ecommerce.seller.SellerMapper;
import com.ecommerce.seller.SellerRepository;
import com.ecommerce.seller.exceptions.SellerAlreadyExistsException;
import com.ecommerce.seller.exceptions.SellerNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class SellerServiceImplement implements  SellerService{
    private SellerRepository sellerRepository;
    private SellerMapper sellerMapper;
    /**
     * @return
     */
    @Override
    public List<SellerDto> findAllSeller() {
        return sellerMapper.modelsTodtos(sellerRepository.findAll());
    }

    /**
     * @param firstName
     * @return
     */
    @Override
    public List<SellerDto> findByFirstName(String firstName)throws SellerNotFoundException {
        List<Seller> sellers = sellerRepository.findByFirstName(firstName);
        if(sellers.equals(null)) throw new SellerNotFoundException("Seller Not Found Exception");
        return sellerMapper.modelsTodtos(sellers);
    }

    private SellerDto addSeller(SellerDto sellerDto){
        return sellerMapper.modelToDto(sellerRepository.save(sellerMapper.dtoToModel(sellerDto)));
    }
    /**
     * @param sellerDto
     * @return
     */
    @Override
    public SellerDto saveSeller(SellerDto sellerDto) {
        Optional<Seller> existingSeller =sellerRepository.findByEmail(sellerDto.getEmail());
        if(existingSeller.isPresent()) throw new SellerAlreadyExistsException("Seller Already Exists");
        return addSeller(sellerDto);
    }

    /**
     * @param sellerDto
     * @return
     */
    @Override
    public SellerDto updateSeller(SellerDto sellerDto) {
        return addSeller(sellerDto);
    }

    /**
     * @param id
     */
    @Override
    public void deleteSeller(String id) {
        sellerRepository.findById(id).orElseThrow(()->new SellerNotFoundException("Seller Not Found"));
        sellerRepository.deleteById(id);
    }
}
