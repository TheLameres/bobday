package thelameres.bobday.client.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BobdayPostSimpleAnswerResponse(@JsonProperty("success") Boolean success) {
}
