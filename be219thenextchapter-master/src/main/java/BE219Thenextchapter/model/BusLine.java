package BE219Thenextchapter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BusLine {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long busLineId;
    private int busLineNumber;
    private int frequency;
    private LocalTime startTimeAtFirstStop;
    private LocalTime endTimeAtFirstStop;

    @ManyToOne( cascade = CascadeType.ALL)
    private BusStop startBusStop;

    @ManyToOne( cascade = CascadeType.ALL)
    private BusStop endBusStop;


    //Jede Buslinie hat einen Busfahrplan
    @OneToMany(mappedBy = "busLine", cascade = CascadeType.ALL)
    private List<BusPlan> busPlans;


    public BusLine(int busLineNumber, int frequency, LocalTime startTimeAtFirstStop, LocalTime endTimeAtFirstStop, BusStop startBusStop, BusStop endBusStop) {
        this.busLineNumber = busLineNumber;
        this.frequency = frequency;
        this.startTimeAtFirstStop = startTimeAtFirstStop;
        this.endTimeAtFirstStop = endTimeAtFirstStop;
        this.startBusStop = startBusStop;
        this.endBusStop = endBusStop;
    }
}
