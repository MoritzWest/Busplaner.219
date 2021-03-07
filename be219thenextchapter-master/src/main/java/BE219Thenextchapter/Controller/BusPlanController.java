package BE219Thenextchapter.Controller;

import BE219Thenextchapter.dto.BusLineDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BusPlanController {

    @GetMapping
    List<BusLineDTO> getAllBusLines();

    @GetMapping("/{BusLinesId")
    BusLineDTO getBusLineById(@PathVariable("busLineId") long busLineId);

    //@PostMapping
    //BusScheduleDTO addBusLine(@RequestBody BusLineDTO busLineDTO);

    @PutMapping
    BusLineDTO updateBusLine(@RequestBody BusLineDTO busLineDTO);

    @DeleteMapping("/{BusLineId")
    void removeBusLineById(@PathVariable("busLineId") long busLineId);

}