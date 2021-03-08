package BE219Thenextchapter.Controller;

import BE219Thenextchapter.Service.BusLineService;
import BE219Thenextchapter.dto.BusLineDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/busLines") //Plural bei busLines
public class BusLineControllerImpl implements BusLineController {

    private BusLineService busLineService;


    public BusLineControllerImpl(BusLineService busLineService) {
        this.busLineService = busLineService;
    }


    @Override
    @Operation(summary = "Returns all busLines.", description = "This operation " +
            "returns all busLines existing in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All busLines returned successfully"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @GetMapping
    public List<BusLineDTO> getAllBusLines() {
        return this.busLineService.getAll();
    }

    @Override
    @Operation(summary = "Returns certain busLine.", description = "This operation " +
            "returns a busLine corresponding to an ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "BusLine returned successfully"),
            @ApiResponse(responseCode = "404", description = "Given busLineId does not exist"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @GetMapping("/{busLineId}")
    public BusLineDTO getBusLineById(@PathVariable("busLineId") long busLineId) {
        try {
            return this.busLineService.getBusLineById(busLineId);
        } catch(EntityNotFoundException entityNotFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @Operation(summary = "Adds new busLine.", description = "This operation " +
            "adds a new busLine to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "BusLine returned successfully"),
            @ApiResponse(responseCode = "400", description = "BusLine details are invalid"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @PostMapping()
    public BusLineDTO addBusLine(@Valid @RequestBody BusLineDTO busLineDTO) {
        try {
            return this.busLineService.addBusLine(busLineDTO);
        } catch (ConstraintViolationException constraintViolationException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Operation(summary = "Updates certain busLine.", description = "This operation " +
            "updates data of a certain busLine corresponding to an ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "BusLine returned successfully"),
            @ApiResponse(responseCode = "400", description = "BusLine details are invalid"),
            @ApiResponse(responseCode = "404", description = "Given busLineId does not exist"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @PutMapping("/{busLineId}")
    public BusLineDTO updateBusLine(@PathVariable("busLineId") long busLineId, @Valid @RequestBody BusLineDTO busLineDTO) {
        try {
            return this.busLineService.updateBusLine(busLineId, busLineDTO);
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (ConstraintViolationException constraintViolationException) {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Operation(summary = "Deletes certain busLine.", description = "This operation " +
            "deletes data of a certain busLine corresponding to an ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "BusLine successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Given busLineId does not exist"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @DeleteMapping("/{busLineId}")
    public void removeBusLineById(@PathVariable("busLineId") long busLineId) {
        try {
            this.busLineService.removeBusLineById(busLineId);
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

