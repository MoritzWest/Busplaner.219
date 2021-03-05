/*
package de.dhbw.ravensburg.wp.be219thenextchapter.controller;

import de.dhbw.ravensburg.wp.be219thenextchapter.dto.BusStopDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BusStopController {

    //Read
    @GetMapping
    List<BusStopDTO> getAllBusStops();

    @GetMapping("{/BusStopId")
    BusStopDTO getBusStopById(@PathVariable("busStopId") long busStopId); //in den Pfad oben gibt man hinter dem / die id als Pfadvariable ein

    //Create
    @PostMapping
    BusStopDTO addBusStop(@RequestBody BusStopDTO busStopDTO);

    //Update
    @PutMapping
    BusStopDTO updateBusStop(@RequestBody BusStopDTO busStopDTO);

    //Delete
    @DeleteMapping("{/BusStopId")
    void removeBusStopById(@PathVariable("busStopId") long busStopId);



}
*/
