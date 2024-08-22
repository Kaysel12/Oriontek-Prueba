package com.oriontek_test.oriontek_test.services;

import com.oriontek_test.oriontek_test.dto.AddressDto;
import com.oriontek_test.oriontek_test.dto.ClientWithAddressesDto;
import com.oriontek_test.oriontek_test.models.AddressModel;
import com.oriontek_test.oriontek_test.models.ClientModel;
import com.oriontek_test.oriontek_test.repositories.IAddressRepository;
import com.oriontek_test.oriontek_test.repositories.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private IAddressRepository addressRepository;

    @Autowired
    private IClientRepository clientRepository;

    public List<AddressDto> getAddressesByClientId(Long clientId) {
        return addressRepository.findAll().stream()
                .filter(address -> address.getClient().getId().equals(clientId))
                .map(address -> {
                    AddressDto dto = new AddressDto();
                    dto.setId(address.getId());
                    dto.setStreet(address.getStreet());
                    dto.setCity(address.getCity());
                    dto.setZipCode(address.getZipCode());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public AddressModel saveAddress(AddressModel address) {
        return addressRepository.save(address);
    }

    public ClientWithAddressesDto clientAndAddress(Long clientId){
        ClientModel client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));


        List<AddressDto> addresses = addressRepository.findAll().stream()
                .filter(address -> address.getClient().getId().equals(clientId))
                .map(this::mapToAddressDto)
                .collect(Collectors.toList());

//        List<AddressDto> Addresses = new ArrayList<>();
//        for (AddressModel address : addressRepository.findAll()) {
//            if (address.getClient().getId().equals(clientId)) {
//                AddressDto addressDto = mapToAddressDto(address);
//                Addresses.add(addressDto);
//            }
//        }

        ClientWithAddressesDto clientWithAddresses = new ClientWithAddressesDto();
        clientWithAddresses.setId(client.getId());
        clientWithAddresses.setName(client.getName());
        clientWithAddresses.setLastName(client.getLastName());
        clientWithAddresses.setAddresses(addresses);

        return clientWithAddresses;
    }

    private AddressDto mapToAddressDto(AddressModel address) {
        AddressDto dto = new AddressDto();
        dto.setId(address.getId());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setZipCode(address.getZipCode());
        return dto;
    }
}
