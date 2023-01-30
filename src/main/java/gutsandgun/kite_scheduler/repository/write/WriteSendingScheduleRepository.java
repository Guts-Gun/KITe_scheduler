package gutsandgun.kite_scheduler.repository.write;

import gutsandgun.kite_scheduler.entity.write.SendingSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface WriteSendingScheduleRepository extends JpaRepository<SendingSchedule, Long> {
	@Transactional
	long deleteBySendingId(Long sendingId);
	SendingSchedule[] findAllByTimeBefore(Long utc);
}
