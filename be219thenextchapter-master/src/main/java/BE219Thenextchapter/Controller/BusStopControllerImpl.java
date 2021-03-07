package BE219Thenextchapter.Controller;

import BE219Thenextchapter.Service.BusStopService;
import BE219Thenextchapter.dto.BusStopDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/busStops")
public class BusStopControllerImpl implements BusStopController{

    private BusStopService busStopService;

    //Konstruktor
    public BusStopControllerImpl (BusStopService busStopService){

        this.busStopService = busStopService;
    }

    //

    //Read
    @Override
    @GetMapping
    public List<BusStopDTO> getAllBusStops() {
        return this.busStopService.getAll();
    }

    @Override
    @GetMapping("/{busStopId}")
        public BusStopDTO getBusStopById(@PathVariable("busStopId") long busStopId) {
        return this.busStopService.getBusStopById(busStopId);
    }

    //Create
    @Override
    @PostMapping()
    public BusStopDTO addBusStop(BusStopDTO busStopDTO) {

        return this.busStopService.addBusStop(busStopDTO);
    }

    //Update
    @Override
    @PutMapping()
    public BusStopDTO updateBusStop(BusStopDTO busStopDTO) {

        return this.busStopService.updateBusStop(busStopDTO);
    }

    //Delete
    @Override
    @DeleteMapping("/{busStopId}")
    public void removeBusStopById(long busStopId) {
        this.busStopService.removeBusStopById(busStopId);
    }
}

