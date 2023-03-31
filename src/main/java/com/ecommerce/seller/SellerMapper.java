package com.ecommerce.seller;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SellerMapper {

    Seller dtoToModel(SellerDto sellerDto);

    SellerDto modelToDto(Seller seller);

    List<SellerDto> modelsTodtos(List<Seller> sellers);
}
