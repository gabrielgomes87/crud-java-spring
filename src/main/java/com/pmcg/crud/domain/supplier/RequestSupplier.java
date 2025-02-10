package com.pmcg.crud.domain.supplier;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestSupplier(

        String id_sup,

        @NotBlank
        String name,

        @NotNull
        String cnpj) {
}
