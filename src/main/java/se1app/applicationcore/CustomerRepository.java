package se1app.applicationcore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // Spring leitet die Query aus der Signatur ab ("name" ist ein Attribut von Customer)
    Optional<Customer> findByName(String name);
}