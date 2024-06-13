package br.com.verkom.marketwizard.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "compra")
@EntityListeners(AuditingEntityListener.class)
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    @NotNull(message = "O campo fornecedor não deve ser nulo.")
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    @NotNull(message = "O campo produto não deve ser nulo.")
    private Produto produto;

    @Column(name = "data_compra", nullable = false)
    @CreatedDate
    private LocalDate dataCompra;

    @Column(name = "quantidade", nullable = false)
    @Min(value = 1, message = "A quantidade deve ser maior que zero.")
    @NotNull(message = "O campo quantidade não deve ser nulo.")
    private Integer quantidade;

    @Column(name = "valor_unidade", nullable = false)
    @DecimalMin(value = "0.0", message = "O valor deve ser positivo.")
    @NotNull(message = "O campo valor unidade não deve ser nulo.")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal valorUnidade;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "chegou")
    private Boolean chegou = false;

}