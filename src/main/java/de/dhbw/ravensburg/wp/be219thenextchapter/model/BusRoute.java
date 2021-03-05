package de.dhbw.ravensburg.wp.be219thenextchapter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusStop;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BusRoute {

    // Liste Haltestellen, Liste Busse, Taktfrequenz, Fahrplan

    @Id
    @GeneratedValue
    private long busRouteId;
    private int busRouteNumber;
    private int frequency;
    private LocalTime startTimeAtFirstStop; //wann die Buslinie an der ersten Haltestelle losfährt an dem Tag
    private LocalTime endTimeAtFirstStop; //Zeitintervall in dem eine Buslinie die Haltestellen bedient

    @ManyToOne( cascade = CascadeType.ALL)
    private BusStop startBusStop;

    @ManyToOne( cascade = CascadeType.ALL)
    private BusStop endBusStop;


    //Jede Buslinie hat einen Busfahrplan
    @OneToMany(mappedBy = "busRoute", cascade = CascadeType.ALL) //haben hier bei movie das mappedBy stehen, d.h. in dem Fall ist der Soundtrack der Eigner, nicht der Movie
    private List<BusSchedule> busSchedules;

    //Konstruktor
    public BusRoute(int busRouteNumber, int frequency, LocalTime startTimeAtFirstStop, LocalTime endTimeAtFirstStop, BusStop startBusStop, BusStop endBusStop) {
        this.busRouteNumber = busRouteNumber;
        this.frequency = frequency;
        this.startTimeAtFirstStop = startTimeAtFirstStop;
        this.endTimeAtFirstStop = endTimeAtFirstStop;
        this.startBusStop = startBusStop;
        this.endBusStop = endBusStop;
    }
}
