package thelameres.bobday.client.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DepartmentGetResponse(@JsonProperty("id") Integer id,
                                    @JsonProperty("department_name") String departmentName) {
}
