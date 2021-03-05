package de.dhbw.ravensburg.wp.be219thenextchapter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ArrivalTime {

    @Id
    @GeneratedValue
    private long id;
    private LocalTime arrivalTime;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private BusStop busStop;

    @OneToOne(mappedBy = "arrivalTimeEntry", cascade = CascadeType.ALL)
    private BusSchedule busSchedule;

    //Konstruktor
    public ArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
