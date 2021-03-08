package BE219Thenextchapter.Controller;

import BE219Thenextchapter.Service.BusPlanService;
import BE219Thenextchapter.dto.BusDTO;
import BE219Thenextchapter.dto.BusLineDTO;
import BE219Thenextchapter.dto.BusPlanDTO;
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
    @GetMapping
    public List<BusPlanDTO> getAllBusPlans(){
        return this.busPlanService.getAll();
    }

    @Override
    @GetMapping("/{busPlanIds}")
    public BusPlanDTO getBusLineById(@PathVariable("busPlanIds") long busPlanIds) {
        return this.busPlanService.getBusPlanById(busPlanIds);
    }

    //Create
    @Override
    @PostMapping
    public BusPlanDTO addBusLine(@Valid @RequestBody BusPlanDTO busPlanDTO) {
        return this.busPlanService.addBusPlan(busPlanDTO);
    }

    //Update
    @Override
    @PutMapping("/{busPlanIds}")
    public BusPlanDTO updateBusLine(@Valid @RequestBody BusPlanDTO BusPlanDTO) {
        return this.busPlanService.updateBusPlan(BusPlanDTO);
    }

    //Delete
    @Override
    @DeleteMapping("/{busPlanIds}")
    public void removeBusLineById(@PathVariable("busPlanIds") long busPlanIds) {
        this.busPlanService.removeBusPlanById(busPlanIds);
    }
}

