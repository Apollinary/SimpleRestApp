package org.example.dto.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddUserResponse {
    private long id;
    private String status;
    private String errorCode;
    private String errorText;
}
