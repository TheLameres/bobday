package thelameres.bobday.client.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record BobdayGetSimpleAnswerResponse(@JsonProperty("employees") List<EmployeeGetResponse> employees) {
}
