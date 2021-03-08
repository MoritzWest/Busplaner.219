package BE219Thenextchapter.Controller;

import BE219Thenextchapter.dto.BusDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BusController {

    //Read
    @GetMapping
    List<BusDTO> getAllBusses();

    @GetMapping("/{busId}")
    BusDTO getBusById(@PathVariable("busId") long busId);

    //Create
    @PostMapping
    BusDTO addBus(@RequestBody BusDTO busDTO);

    //Update
    @PutMapping
    BusDTO updateBus(@RequestBody BusDTO busDTO,
                     @PathVariable("busId") Long busId);

    //Delete
    @DeleteMapping("/{busId}")
    void removeBusById(@PathVariable("busId") long busId);
}

