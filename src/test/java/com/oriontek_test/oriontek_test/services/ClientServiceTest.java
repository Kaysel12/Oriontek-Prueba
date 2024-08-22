package com.oriontek_test.oriontek_test.services;

import com.oriontek_test.oriontek_test.models.ClientModel;
import com.oriontek_test.oriontek_test.repositories.IClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private IClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getClients() {
        ClientModel client1 = new ClientModel();
        client1.setName("John");
        client1.setLastName("Doe");

        ClientModel client2 = new ClientModel();
        client2.setName("Jane");
        client2.setLastName("Doe");

        ArrayList<ClientModel> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);

        when(clientRepository.findAll()).thenReturn(clients);

        ArrayList<ClientModel> result = clientService.getClients();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(client1));
        assertTrue(result.contains(client2));
    }

    @Test
    void saveClient() {
        ClientModel client = new ClientModel();
        client.setName("John");
        client.setLastName("Doe");

        when(clientRepository.save(any(ClientModel.class))).thenReturn(client);

        ClientModel result = clientService.saveClient(client);

        assertNotNull(result);
        assertEquals(client.getName(), result.getName());
        assertEquals(client.getLastName(), result.getLastName());
    }

    @Test
    void getById() {
        ClientModel client = new ClientModel();
        client.setName("John");
        client.setLastName("Doe");

        when(clientRepository.findById(anyLong())).thenReturn(Optional.of(client));

        Optional<ClientModel> result = clientService.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(client.getName(), result.get().getName());
        assertEquals(client.getLastName(), result.get().getLastName());
    }

    @Test
    void updateClient() {
        ClientModel existingClient = new ClientModel();
        existingClient.setId(1L);
        existingClient.setName("John");
        existingClient.setLastName("Doe");

        ClientModel updatedClient = new ClientModel();
        updatedClient.setName("John");
        updatedClient.setLastName("Smith");

        when(clientRepository.findById(anyLong())).thenReturn(Optional.of(existingClient));
        when(clientRepository.save(any(ClientModel.class))).thenReturn(updatedClient);

        ClientModel result = clientService.updateClient(updatedClient, 1L);

        assertNotNull(result);
        assertEquals(updatedClient.getLastName(), result.getLastName());
    }
}
