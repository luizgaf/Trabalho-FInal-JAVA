CREATE DATABASE IF NOT EXISTS DefesaCivil;

USE DefesaCivil;

CREATE TABLE IF NOT EXISTS Endereco(
	idEndereco INT AUTO_INCREMENT,
    logradouro VARCHAR(100) NOT NULL,
    numero INT NOT NULL,
    cidade VARCHAR (50) NOT NULL,
    CEP INT(8) NOT NULL,
    Complemento VARCHAR(100),
    PRIMARY KEY (idEndereco)
);

CREATE TABLE IF NOT EXISTS TipoRisco(
	idRisco INT AUTO_INCREMENT,
    categoria VARCHAR(100) NOT NULL,
    PRIMARY KEY (idRisco)
);

INSERT INTO TipoRisco (categoria) VALUES
('Em risco'),
('Alto Risco'),
('Extremo Risco');

CREATE TABLE IF NOT EXISTS TipoEmergencia(
	idEmergencia INT AUTO_INCREMENT,
    categoria VARCHAR(100) NOT NULL,
    PRIMARY KEY (idEmergencia)
);
INSERT INTO TipoEmergencia (categoria) VALUES
('Inundação'),
('Vendaval'),
('Desmoronamentos'),
('Incendio'),
('Tsuname'),
('Tempestade');

CREATE TABLE IF NOT EXISTS CadastroFamilia(
    idFamilia INT AUTO_INCREMENT,
    descricao VARCHAR(100) NOT NULL,
    TipoRisco_id INT, 
    TipoEmergencia_id INT, 
    PRIMARY KEY (idFamilia),
    FOREIGN KEY (TipoRisco_id) REFERENCES TipoRisco (idRisco),
    FOREIGN KEY (TipoEmergencia_id) REFERENCES TipoEmergencia (idEmergencia)
);

CREATE TABLE IF NOT EXISTS Membro(
    CPF CHAR(11), 
    nome VARCHAR(100) NOT NULL,
    numTelefone VARCHAR(15) NOT NULL,  
    email VARCHAR(100) NOT NULL,
    telEmergencia VARCHAR(15) NOT NULL,
    Endereco_id INT,  
    CadastroFamilia_id INT, 
    PRIMARY KEY (CPF),
    FOREIGN KEY (Endereco_id) REFERENCES Endereco (idEndereco),
    FOREIGN KEY (CadastroFamilia_id) REFERENCES CadastroFamilia (idFamilia)
);


