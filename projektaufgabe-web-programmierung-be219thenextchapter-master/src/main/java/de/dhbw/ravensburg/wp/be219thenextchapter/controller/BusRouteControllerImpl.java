
package de.dhbw.ravensburg.wp.be219thenextchapter.controller;

import de.dhbw.ravensburg.wp.be219thenextchapter.dto.BusRouteDTO;
import de.dhbw.ravensburg.wp.be219thenextchapter.service.BusRouteService;
import de.dhbw.ravensburg.wp.be219thenextchapter.service.BusRouteServiceImpl;
import de.dhbw.ravensburg.wp.be219thenextchapter.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/busRoutes") //wichtig Mehrzahl bei busRoutes
public class BusRouteControllerImpl implements BusRouteController {

   /* private BusRouteService busRouteService;

    //Konstruktor
    public BusRouteControllerImpl(BusRouteService busRouteService) {

        this.busRouteService = busRouteService;
    }


    @Override
    @GetMapping
    public List<BusRouteDTO> getAllBusRoutes() {

        return this.busRouteService.getAll();
    }

    @Override
    @GetMapping("/{busRouteId}")
    public BusRouteDTO getBusRouteById(@PathVariable("busRouteId") long busRouteId) {
        return this.busRouteService.getBusRouteById(busRouteId);
    }

    @Override
    @PostMapping()
    public BusRouteDTO addBusRoute(@Valid @RequestBody BusRouteDTO busRouteDTO) {
        return this.busRouteService.addBusRoute(busRouteDTO);
    }

    @Override
    @PutMapping()
    public BusRouteDTO updateBusRoute(@Valid @RequestBody BusRouteDTO busRouteDTO) {
        return this.busRouteService.updateBusRoute(busRouteDTO);
    }

    @Override
    @DeleteMapping("/{busRouteId}")
    public void removeBusRouteById(@PathVariable("busRouteId") long busRouteId) {
        this.busRouteService.removeBusRouteById(busRouteId);
    } */
}

