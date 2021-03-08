package BE219Thenextchapter.Service;

import BE219Thenextchapter.dto.BusDTO;
import BE219Thenextchapter.dto.BusPlanDTO;
import BE219Thenextchapter.mapper.BusMapper;
import BE219Thenextchapter.mapper.BusPlanMapper;
import BE219Thenextchapter.model.ArrivingTime;
import BE219Thenextchapter.model.Bus;
import BE219Thenextchapter.model.BusLine;
import BE219Thenextchapter.model.BusPlan;
import BE219Thenextchapter.repository.BusPlanRepository;
import BE219Thenextchapter.repository.BusRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BusControllerServiceTest {

    @Autowired
    BusMapper busMapper;

    @Autowired
    BusPlanMapper busPlanMapper;

    @Autowired
    BusService busService;

    @MockBean
    BusRepository busRepository;

    @MockBean
    BusPlanRepository busPlanRepository;

    private BusDTO busDTO1;
    private BusDTO busDTO2;
    private Bus bus1;
    private Bus bus2;
    private BusPlanDTO busPlanDTO;
    private BusPlan busPlan;
    private ArrivingTime arrivingTime;
    private List<BusDTO> busDTOList;


    @BeforeEach
    public void setUp(){
        arrivingTime = new ArrivingTime(LocalTime.now());
        busDTO1=new BusDTO(1L, Arrays.asList(1L));
        busDTO2=new BusDTO(2L,Arrays.asList(1L));
        bus1=busMapper.busDTOToBus(busDTO1);
        bus2=busMapper.busDTOToBus(busDTO2);
        busPlanDTO = new BusPlanDTO(1L,new BusLine(),bus1,arrivingTime);
        busPlan=busPlanMapper.busPlanDTOToBusPlan(busPlanDTO);
        busDTOList=Arrays.asList(busDTO1,busDTO2);
}
    @Test
    public void getAllTest(){
        when(busRepository.findAll()).thenReturn(Arrays.asList(bus1,bus2));

        List<BusDTO> result = busService.getAll();

        assertTrue(result.size()==2);
        assertTrue(result.get(0).getId()==busDTO1.getId());
        assertTrue(result.get(1).getId()==busDTO2.getId());
    }
    @Test
    public void getBusByIdTest(){
        when(busRepository.findById(anyLong())).thenReturn(bus1);

        BusDTO result = busService.getBusById(anyLong());

        assertTrue(result.getId()==bus1.getId());
    }
    @Test
    public void addBus(){
        when(busRepository.save(any(Bus.class))).thenReturn(bus1);

        BusDTO result = busService.addBus(busDTO1);

        assertTrue(result.getId()==bus1.getId());
    }
    //Update testen
    @Test
    public void updateBus(){

    }

}
