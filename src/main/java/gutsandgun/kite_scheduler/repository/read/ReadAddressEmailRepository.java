package gutsandgun.kite_scheduler.repository.read;

import gutsandgun.kite_scheduler.entity.read.AddressEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadAddressEmailRepository extends JpaRepository<AddressEmail, Long> {
}
