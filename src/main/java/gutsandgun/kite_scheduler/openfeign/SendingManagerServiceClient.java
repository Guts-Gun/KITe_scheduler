package gutsandgun.kite_scheduler.openfeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;


@FeignClient(name = "sending-manager-client", url="${feign.url.sending-manager}", configuration = FeignConfig.class)
public interface SendingManagerServiceClient {

    @PostMapping(value = "/sending/start")
    ResponseEntity<Long> startSending(@RequestBody Map<String,Long> map);

}
