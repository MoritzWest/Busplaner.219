
package BE219Thenextchapter.Service;

import BE219Thenextchapter.repository.BusRepository;
import BE219Thenextchapter.dto.BusDTO;
import BE219Thenextchapter.mapper.BusMapper;
import BE219Thenextchapter.model.Bus;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @Author Stefanie Grösch
 */
@Service
public class BusServiceImpl implements BusService{

    BusMapper busMapper;
    BusRepository busRepository;

    public BusServiceImpl(BusMapper busMapper, BusRepository busRepository) {
        this.busMapper = busMapper;
        this.busRepository = busRepository;
    }

    //Read all
    @Override
    public List<BusDTO> getAll() {
        List<Bus> busses = this.busRepository.findAll(); //liefert alle Buslinien aus der DB
        List<BusDTO> busDTOS = this.busMapper.busToBusDTOs(busses); // wandelt erste liste in eine liste von dtos um
        return busDTOS;
    }

    //Implementierung der CRUD-Methoden

    //Read by id
    @Override
    public BusDTO getBusById(long id) {
        Bus bus = this.busRepository.findById(id); //holt busRoute Objekt aus der DB anhand der ID
        BusDTO busDTO = this.busMapper.busToBusDTO(bus); // wandelt es in DTO um
        return busDTO;
    }

    //Create
    @Override
    public BusDTO addBus(BusDTO busDTO) {
        Bus bus = this.busMapper.busDTOToBus(busDTO); //umwandlung
        this.busRepository.save(bus); // das Repository kann nur ein konkretes Objekt abstpeichern, erst hierdurch bekommt das Objekt eine Id
        return this.busMapper.busToBusDTO(bus); //wollen DTO zurückgeben deshalb in DTO umwandeln
    }

    //Update
//    String customerTypName = customerDTO.getCustomerTypName();
//    CustomerTyp customerTyp = customerTypRepository.findByCustomerTypEquals(customerTypName);
//    Customer tmp = customerMapper.customerDTOtoCustomer(customerDTO);
//tmp.setCustomerTyp(customerTyp);
//tmp.setPowerMeters(getPowerMeterRepository().findByCustomerId(tmp.getId()));
//customerRepository.save(tmp);
//return customerMapper.customerToCustomerDTO(tmp);
    @Override
    public BusDTO updateBus(BusDTO busDTO) { //dieses DTO besitzt schon eine Id, daran erkennt das Repsitory dass es schon existert und geuptdated werdem muss
        Bus bus = this.busMapper.busDTOToBus(busDTO);
        this.busRepository.save(bus);
        return this.busMapper.busToBusDTO(bus); //wollen DTO zurückgeben deshalb in DTO umwandeln
    }

    //Delete
    @Override
    public void removeBusById(long id) {
        this.busRepository.deleteById(id);
    }
}

