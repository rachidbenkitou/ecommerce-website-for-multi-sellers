package com.ecommerce.seller;

import com.ecommerce.seller.service.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/seller")
@AllArgsConstructor
public class SellerController {
    private SellerService sellerService;
    @GetMapping("/all")
    public List<SellerDto> getAllSellers(){
        return sellerService.findAllSeller();
    }
    @GetMapping("/find/name/{firstName}")
    public List<SellerDto> getSeller(@PathVariable String firstName){
        return sellerService.findByFirstName(firstName);
    }
    @PostMapping("/save")
    public SellerDto saveSeller(@RequestBody SellerDto sellerDto){
        return sellerService.saveSeller(sellerDto);
    }
    @PutMapping("/update")
    public SellerDto editSeller(@RequestBody SellerDto sellerDto){
        return sellerService.updateSeller(sellerDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteSeller(@PathVariable String id){
        sellerService.deleteSeller(id);
    }
}
