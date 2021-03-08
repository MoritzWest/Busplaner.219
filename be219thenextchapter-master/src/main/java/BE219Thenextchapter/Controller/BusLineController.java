
package BE219Thenextchapter.Controller;

import BE219Thenextchapter.dto.BusLineDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BusLineController {

    //TODO
    @GetMapping
    List<BusLineDTO> getAllBusLines();

    @GetMapping("/{busLineId}")
    BusLineDTO getBusLineById(@PathVariable("busLineId") long busLineId);

    @PostMapping
    BusLineDTO addBusLine(@RequestBody BusLineDTO busLineDTO);

    @PutMapping("/{busLineId}")
    BusLineDTO updateBusLine(@PathVariable("busLineId") long busLineId, @RequestBody BusLineDTO busLineDTO);

    @DeleteMapping("/{busLineId}")
    void removeBusLineById(@PathVariable("busLineId") long busLineId);
}

