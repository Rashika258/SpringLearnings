package com.example.c2tc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.c2tc.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
