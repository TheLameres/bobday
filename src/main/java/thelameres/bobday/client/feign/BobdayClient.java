package thelameres.bobday.client.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import thelameres.bobday.api.BobdayApi;
import thelameres.bobday.client.dto.requests.DepartmentRequest;
import thelameres.bobday.client.dto.responses.BobdayGetSimpleAnswerResponse;
import thelameres.bobday.client.dto.responses.BobdayPostSimpleAnswerResponse;

import java.util.Map;

public interface BobdayClient extends BobdayApi {
    @Override
    @GetMapping("/simple-answer")
    BobdayGetSimpleAnswerResponse getEmployees();

    @Override
    @PostMapping("/simple-answer")
    BobdayPostSimpleAnswerResponse sendDepartments(@RequestBody Map<String, DepartmentRequest> mapOfdepartments);
}
