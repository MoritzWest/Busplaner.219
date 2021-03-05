
package de.dhbw.ravensburg.wp.be219thenextchapter.controller;

import de.dhbw.ravensburg.wp.be219thenextchapter.dto.BusDTO;
import de.dhbw.ravensburg.wp.be219thenextchapter.service.BusService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/busses")
public class BusControllerImpl implements BusController {

    private BusService busService;

    //Konstruktor
    public BusControllerImpl(de.dhbw.ravensburg.wp.be219thenextchapter.service.BusService busService) {
        this.busService = busService;
    }

    //

    //Read
    @Override
    @GetMapping
    public List<BusDTO> getAllBusses() {
        return this.busService.getAll();
    }

    @Override
    @GetMapping("/{busId}")
    public BusDTO getBusById(@PathVariable("busId") long busId) {
        return this.busService.getBusById(busId);
    }

    //Create
    @Override
    @PostMapping()
    public BusDTO addBus(@Valid @RequestBody BusDTO busDTO) {
        return this.busService.addBus(busDTO);
    }

    //Update
    @Override
    @PutMapping()
    public BusDTO updateBus(@Valid @RequestBody BusDTO busDTO) {
        return this.busService.updateBus(busDTO);
    }

    //Delete
    @Override
    @DeleteMapping("/{busId}")
    public void removeBusById(@PathVariable("busId") long busId) {
        this.busService.removeBusById(busId);
    }
}

