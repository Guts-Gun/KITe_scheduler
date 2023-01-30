package gutsandgun.kite_scheduler.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link gutsandgun.kite_scheduler.entity.write.SendingSchedule} entity
 *
 */

@Data
public class SendingScheduleDto implements Serializable {
	private final Long sendingId;
	private final Long time;
}