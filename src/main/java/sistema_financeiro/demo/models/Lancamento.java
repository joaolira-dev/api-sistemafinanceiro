package sistema_financeiro.demo.models;

import sistema_financeiro.demo.enums.TipoLancamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String descricao;

    @NotNull
    private LocalDate dataVencimento;


    private LocalDate dataPagamento;

    @NotNull
    private BigDecimal valor;


    private String observacao;

    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo;


    // Muitos lancamentos para uma pessoa apenas
    @ManyToOne
    // Adiciona a coluna codigo_pessoa na tabela lancamentos como identificador para Pessoa
    @JoinColumn(name = "codigo_pessoa", nullable = false)
    private Pessoa pessoa;

    // Muitos lancamentos para uma Categoria apenas
    @ManyToOne
    // Adiciona a coluna codigo_categoria na tabela lancamentos como identificador para Categoria
    @JoinColumn(name = "codigo_categoria", nullable = false)
    private Categoria categoria;
}
