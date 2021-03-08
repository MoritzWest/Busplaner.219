package BE219Thenextchapter.Service;

import BE219Thenextchapter.dto.BusLineDTO;
import BE219Thenextchapter.model.BusLine;

import java.util.List;

public interface BusLineService {

    //Read
    List<BusLineDTO> getAll();
    BusLineDTO getBusLineById(long id);

    //Create
    BusLineDTO addBusLine(BusLineDTO busLineDTO) ;

    //Update
    BusLineDTO updateBusLine(long busLineId, BusLineDTO busLineDTO);

    //Delete
    void removeBusLineById(long id) ;
}
