package BE219Thenextchapter.Controller;

import BE219Thenextchapter.Service.BusPlanService;
import BE219Thenextchapter.dto.BusDTO;
import BE219Thenextchapter.dto.BusLineDTO;
import BE219Thenextchapter.dto.BusPlanDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/busPlan")
public class BusPlanControllerImpl implements BusPlanController{

    private BusPlanService busPlanService;

    public BusPlanControllerImpl(BusPlanService busPlanService) {
        this.busPlanService = busPlanService;
    }

    @Override
    @Operation(summary = "Returns all BusPlans.", description = "This operation " +
            "returns all BusPlans existing in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All BusPlans returned successfully"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @GetMapping
    public List<BusPlanDTO> getAllBusPlans(){
        return this.busPlanService.getAll();
    }

    @Override
    @Operation(summary = "Returns certain BusPlan.", description = "This operation " +
            "returns a BusPlan corresponding to an ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "BusPlan returned successfully"),
            @ApiResponse(responseCode = "404", description = "Given BusPlanId does not exist"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @GetMapping("/{busPlanIds}")
    public BusPlanDTO getBusLineById(@PathVariable("busPlanIds") long busPlanIds) {
        return this.busPlanService.getBusPlanById(busPlanIds);
    }

    //Create
    @Override
    @Operation(summary = "Adds new busPlan.", description = "This operation " +
            "adds a new busPlan to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "busPlan returned successfully"),
            @ApiResponse(responseCode = "400", description = "busPlan details are invalid"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @PostMapping
    public BusPlanDTO addBusLine(@Valid @RequestBody BusPlanDTO busPlanDTO) {
        return this.busPlanService.addBusPlan(busPlanDTO);
    }

    //Update
    @Override
    @Operation(summary = "Updates certain busPlan.", description = "This operation " +
            "updates data of a certain busPlan corresponding to an ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "busPlan returned successfully"),
            @ApiResponse(responseCode = "400", description = "busPlan details are invalid"),
            @ApiResponse(responseCode = "404", description = "Given busPlanId does not exist"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @PutMapping("/{busPlanIds}")
    public BusPlanDTO updateBusLine(@Valid @RequestBody BusPlanDTO BusPlanDTO) {
        return this.busPlanService.updateBusPlan(BusPlanDTO);
    }

    //Delete
    @Override
    @Operation(summary = "deletes certain busPlan.", description = "This operation " +
            "deletes data of a certain busPlan corresponding to an ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "busPlan returned successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Given busPlanId does not exist"),
            @ApiResponse(responseCode = "500", description = "An error occurred during processing")
    })
    @DeleteMapping("/{busPlanIds}")
    public void removeBusLineById(@PathVariable("busPlanIds") long busPlanIds) {
        this.busPlanService.removeBusPlanById(busPlanIds);
    }
}

