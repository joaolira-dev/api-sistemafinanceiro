CREATE TABLE pessoa (
    codigo_pessoa INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    ativo BOOLEAN,
    logradouro VARCHAR(255),
    numero VARCHAR(50),
    complemento VARCHAR(255),
    bairro VARCHAR(255),
    cep VARCHAR(20),
    cidade VARCHAR(255),
    estado VARCHAR(255)
);



