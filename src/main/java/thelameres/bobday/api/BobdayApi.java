package thelameres.bobday.api;

import thelameres.bobday.client.dto.requests.DepartmentRequest;
import thelameres.bobday.client.dto.responses.BobdayGetSimpleAnswerResponse;
import thelameres.bobday.client.dto.responses.BobdayPostSimpleAnswerResponse;

import java.util.Map;

public interface BobdayApi {
    BobdayGetSimpleAnswerResponse getEmployees();

    BobdayPostSimpleAnswerResponse sendDepartments(Map<String, DepartmentRequest> mapOfdepartments);
}
