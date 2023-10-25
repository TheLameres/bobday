package thelameres.bobday.client.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public record DepartmentRequest(@JsonProperty("department_name") String departmentName,
                                @JsonProperty("employees") Set<EmployeePostRequest> employees) {
}
