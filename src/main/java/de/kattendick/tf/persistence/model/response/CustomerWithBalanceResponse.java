package de.kattendick.tf.persistence.model.response;

import lombok.Builder;

@Builder
public class CustomerWithBalanceResponse {

    private String name;

    private Integer aggregatedBalance;

}
