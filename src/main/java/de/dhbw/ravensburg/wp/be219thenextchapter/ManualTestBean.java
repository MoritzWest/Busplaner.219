package de.dhbw.ravensburg.wp.be219thenextchapter;

import de.dhbw.ravensburg.wp.be219thenextchapter.model.*;
import de.dhbw.ravensburg.wp.be219thenextchapter.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class ManualTestBean {

    private BusRouteRepository busRouteRepository;
    private BusRepository busRepository;
    private BusStopRepository busStopRepository;
    private BusScheduleRepository busScheduleRepository;
    private ArrivalTimeRepository arrivalTimeRepository;


    ManualTestBean(BusRouteRepository busRouteRepository, BusRepository busRepository, BusStopRepository busStopRepository, BusScheduleRepository busScheduleRepository, ArrivalTimeRepository arrivalTimeRepository ) {
        this.busRouteRepository = busRouteRepository;
        this.busRepository = busRepository;
        this.busStopRepository = busStopRepository;
        this.busScheduleRepository = busScheduleRepository;
        this.arrivalTimeRepository = arrivalTimeRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void callController() {

        //Bushaltestellen
        BusStop busStop_1 = new BusStop("Lichtenbergstraße");
        BusStop busStop_2 = new BusStop("Marienplatz");
        BusStop busStop_3 = new BusStop("Meersburgerbrücke");

        //Buslinien anlegen
        BusRoute busRoute_1 = new BusRoute(1, 15, LocalTime.of(7,00,00), LocalTime.of(21,00,00), busStop_1, busStop_3);
        BusRoute busRoute_2 = new BusRoute(2, 60, LocalTime.of(5,00,00), LocalTime.of(23,00,00), busStop_1, busStop_2);
        BusRoute busRoute_3 = new BusRoute(3, 45, LocalTime.of(9, 20, 00), LocalTime.of(22, 00,00), busStop_3, busStop_2);

        //Busse
        Bus bus_1 = new Bus();
        Bus bus_2 = new Bus();
        Bus bus_3 = new Bus();

        //Ankunftszeiten
        ArrivalTime arrivalTime_1 = new ArrivalTime(LocalTime.of(7,30, 00));
        arrivalTime_1.setBusStop(busStop_1);
        ArrivalTime arrivalTime_2 = new ArrivalTime(LocalTime.of(9,30, 00));
        ArrivalTime arrivalTime_3 = new ArrivalTime(LocalTime.of(10,20, 00));

        //Busfahrpläne
        BusSchedule busSchedule_1 = new BusSchedule(busRoute_1, bus_1, arrivalTime_1);
        BusSchedule busSchedule_2 = new BusSchedule(busRoute_1, bus_1, arrivalTime_2);
        BusSchedule busSchedule_3 = new BusSchedule(busRoute_1, bus_1, arrivalTime_3);

        //Zuweisung einer Buslinie zu den Fahrplaneinträgen
        busRoute_1.setBusSchedules(Arrays.asList(busSchedule_1,busSchedule_2));
        busRoute_2.setBusSchedules(Arrays.asList(busSchedule_2,busSchedule_3));
        busRoute_3.setBusSchedules(Arrays.asList(busSchedule_1,busSchedule_2, busSchedule_3));

        //Zuweisung der Busse zum Busfahrplan
        bus_1.setBusSchedules(Arrays.asList(busSchedule_1, busSchedule_2));
        bus_2.setBusSchedules(Arrays.asList(busSchedule_1, busSchedule_3));
        bus_3.setBusSchedules(Arrays.asList(busSchedule_2, busSchedule_3));

        //List<BusStop> stops = busStopRepository.saveAll(Arrays.asList(busStop_1, busStop_2,busStop_3));
        //busRoute_1.setInvolvedStops(Arrays.asList(busStop_1, busStop_2,busStop_3));
        /*busStop_1.getStoppingBusRoutes().add(busRoute_1);
        busStop_2.getStoppingBusRoutes().add(busRoute_1);
        busStop_3.getStoppingBusRoutes().add(busRoute_1);*/


        //Abspeichern aller Daten in den Repositories
        //this.busStopRepository.saveAll(Arrays.asList(busStop_1, busStop_2, busStop_3));
        this.busRouteRepository.saveAll(Arrays.asList(busRoute_1, busRoute_2, busRoute_3));
      //  this.arrivalTimeRepository.saveAll(Arrays.asList(arrivalTime_1, arrivalTime_2, arrivalTime_3));
        //this.busScheduleRepository.saveAll(Arrays.asList(busSchedule_1, busSchedule_2, busSchedule_3));
       // this.busRepository.saveAll(Arrays.asList(bus_1, bus_2, bus_3));



        //log.info(String.valueOf(busScheduleRepository.findAll()));

        List<BusStop> busStops = this.busStopRepository.findAllBusStopsByBusRouteId(busRoute_1.getBusRouteId());

        for (BusStop bs : busStops) {
            log.info(bs.getStreet());
        }

        List<Bus> busses = this.busRepository.findBussesByBusRoute(busRoute_1.getBusRouteId());

        for (Bus b : busses) {
            log.info(b.toString());
        }

        BusStop busStop = this.arrivalTimeRepository.findBusStopByArrivalTime(bus_1.getId());

        log.info(busStop.getStreet());

       //busRouteRepository.findBusStopsById(3).forEach(BusStop->log.info(BusStop.getName()));
    }
}
