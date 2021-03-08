
package BE219Thenextchapter.Controller;

import BE219Thenextchapter.dto.BusDTO;
import BE219Thenextchapter.Service.BusService;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/busses")
@Setter
public class BusControllerImpl implements BusController {

    private BusService busService;

    //Konstruktor
    public BusControllerImpl(BusService busService) {
        setBusService(busService);
    }

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
    @PostMapping
    public BusDTO addBus(@Valid @RequestBody BusDTO busDTO) {
        return this.busService.addBus(busDTO);
    }

    //Update
    @Override
    @PutMapping("/{busId}")
    public BusDTO updateBus(@Valid @RequestBody BusDTO busDTO,
                            @PathVariable("busId") Long busId) {
        return this.busService.updateBus(busDTO);
    }

    //Delete
    @Override
    @DeleteMapping("/{busId}")
    public void removeBusById(@PathVariable("busId") long busId) {
        this.busService.removeBusById(busId);
    }
}

