package sistema_financeiro.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.util.List;

@Data
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo_pessoa;

    @NotBlank
    private String nome;

    @NotNull
    private Boolean ativo;

    @Embedded
    private Endereco endereco;


    // mappedBy define que 'pessoa' em Lancamento é quem gerencia a relação no banco (chave estrangeira fica lá)
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.REMOVE, orphanRemoval = true)
    // Serve para ignorar o JSON de lancamentos na requisicao
    @JsonIgnore
    //Representa os lançamentos dessa pessoa na memória (serve para acessar os dados de lancamentos direto pelo código)
    private List<Lancamento> lancamentos;
}