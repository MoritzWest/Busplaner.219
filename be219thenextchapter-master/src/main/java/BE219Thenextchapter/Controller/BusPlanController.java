/*
package de.dhbw.ravensburg.wp.be219thenextchapter.controller;

import de.dhbw.ravensburg.wp.be219thenextchapter.dto.BusLineDTO;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.Bus;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusLine;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BusLineController {

    @GetMapping
    List<BusLineDTO> getAllBusasLines();

    @GetMapping("/{BusLinesId")
    BusLinesDTO getBusLineById(@PathVariable("busLineId") long busLineId);

    @PostMapping
    BusScheduleDTO addBusLine(@RequestBody BusLineDTO busLineDTO);

    @PutMapping
    BusLineDTO updateBusLine(@RequestBody BusLineDTO busLineDTO);

    @DeleteMapping("/{BusLineId")
    void removeBusLineById(@PathVariable("busLineId") long busLineId);

}
*/
