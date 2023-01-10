package gutsandgun.kite_scheduler.repository.write;

import gutsandgun.kite_scheduler.entity.write.SendingSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriteSendingScheduleRepository extends JpaRepository<SendingSchedule, Long> {
}
