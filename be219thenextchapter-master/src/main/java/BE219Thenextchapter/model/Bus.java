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
    @GeneratedValue
    private Long id;

    //Ein Bus kann mehrere Buslinien fahren / besitzt mehrere Fahrpläne
    @OneToMany(mappedBy = "bus", cascade = CascadeType.PERSIST) //->erstmal egal was man da reinschreibt, mind. persist damit wir die Objekte auch speichern können,geht auch all
    private List<BusPlan> busPlans; //das Attribut involvedcast ist das Gegenstück auf der Movieseite?

}
