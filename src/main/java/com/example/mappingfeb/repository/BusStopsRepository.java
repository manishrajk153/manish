package com.example.mappingfeb.repository;

import com.example.mappingfeb.entity.BusStops;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusStopsRepository extends JpaRepository<BusStops, Long> {
}