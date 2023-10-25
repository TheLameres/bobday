package thelameres.bobday.services.impls;

import org.springframework.stereotype.Service;
import thelameres.bobday.api.BobdayApi;
import thelameres.bobday.client.dto.requests.DepartmentRequest;
import thelameres.bobday.client.dto.responses.BobdayGetSimpleAnswerResponse;
import thelameres.bobday.client.dto.responses.BobdayPostSimpleAnswerResponse;
import thelameres.bobday.responses.EmployeeControllerResponse;
import thelameres.bobday.services.DepartmentsTurnerService;
import thelameres.bobday.services.EmployeeService;

import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final BobdayApi bobdayApi;
    private final DepartmentsTurnerService departmentsTurnerService;

    public EmployeeServiceImpl(BobdayApi bobdayApi,
                               DepartmentsTurnerService departmentsTurnerService) {
        this.bobdayApi = bobdayApi;
        this.departmentsTurnerService = departmentsTurnerService;
    }

    @Override
    public EmployeeControllerResponse getEmployees() {
        BobdayGetSimpleAnswerResponse response = bobdayApi.getEmployees();
        Map<String, DepartmentRequest> turn = departmentsTurnerService.turn(response.employees());
        BobdayPostSimpleAnswerResponse bobdayPostSimpleAnswerResponse = bobdayApi.sendDepartments(turn);
        return new EmployeeControllerResponse(bobdayPostSimpleAnswerResponse.success(), turn);
    }
}
