package com.oriontek_test.oriontek_test.controllers;

import com.oriontek_test.oriontek_test.dto.AddressDto;
import com.oriontek_test.oriontek_test.dto.ClientWithAddressesDto;
import com.oriontek_test.oriontek_test.models.AddressModel;
import com.oriontek_test.oriontek_test.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/client/{clientId}")
    public List<AddressDto> getAddressesByClientId(@PathVariable("clientId") Long clientId) {
        return addressService.getAddressesByClientId(clientId);
    }

    @GetMapping("/client/data/{clientId}")
    public ClientWithAddressesDto getAllDataClient(@PathVariable("clientId") Long clientId){
        return addressService.clientAndAddress(clientId);
    }

    @PostMapping
    public AddressModel createAddress(@RequestBody AddressModel address) {
        return addressService.saveAddress(address);
    }
}
