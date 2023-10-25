package thelameres.bobday.client.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import thelameres.bobday.client.dto.requests.DepartmentRequest;
import thelameres.bobday.client.dto.responses.BobdayGetSimpleAnswerResponse;
import thelameres.bobday.client.dto.responses.BobdayPostSimpleAnswerResponse;

import java.util.Map;

@Slf4j
@Component
public class BobdayClientFallBackFactory implements FallbackFactory<BobdayClient> {
    @Override
    public BobdayClient create(Throwable cause) {
        return new BobdayClient() {
            @Override
            public BobdayGetSimpleAnswerResponse getEmployees() {
                log.error("Can't get employee", cause);
                return null;
            }

            @Override
            public BobdayPostSimpleAnswerResponse sendDepartments(Map<String, DepartmentRequest> mapOfdepartments) {
                log.error("Can't sendDepartments", cause);
                return null;
            }
        };
    }
}
