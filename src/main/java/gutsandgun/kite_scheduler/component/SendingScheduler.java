package gutsandgun.kite_scheduler.component;

import gutsandgun.kite_scheduler.dto.SendingScheduleDto;
import gutsandgun.kite_scheduler.entity.write.SendingSchedule;
import gutsandgun.kite_scheduler.openfeign.SendingManagerServiceClient;
import gutsandgun.kite_scheduler.repository.write.WriteSendingScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SendingScheduler {
	private final WriteSendingScheduleRepository writeSendingScheduleRepository;

	private final SendingManagerServiceClient sendingManagerServiceClient;

	@Scheduled(cron = "0/10 * * * * *")
	public void checkSchedule() {
		System.out.println("scheduler active time : " + Instant.now().toEpochMilli() + " " +new Date());
		SendingSchedule[] sendingScheduleList = writeSendingScheduleRepository.findAllByTimeBefore(Instant.now().toEpochMilli());
		System.out.println("스케줄 해야할거 : ");
		for (SendingSchedule sendingSchedule : sendingScheduleList) {
			System.out.println("schedule Id : " + sendingSchedule.toString());
		}
		for (SendingSchedule sendingSchedule : sendingScheduleList) {
			System.out.println("스케줄 처리중 : ");
			System.out.println("schedule Id : " + sendingSchedule.getId());
			this.runSchedule(sendingSchedule);
		}
//		finishSchedule(sendingScheduleList);
	}

	public void runSchedule(SendingSchedule sendingSchedule) {
		//여기 오류처리 생각해보기
		Map<String, Long> map = new HashMap<>();
		map.put("sendingId", sendingSchedule.getSendingId());
		System.out.println("발송 시작 처리중 : " + sendingSchedule.getSendingId());
		boolean success = false;
		try {
			sendingManagerServiceClient.startSending(map);
			success = true;

		} catch (Exception e) {
			System.out.println("발송 시작 error: " + sendingSchedule.getSendingId());
		}
		if (success) {
			finishSchedule(new SendingSchedule[]{sendingSchedule});
		}
	}

	public void finishSchedule(SendingSchedule[] sendingScheduleList) {
		writeSendingScheduleRepository.deleteAll(Arrays.asList(sendingScheduleList));
	}

	public void addSchedule(SendingScheduleDto sendingScheduleDto) {
		SendingSchedule sendingSchedule = new SendingSchedule(sendingScheduleDto);
		writeSendingScheduleRepository.save(sendingSchedule);
		System.out.println("schedule 추가 : " + sendingScheduleDto.getSendingId());
	}

	public void removeSchedule(SendingScheduleDto sendingScheduleDto) {
		writeSendingScheduleRepository.deleteBySendingId(sendingScheduleDto.getSendingId());
		System.out.println("schedule 삭제 : " + sendingScheduleDto.getSendingId());
	}

	public void updateSchedule(SendingScheduleDto sendingScheduleDto) {
		this.removeSchedule(sendingScheduleDto);
		this.addSchedule(sendingScheduleDto);
		System.out.println("schedule 수정 : " + sendingScheduleDto.getSendingId());
	}

}

