package com.oriontek_test.oriontek_test.controllers;

import com.oriontek_test.oriontek_test.models.ClientModel;
import com.oriontek_test.oriontek_test.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ArrayList<ClientModel> getClients(){
        return this.clientService.getClients();
    }

    @PostMapping
    public ClientModel saveClient(@RequestBody ClientModel request){
        return this.clientService.saveClient(request);
    }

    @GetMapping(path = "/{id}")
    public Optional<ClientModel> getById(@PathVariable Long id){
        return this.clientService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public ClientModel updateClient(@RequestBody ClientModel request, @PathVariable("id") Long id){
        return this.clientService.updateClient(request, id);
    }
}
