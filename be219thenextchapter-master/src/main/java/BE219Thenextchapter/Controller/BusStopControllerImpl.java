package BE219Thenextchapter.Controller;

import BE219Thenextchapter.Service.BusStopService;
import BE219Thenextchapter.dto.BusStopDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * @Author Moritz Westhäußer
 */

@RestController
@RequestMapping("/api/v1/busStops")
public class BusStopControllerImpl implements BusStopController{

    private BusStopService busStopService;


    public BusStopControllerImpl (BusStopService busStopService){
        this.busStopService = busStopService;
    }
    
    //Read
    @Override
    @Operation(summary = "Returns all busStops.", description = "This operation " +
            "returns all busStops existing in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All busStops returned successfully"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @GetMapping
    public List<BusStopDTO> getAllBusStops() {
        return this.busStopService.getAll();
    }

    @Override
    @Operation(summary = "Returns certain busStop.", description = "This operation " +
            "returns a busStop corresponding to an ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "BusStop returned successfully"),
            @ApiResponse(responseCode = "404", description = "Given busStopId does not exist"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @GetMapping("/{busStopId}")
        public BusStopDTO getBusStopById(@PathVariable("busStopId") long busStopId) {
        try {
            return this.busStopService.getBusStopById(busStopId);
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    //Create
    @Override
    @Operation(summary = "Adds new busStop.", description = "This operation " +
            "adds a new busStop to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "BusStop returned successfully"),
            @ApiResponse(responseCode = "400", description = "BusStop details are invalid"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @PostMapping()
    public BusStopDTO addBusStop(BusStopDTO busStopDTO) {
        try{
            return this.busStopService.addBusStop(busStopDTO);
        } catch (ConstraintViolationException constraintViolationException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //Update
    @Override
    @Operation(summary = "Updates certain busStop.", description = "This operation " +
            "updates data of a certain busStop corresponding to an ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "BusStop returned successfully"),
            @ApiResponse(responseCode = "400", description = "BusStop details are invalid"),
            @ApiResponse(responseCode = "404", description = "Given busStopId does not exist"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @PutMapping("/{busStopId}")
    public BusStopDTO updateBusStop(@PathVariable("busStopId") long busStopId, BusStopDTO busStopDTO) {
        try {
            return this.busStopService.updateBusStop(busStopId, busStopDTO);
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (ConstraintViolationException constraintViolationException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //Delete
    @Override
    @Operation(summary = "Deletes certain busStop.", description = "This operation " +
            "deletes data of a certain busStop corresponding to an ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "BusStop successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Given busStopId does not exist"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @DeleteMapping("/{busStopId}")
    public void removeBusStopById(long busStopId) {
        try {
            this.busStopService.removeBusStopById(busStopId);
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

