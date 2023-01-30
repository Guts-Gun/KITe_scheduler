package gutsandgun.kite_scheduler.service;

import gutsandgun.kite_scheduler.component.SendingScheduler;
import gutsandgun.kite_scheduler.dto.SendingScheduleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendingScheduleService {
	private final SendingScheduler sendingScheduler;

	public void addSchedule(SendingScheduleDto sendingScheduleDto) {
		sendingScheduler.addSchedule(sendingScheduleDto);
	}

	public void removeSchedule(SendingScheduleDto sendingScheduleDto) {
		sendingScheduler.removeSchedule(sendingScheduleDto);
	}


	public void updateSchedule(SendingScheduleDto sendingScheduleDto) {
		sendingScheduler.updateSchedule(sendingScheduleDto);
	}

}
