package sistema_financeiro.demo.dtos;

import sistema_financeiro.demo.models.Endereco;
import sistema_financeiro.demo.models.Pessoa;

public record PessoaDTO(
        Integer codigo_pessoa,
        String nome,
        Boolean ativo,
        Endereco endereco
) {

    public PessoaDTO(Pessoa pessoa) {
        this(
                pessoa.getCodigo_pessoa(),
                pessoa.getNome(),
                pessoa.getAtivo(),
                pessoa.getEndereco()
        );
    }
}
