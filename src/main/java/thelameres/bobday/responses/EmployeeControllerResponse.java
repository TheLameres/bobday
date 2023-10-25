package thelameres.bobday.responses;

import thelameres.bobday.client.dto.requests.DepartmentRequest;

import java.util.Map;

public record EmployeeControllerResponse(Boolean success,
                                         Map<String, DepartmentRequest> request) {
}
