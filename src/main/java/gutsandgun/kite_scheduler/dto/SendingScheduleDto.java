package gutsandgun.kite_scheduler.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link gutsandgun.kite_scheduler.entity.write.SendingSchedule} entity
 *
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SendingScheduleDto implements Serializable {
	private Long sendingId;
	private Long time;
}