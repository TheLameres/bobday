package thelameres.bobday.services;

import thelameres.bobday.client.dto.requests.DepartmentRequest;
import thelameres.bobday.client.dto.responses.EmployeeGetResponse;

import java.util.List;
import java.util.Map;

public interface DepartmentsTurnerService {
    Map<String, DepartmentRequest> turn(List<EmployeeGetResponse> employees);
}
