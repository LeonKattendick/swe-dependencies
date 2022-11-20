package de.kattendick.tf.persistence.model.response;

import lombok.Builder;

@Builder
public class CustomerResponse {

    private String name;

    private String email;

    private String status;

}
