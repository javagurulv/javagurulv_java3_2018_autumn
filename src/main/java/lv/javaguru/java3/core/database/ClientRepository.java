package lv.javaguru.java3.core.database;

import lv.javaguru.java3.core.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
