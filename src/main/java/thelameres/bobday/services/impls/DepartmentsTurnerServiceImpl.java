package thelameres.bobday.services.impls;

import org.springframework.stereotype.Service;
import thelameres.bobday.client.dto.requests.DepartmentRequest;
import thelameres.bobday.client.dto.requests.EmployeePostRequest;
import thelameres.bobday.client.dto.responses.DepartmentGetResponse;
import thelameres.bobday.client.dto.responses.EmployeeGetResponse;
import thelameres.bobday.services.DepartmentsTurnerService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentsTurnerServiceImpl implements DepartmentsTurnerService {
    @Override
    public Map<String, DepartmentRequest> turn(List<EmployeeGetResponse> employees) {
        Map<String, DepartmentRequest> mapOfDepartments = new HashMap<>();
        employees.forEach(employee -> {
            DepartmentGetResponse department = employee.department();
            String key = department.id().toString();
            EmployeePostRequest employeePostRequest = new EmployeePostRequest(employee.name(), employee.age());
            if (!mapOfDepartments.containsKey(key)) {
                HashSet<EmployeePostRequest> hashSet = new HashSet<>();
                hashSet.add(employeePostRequest);
                DepartmentRequest departmentRequest = new DepartmentRequest(department.departmentName(), hashSet);
                mapOfDepartments.put(key, departmentRequest);
            } else {
                DepartmentRequest departmentRequest = mapOfDepartments.get(key);
                departmentRequest.employees().add(employeePostRequest);
            }
        });
        return mapOfDepartments;
    }
}
