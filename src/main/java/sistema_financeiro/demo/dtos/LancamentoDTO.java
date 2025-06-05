package sistema_financeiro.demo.dtos;

import sistema_financeiro.demo.enums.TipoLancamento;
import sistema_financeiro.demo.models.Categoria;
import sistema_financeiro.demo.models.Lancamento;
import sistema_financeiro.demo.models.Pessoa;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LancamentoDTO(
        Long id,
        String descricao,
        String observacao,
        BigDecimal valor,
        LocalDate dataVencimento,
        LocalDate dataPagamento,
        TipoLancamento tipo,
        Pessoa codigo_pessoa,
        Categoria codigo_categoria
) {
    // Construtor que converte entidade em DTO
    public LancamentoDTO(Lancamento lancamento) {
        this(
                lancamento.getId(),
                lancamento.getDescricao(),
                lancamento.getObservacao(),
                lancamento.getValor(),
                lancamento.getDataVencimento(),
                lancamento.getDataPagamento(),
                lancamento.getTipo(),
                lancamento.getPessoa(),
                lancamento.getCategoria()
        );
    }
}
