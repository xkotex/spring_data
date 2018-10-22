package com.example.NumberGame.repository;

import com.example.NumberGame.entity.RequestTable;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RequestTableRepository extends CrudRepository<RequestTable, UUID> {
    //default spring DAO
}
