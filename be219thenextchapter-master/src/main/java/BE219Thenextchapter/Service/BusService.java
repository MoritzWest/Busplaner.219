
package BE219Thenextchapter.Service;

import BE219Thenextchapter.dto.BusDTO;

import java.util.List;
/**
 * @Author Stefanie Grösch
 */

public interface BusService {
    //Read
    List<BusDTO> getAll();

    BusDTO getBusById(long id);

    //Create
    BusDTO addBus(BusDTO busDTO) ; //bekommt DTO wird mit Mapper in Objekt umgew. und gespeichert

    //Update
    BusDTO updateBus(BusDTO busDTO);

    //Delete
    void removeBusById(long id) ;
}

