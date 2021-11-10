package com.example.c2tc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.c2tc.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}

