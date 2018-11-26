package springCloud.Controller.client;

import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Component
@FeignClient(value = "service-name" , fallback = CloudClientImpl.class)
public interface CloudClient {

    @RequestMapping(value = "/test/print" , method = RequestMethod.GET)
    public Result print();


}
