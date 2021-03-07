package BE219Thenextchapter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/busLines") //Plural bei busLines
public class BusLineControllerImpl implements BusLineController {

   /* private BusRouteService busRouteService;

    //Konstruktor
    public BusLineControllerImpl(BusLineService busLineService) {

        this.busLineService = busLineService;
    }


    @Override
    @GetMapping
    public List<BusLineDTO> getAllBusLines() {

        return this.busLinesService.getAll();
    }

    @Override
    @GetMapping("/{busLineId}")
    public BusLineDTO getBusLineById(@PathVariable("busLineId") long busLineId) {
        return this.busLineService.getBusLineById(busLineId);
    }

    @Override
    @PostMapping()
    public BusLineDTO addBusLine(@Valid @RequestBody BusLineDTO busLineDTO) {
        return this.busLineService.addBusLine(busLineDTO);
    }

    @Override
    @PutMapping()
    public BusLineDTO updateBusLine(@Valid @RequestBody BusLineDTO busLineDTO) {
        return this.busLineService.updateBusLine(busLineDTO);
    }

    @Override
    @DeleteMapping("/{busLineId}")
    public void removeBusLineById(@PathVariable("busLineId") long busLineId) {
        this.busLineService.removeBusLineById(busLineId);
    } */
}

