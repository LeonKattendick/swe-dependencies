package de.kattendick.dependencies.persistence.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {

    private String name;

    private String email;

    private String status;

}
