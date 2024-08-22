package com.oriontek_test.oriontek_test.services;

import com.oriontek_test.oriontek_test.models.ClientModel;
import com.oriontek_test.oriontek_test.repositories.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    IClientRepository clientRepository;

    public ArrayList<ClientModel> getClients (){
        return (ArrayList<ClientModel>) clientRepository.findAll();
    }

    public ClientModel saveClient(ClientModel client){
        return clientRepository.save(client);
    }

    public Optional<ClientModel> getById(Long id){
        return clientRepository.findById(id);
    }

    public ClientModel updateClient(ClientModel request, Long id){
        ClientModel clientBeforeUpdate = clientRepository.findById(id).get();

        clientBeforeUpdate.setName(request.getName());
        clientBeforeUpdate.setLastName(request.getLastName());

        return clientRepository.save(clientBeforeUpdate);
    }
}
