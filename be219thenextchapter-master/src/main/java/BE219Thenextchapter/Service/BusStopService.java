
package BE219Thenextchapter.Service;

import BE219Thenextchapter.dto.BusStopDTO;

import java.util.List;
/**
 * @Author Moritz Westhäußer
 */
public interface BusStopService {

    //Anlegen der CRUD-Methoden

    //Read
    List<BusStopDTO> getAll();
    BusStopDTO getBusStopById(long id);

    //Create
    BusStopDTO addBusStop(BusStopDTO busStopDTO); // bekommt ein BusStop DTO ohne Id und gibt ein BusStopDTO mit Id zurück

    //Update
    BusStopDTO updateBusStop(long busStopId, BusStopDTO busStopDTO); //eigentlich genauso wie Create, nur das schon eine Id da ist, über die das upzudatende Objekt ident. wird

    //Delete
    void removeBusStopById(long id);

}
