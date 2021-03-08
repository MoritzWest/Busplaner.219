package BE219Thenextchapter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;
/**
 * @Author Moritz Westhäußer
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BusLine {

    // Liste Haltestellen, Liste Busse, Taktfrequenz, Fahrplan

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long busLineId;
    private int busLineNumber;
    private int frequency;
    private LocalTime startTimeAtFirstStop; //wann die Buslinie an der ersten Haltestelle losfährt an dem Tag
    private LocalTime endTimeAtFirstStop; //Zeitintervall in dem eine Buslinie die Haltestellen bedient

    @ManyToOne( cascade = CascadeType.ALL)
    private BusStop startBusStop;

    @ManyToOne( cascade = CascadeType.ALL)
    private BusStop endBusStop;


    //Jede Buslinie hat einen Busfahrplan
    @OneToMany(mappedBy = "busLine", cascade = CascadeType.ALL) //haben hier bei movie das mappedBy stehen, d.h. in dem Fall ist der Soundtrack der Eigner, nicht der Movie
    private List<BusPlan> busPlans;

    //Konstruktor
    public BusLine(int busLineNumber, int frequency, LocalTime startTimeAtFirstStop, LocalTime endTimeAtFirstStop, BusStop startBusStop, BusStop endBusStop) {
        this.busLineNumber = busLineNumber;
        this.frequency = frequency;
        this.startTimeAtFirstStop = startTimeAtFirstStop;
        this.endTimeAtFirstStop = endTimeAtFirstStop;
        this.startBusStop = startBusStop;
        this.endBusStop = endBusStop;
    }
}
