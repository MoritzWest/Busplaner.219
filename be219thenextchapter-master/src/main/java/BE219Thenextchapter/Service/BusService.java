
package BE219Thenextchapter.Service;

import BE219Thenextchapter.dto.BusDTO;

import java.util.List;


public interface BusService {
    //Read
    List<BusDTO> getAll();

    BusDTO getBusById(long id);

    //Create
    BusDTO addBus(BusDTO busDTO) ;

    //Update
    BusDTO updateBus(BusDTO busDTO);

    //Delete
    void removeBusById(long id) ;
}

