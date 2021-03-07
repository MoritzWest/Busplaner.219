package BE219Thenextchapter.Controller;

import BE219Thenextchapter.Service.BusService;
import BE219Thenextchapter.dto.BusDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = BusControllerImpl.class)
@Getter

public class BusControllerTest {

@Autowired
    BusController BusController;
@MockBean
    BusService BusService;
@Autowired
    MockMvc MockMvc;
@Autowired
    ObjectMapper ObjectMapper;
private final String ControllerPath = "/api/v1/busses";
private BusDTO Bus1;
private BusDTO Bus2;
List<BusDTO> BusDTOListe;
@BeforeEach
    public void setup(){
    this.Bus1 = new BusDTO(1L, Arrays.asList(1L));
    this.Bus2 = new BusDTO(2L, Arrays.asList(2L));
    this.BusDTOListe = Arrays.asList(Bus1, Bus2);
}
@Test
    public void shouldReturnAllBusses()throws Exception{
    when(BusService.getAll()).thenReturn(BusDTOListe);
  // MockMvc.perform(get(ControllerPath)
            MockMvc.perform(get(ControllerPath))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.*", hasSize(2)))
                    .andExpect(jsonPath("$[0].id", is(Bus1.getId().intValue())))
                    .andExpect(jsonPath("$[0].busPlanIds",is(Bus1.getBusPlanIds())))
                    .andDo(print());

    verify(BusService).getAll();
}

}

