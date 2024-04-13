CREATE TABLE Audocao1 (
id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100),
    telefone VARCHAR(20),
    endereco VARCHAR(255),
    data_nascimento DATE,
    sexo ENUM('M', 'F', 'Outro')
);