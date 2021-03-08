package BE219Thenextchapter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ArrivingTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalTime arrivingTime;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private BusStop busStop;

    @OneToOne(mappedBy = "arrivingTimeEntry", cascade = CascadeType.ALL)
    private BusPlan busPlan;


    public ArrivingTime(LocalTime arrivingTime) {
        this.arrivingTime = arrivingTime;
    }
}
