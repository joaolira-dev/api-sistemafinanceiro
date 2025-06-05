CREATE TABLE lancamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    data_vencimento DATE NOT NULL,
    data_pagamento DATE,
    valor DECIMAL(10,2) NOT NULL,
    observacao VARCHAR(255),
    tipo VARCHAR(20) NOT NULL,
    codigo_categoria INT,
    codigo_pessoa INT,
    FOREIGN KEY (codigo_categoria) REFERENCES Categoria(codigo_categoria),
    FOREIGN KEY (codigo_pessoa) REFERENCES Pessoa(codigo_pessoa)
);