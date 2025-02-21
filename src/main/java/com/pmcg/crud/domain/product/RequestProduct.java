package com.pmcg.crud.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProduct(

        String id,

        @NotNull
        String id_sup,

        @NotBlank
        String name,

        @NotNull
        Number price_in_cents) {
}
