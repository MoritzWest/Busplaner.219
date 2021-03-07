package BE219Thenextchapter.Controller;

import BE219Thenextchapter.dto.BusDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//test

public interface BusController {

    //Read
    @GetMapping
    List<BusDTO> getAllBusses();

    @GetMapping("/{busId}")
    BusDTO getBusById(@PathVariable("busId") long busId);

    //Create
    @PostMapping
    BusDTO addBus(@RequestBody BusDTO busDTO); // erwartet ein DTO im BOdy bereich der Abfrage

    //Update
    @PutMapping
    BusDTO updateBus(@RequestBody BusDTO busDTO); //macht ja das gleiche siehe Service

    //Delete
    @DeleteMapping("/{busId}")
    void removeBusById(@PathVariable("busId") long busId); //gibt nichts zrk.
}

