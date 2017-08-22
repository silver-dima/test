package com.mabaya.test.web.rest.request;

import com.mabaya.test.domain.Category;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
public class CampaignRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private LocalDate startDate;

    @NotEmpty
    private Category category;

    @NotNull
    private BigDecimal bid;

}
