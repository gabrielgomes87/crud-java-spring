package com.pmcg.crud.domain.supplier;
import jakarta.persistence.*;
import lombok.*;

@Table(name="supplier")
@Entity(name="supplier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id_sup")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id_sup;

    private String name;

    private String cnpj;

    public Supplier(RequestSupplier requestSupplier){
        this.name = requestSupplier.name();
        this.cnpj = requestSupplier.cnpj();
        this.id_sup = requestSupplier.id_sup();
    }

}
