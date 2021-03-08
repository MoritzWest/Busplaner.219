
package BE219Thenextchapter.Controller;

import BE219Thenextchapter.dto.BusDTO;
import BE219Thenextchapter.Service.BusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/busses")
@Setter
public class BusControllerImpl implements BusController {

    private BusService busService;


    public BusControllerImpl(BusService busService) {
        setBusService(busService);
    }

    //Read
    @Override
    @Operation(summary = "Returns all Busses.", description = "This operation " +
            "returns all Busses existing in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Busses returned successfully"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @GetMapping
    public List<BusDTO> getAllBusses() {
        return this.busService.getAll();
    }

    @Override
    @Operation(summary = "Returns certain Bus.", description = "This operation " +
            "returns a Bus corresponding to an ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bus returned successfully"),
            @ApiResponse(responseCode = "404", description = "Given BusId does not exist"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @GetMapping("/{busId}")
    public BusDTO getBusById(@PathVariable("busId") long busId) {
        return this.busService.getBusById(busId);
    }

    //Create
    @Override
    @Operation(summary = "Adds new Bus.", description = "This operation " +
            "adds a new Bus to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bus returned successfully"),
            @ApiResponse(responseCode = "400", description = "Bus details are invalid"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @PostMapping
    public BusDTO addBus(@Valid @RequestBody BusDTO busDTO) {
        return this.busService.addBus(busDTO);
    }

    //Update
    @Override
    @Operation(summary = "Updates certain Bus.", description = "This operation " +
            "updates data of a certain Bus corresponding to an ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bus returned successfully"),
            @ApiResponse(responseCode = "400", description = "Bus details are invalid"),
            @ApiResponse(responseCode = "404", description = "Given BusId does not exist"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @PutMapping("/{busId}")
    public BusDTO updateBus(@Valid @RequestBody BusDTO busDTO,
                            @PathVariable("busId") Long busId) {
        busDTO.setId(busId);
        return this.busService.updateBus(busDTO);
    }

    //Delete
    @Override
    @Operation(summary = "Deletes certain Bus.", description = "This operation " +
            "deletes data of a certain Bus corresponding to an ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bus successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Given BusId does not exist"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @DeleteMapping("/{busId}")
    public void removeBusById(@PathVariable("busId") long busId) {
        this.busService.removeBusById(busId);
    }
}

