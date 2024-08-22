package com.oriontek_test.oriontek_test.repositories;

import com.oriontek_test.oriontek_test.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<ClientModel, Long> {
}
