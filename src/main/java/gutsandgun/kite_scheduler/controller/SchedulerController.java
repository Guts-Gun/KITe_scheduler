package gutsandgun.kite_scheduler.controller;

import gutsandgun.kite_scheduler.dto.SendingScheduleDto;
import gutsandgun.kite_scheduler.service.SendingScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scheduler")
public class SchedulerController {
	private final SendingScheduleService sendingScheduleService;

	@PostMapping("/add")
	public String addSchedule(@RequestBody SendingScheduleDto sendingScheduleDto) {
		sendingScheduleService.addSchedule(sendingScheduleDto);
		return "";
	}

	@DeleteMapping("/remove")
	public String removeSchedule(@RequestBody SendingScheduleDto sendingScheduleDto) {
		sendingScheduleService.removeSchedule(sendingScheduleDto);
		return "";
	}

	@PostMapping("/update")
	public String updateSchedule(@RequestBody SendingScheduleDto sendingScheduleDto) {
		sendingScheduleService.updateSchedule(sendingScheduleDto);
		return "";
	}


}
