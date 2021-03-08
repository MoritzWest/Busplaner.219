
package BE219Thenextchapter.Controller;

import BE219Thenextchapter.dto.BusLineDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Moritz Westhäußer
 */
public interface BusLineController {

    //TODO
    @GetMapping
    List<BusLineDTO> getAllBusLines(); // gibt sämtliche Buslinien zurück

    @GetMapping("/{busLineId}")
    BusLineDTO getBusLineById(@PathVariable("busLineId") long busLineId); // gibt die Daten einer bestimmten Buslinie zurück

    @PostMapping
    BusLineDTO addBusLine(@RequestBody BusLineDTO busLineDTO); // fügt eine neu Buslinie hinzu

    @PutMapping("/{busLineId}")
    BusLineDTO updateBusLine(@PathVariable("busLineId") long busLineId, @RequestBody BusLineDTO busLineDTO); //überschreibt Werte einer vorhandenen Buslinie

    @DeleteMapping("/{busLineId}")
    void removeBusLineById(@PathVariable("busLineId") long busLineId); //Löscht eine Buslinie ohne etwas zurück zu geben.
}

