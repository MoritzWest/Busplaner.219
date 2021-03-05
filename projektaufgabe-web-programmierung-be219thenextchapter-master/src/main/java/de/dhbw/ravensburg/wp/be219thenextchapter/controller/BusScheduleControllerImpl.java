/*
package de.dhbw.ravensburg.wp.be219thenextchapter.controller;

import de.dhbw.ravensburg.wp.be219thenextchapter.dto.BusScheduleDTO;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusSchedule;
import de.dhbw.ravensburg.wp.be219thenextchapter.service.BusScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/busSchedules")a

public class BusScheduleControllerImpl implements BusScheduleController{

    BusScheduleService busScheduleService;

    //Konstruktor
    public BusScheduleControllerImpl(BusScheduleService busScheduleService) {
        this.busScheduleService = busScheduleService;
    }

    //

    //Read
    @Override
    @GetMapping
    public List<BusScheduleDTO> getAllBusSchedules() {
        return this.busScheduleService.getAll();
    }

    @Override
    @GetMapping("/{busScheduleId}")
    public BusScheduleDTO getBusScheduleById(@PathVariable("busScheduleId") long busScheduleId) {
        return this.busScheduleService.getBusScheduleById(busScheduleId);
    }

    //Create
    @Override
    @PostMapping
    public BusScheduleDTO addBusSchedule(BusScheduleDTO busScheduleDTO) {

        return this.busScheduleService.addBusSchedule(busScheduleDTO);
    }

    //Update
    @Override
    @PutMapping
    public BusScheduleDTO updateBusSchedule(BusScheduleDTO busScheduleDTO) {

        return this.busScheduleService.updateBusSchedule(busScheduleDTO);
    }

    //Delete
    @Override
    @DeleteMapping
    public void removeBusScheduleById(long busScheduleId) {
        this.busScheduleService.removeBusScheduleById(busScheduleId);
    }
}
*/
