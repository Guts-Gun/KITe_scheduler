package gutsandgun.kite_scheduler.controller;

import gutsandgun.kite_scheduler.exception.CustomException;
import gutsandgun.kite_scheduler.exception.ErrorCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduler")
public class TestController {
	@GetMapping("/test")
	public String test() {
		return ("리턴되면 유효함");
	}

	@GetMapping("/error")
	public String makeError() {
		if (Math.random() * 100 > 50)
			throw new CustomException(ErrorCode.BAD_REQUEST);
		return ("50% 확률로 에러 발생");
	}


}
