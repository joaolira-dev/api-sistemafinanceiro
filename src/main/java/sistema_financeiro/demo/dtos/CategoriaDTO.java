package sistema_financeiro.demo.dtos;

import sistema_financeiro.demo.models.Categoria;


public record CategoriaDTO(Integer codigo_categoria, String nome) {

    public CategoriaDTO(Categoria categoria) {
        this(categoria.getCodigo_categoria(), categoria.getNome());
    }
}

