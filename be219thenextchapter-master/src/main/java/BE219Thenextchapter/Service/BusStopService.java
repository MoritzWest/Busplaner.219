
package BE219Thenextchapter.Service;

import BE219Thenextchapter.dto.BusStopDTO;

import java.util.List;

public interface BusStopService {

    //Anlegen der CRUD-Methoden

    //Read
    List<BusStopDTO> getAll();
    BusStopDTO getBusStopById(long id);

    //Create
    BusStopDTO addBusStop(BusStopDTO busStopDTO);

    //Update
    BusStopDTO updateBusStop(long busStopId, BusStopDTO busStopDTO);

    //Delete
    void removeBusStopById(long id);

}
