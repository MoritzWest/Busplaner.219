package BE219Thenextchapter.Controller;

import BE219Thenextchapter.dto.BusLineDTO;
import BE219Thenextchapter.dto.BusPlanDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BusPlanController {

    //TODO
    @GetMapping
    List<BusPlanDTO> getAllBusPlans();

    @GetMapping("/{BusLinesId")
    BusPlanDTO getBusLineById(@PathVariable("busLineId") long busLineId);

    @PostMapping
    BusPlanDTO addBusLine(@RequestBody BusPlanDTO BusPlanDTO);

    @PutMapping
    BusPlanDTO updateBusLine(@RequestBody BusPlanDTO BusPlanDTO);

    @DeleteMapping("/{BusLineId")
    void removeBusLineById(@PathVariable("busLineId") long busLineId);

}