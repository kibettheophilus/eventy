package com.theophiluskibet.eventy.repository;

import com.theophiluskibet.eventy.dtos.HelloWorldDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloWorldRepository extends JpaRepository<HelloWorldDto, String> {
}
