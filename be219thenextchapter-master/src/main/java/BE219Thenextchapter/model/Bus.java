package BE219Thenextchapter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Ein Bus kann mehrere Buslinien fahren und besitzt mehrere Fahrpläne
    @OneToMany(mappedBy = "bus", cascade = CascadeType.PERSIST)
    private List<BusPlan> busPlans;

}
