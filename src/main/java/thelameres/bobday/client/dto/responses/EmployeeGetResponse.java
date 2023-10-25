package thelameres.bobday.client.dto.responses;


import com.fasterxml.jackson.annotation.JsonProperty;

public record EmployeeGetResponse(@JsonProperty("name") String name,
                                  @JsonProperty("age") Integer age,
                                  @JsonProperty("department") DepartmentGetResponse department) {
}
