package de.kattendick.tf.persistence.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerWithBalanceResponse {

    private String name;

    private Integer aggregatedBalance;

}
