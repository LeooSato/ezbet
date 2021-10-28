package com.sato.ezbet.repository;

import java.util.List;

import com.sato.ezbet.model.Times;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TimesRepository extends JpaRepository<Times, Long>{

    public List<Times> findAllBynomeorgContainingIgnoreCase(String nomeorg);
}
