package springCloud.Controller.client;


import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Component;

@Component
public class CloudClientImpl implements CloudClient {
    @Override
    public Result print() {
    return new Result(false , StatusCode.ERROR , "熔断器启动了");

    }
}
