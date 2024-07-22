package com.example.mappingfeb.controller;


import com.example.mappingfeb.entity.Bus;
import com.example.mappingfeb.entity.BusStops;
import com.example.mappingfeb.entity.Stop;
import com.example.mappingfeb.repository.BusRepository;
import com.example.mappingfeb.repository.BusStopsRepository;
import com.example.mappingfeb.repository.StopRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bus")
public class BusStopController {

    private BusRepository busRepository;

    private StopRepository stopRepository;

    private BusStopsRepository busStopsRepository;

    public BusStopController(BusRepository busRepository, StopRepository stopRepository, BusStopsRepository busStopRepository) {
        this.busRepository = busRepository;
        this.stopRepository = stopRepository;
        this.busStopsRepository = busStopsRepository;
    }

    @PostMapping
    public ResponseEntity<BusStops> allocateBusRoute(
            @RequestParam long busId,
            @RequestParam long stopId,
            @RequestBody BusStops busStops

    ) {
        Bus bus = busRepository.findById(busId).get();
        Stop stop = stopRepository.findById(stopId).get();


        busStops.setBus(bus);
        busStops.setStop(stop);

        BusStops savedEntity = busStopsRepository.save(busStops);

        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);

    }
}
