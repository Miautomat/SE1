package se1app.applicationcore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Diese Klasse repräsentiert eine Entität
// Wichtig ist für Spring hier das @Entity-Schlüsselwort, damit dieses von JPA verwaltbar ist
@Entity
public class Customer {
    // Technische ID der Entität (Auto-generiert)
    // Wir würden besser zusätzlich noch eine fachliche ID definieren
    @Id
    @GeneratedValue
    private Integer id;

    private String name;


    public Customer() {}

    public Customer(String name)
    {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Customer){
            Customer toCompare = (Customer) o;
            return this.id.equals(toCompare.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s']",
                id, name);
    }
}