create schema ecommerce;
use ecommerce;

create table Cliente
(
	idCliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome varchar(50) NOT NULL,
    cognome varchar(50) NOT NULL,
    username varchar(50) NOT NULL,
    password varchar(50) NOT NULL
);


create table Ordine
(
	idOrdine INT NOT NULL AUTO_INCREMENT,
    data DATE NOT NULL,
    idCliente INT NOT NULL,
    PRIMARY KEY(idOrdine),
    FOREIGN KEY(idCliente) REFERENCES Cliente(idCliente)
);

create table RitiroNegozio
(	
	idRitiro INT NOT NULL AUTO_INCREMENT,
    nomeNegozio VARCHAR(30) NOT NULL,
    dataRitiro DATE NOT NULL,
    idOrdine INT NOT NULL,
    PRIMARY KEY(idRitiro),
    FOREIGN KEY(idOrdine) REFERENCES Ordine(idOrdine)
);
    
create table MetodoPagamento
(
	idMetodoPagamento INT NOT NULL AUTO_INCREMENT,
    tipo VARCHAR(30) NOT NULL,
    PRIMARY KEY(idMetodoPagamento)
);

create table Pagamento
(
	idPagamento INT NOT NULL AUTO_INCREMENT,
    dataPagamento DATE NOT NULL,
    importo INT NOT NULL,
    idOrdine INT NOT NULL,
    idMetodoPagamento INT NOT NULL,
    PRIMARY KEY(idPagamento),
    FOREIGN KEY(idOrdine) REFERENCES Ordine(idOrdine),
    FOREIGN KEY(idMetodoPagamento) REFERENCES MetodoPagamento(idMetodoPagamento)
);

create table Telefono
(
	numero VARCHAR(20) NOT NULL,
    idCliente INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(numero),
    FOREIGN KEY(idCliente) REFERENCES Cliente(idCliente)
);
    

create table Categoria
(
	idCategoria INT NOT NULL AUTO_INCREMENT,
    descrizione VARCHAR(250) NOT NULL,
    nome VARCHAR(30) NOT NULL,
    PRIMARY KEY(idCategoria)
);

    
create table Prodotto
(
	idProdotto INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    descrizione VARCHAR(250) NOT NULL,
    prezzo INT NOT NULL,
    peso FLOAT NOT NULL,
    idCategoria INT NOT NULL,
    PRIMARY KEY(idProdotto),
    FOREIGN KEY(idCategoria) REFERENCES Categoria(idCategoria)
);

create table contiene
(
	idOrdine INT NOT NULL,
    idProdotto INT NOT NULL,
    quantità INT NOT NULL,
    PRIMARY KEY(idOrdine,idProdotto),
    FOREIGN KEY(idOrdine) REFERENCES Ordine(idOrdine),
	FOREIGN KEY(idProdotto) REFERENCES Prodotto(idProdotto)    
);

create table Magazzino
(
	idMagazzino INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    PRIMARY KEY(idMagazzino)
);

create table Locazione
(
	idMagazzino INT NOT NULL,
    idProdotto INT NOT NULL,
	PRIMARY KEY(idMagazzino,idProdotto),
    FOREIGN KEY(idMagazzino) REFERENCES Magazzino(idMagazzino),
	FOREIGN KEY(idProdotto) REFERENCES Prodotto(idProdotto) 
);
   
-- script per drop
-- drop schema StreamingPlatform;
   
