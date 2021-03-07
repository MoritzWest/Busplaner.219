package BE219Thenextchapter.Controller;

import BE219Thenextchapter.Service.BusLineService;
import BE219Thenextchapter.dto.BusLineDTO;
import BE219Thenextchapter.mapper.BusLineMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class BusLineControllerTest {

    @MockBean
    BusLineService busLineService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    BusLineController busLineController;

    @Autowired
    BusLineMapper busLineMapper;

    BusLineDTO busLine1;
    BusLineDTO busLine2;
    List<BusLineDTO> allBusLines;

    @BeforeEach
    public void setUp() {
        busLine1 = new BusLineDTO();
        busLine2 = new BusLineDTO();
        allBusLines.addAll(Arrays.asList(busLine1, busLine2));
    }




}

