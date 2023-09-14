
INSERT INTO Cliente VALUES
(1,"Mario","Rossi","mrossi","mario1234"),
(2,"Anna","Verdi","averdi","securepass"),
(3,"Luca","Bianchi","lbianchi","francy567"),
(4,"Francesca","Esposito","fesposito","francy567"),
(5,"Giuseppe","Moretti","gmoretti","giu123abc"),
(6,"Sofia","Romano","sromano","sofia789"),
(7,"Marco","Russo","marcorusso","marco2023"),
(8,"Elena","Costa","elena_costa","elena456");

INSERT INTO Ordine VALUES
(1,'2023-08-10',3),
(2,'2023-02-12',7),
(3,'2022-07-15',1),
(4,'2023-08-17',7),
(5,'2022-05-20',4),
(6,'2021-04-21',3),
(7,'2023-08-25',6);

INSERT INTO ritiroNegozio VALUES
(1, 'Negozio A', '2023-08-14', 1),
(2, 'Negozio B', '2023-02-18', 2),
(3, 'Negozio C', '2022-07-16', 3),
(4, 'Negozio A', '2023-08-21', 4),
(5, 'Negozio D', '2022-05-24', 5),
(6, 'Negozio B', '2021-04-23', 6),
(7, 'Negozio E', '2023-08-29', 7);


INSERT INTO MetodoPagamento VALUES
(1,"Contrassegno"),
(2,"Carta di Credito");

INSERT INTO Pagamento VALUES
(1,'2023-08-10',50,1,2),
(2,'2023-02-12',350,2,1),
(3,'2022-07-15',303,3,1),
(4,'2023-08-17',159,4,1),
(5,'2022-05-20',6,5,1),
(6,'2021-04-21',318,6,2),
(7,'2023-08-25',600,7,2);

INSERT INTO Categoria VALUES
(1,"Elettronica per la casa","Elettronica"),
(2,"Strumenti musicali e accessori","MusicaStrumenti"),
(3,"Prodotti alimentari locali","Alimentari"),
(4,"Cosmetici per la cura della pelle"," Cosmetici");

INSERT INTO Prodotto VALUES
(1,"Chitarra Acustica","Chitarra acustica di alta qualità con custodia",300,2.5,2),
(2,"Profumo Floreale","Profumo floreale con note di rose e gelsomini", 50,0.1 ,4),
(3,"Pasta Integrale","Pacchetto di pasta integrale biologica",3,0.5,3),
(4,"Stampante Multifunzione","Stampante multifunzione per casa e ufficio",159, 9.0,1);

INSERT INTO contiene VALUES
(1,2,1),
(2,1,1),
(2,2,1),
(3,1,1),
(3,3,1),
(4,4,1),
(5,3,2),
(6,4,2),
(7,1,2);

INSERT INTO  Magazzino VALUES
(1,"Magazzino Nord"),
(2,"Magazzino Sud");

INSERT INTO  Locazione VALUES
(1,1),
(1,2),(2,3),(2,4);

INSERT INTO  Telefono VALUES
('344435663',1),
('787876876',2),
('675777656',2),
('242342424',3),
('242424234',4),
('2344222355',5),
('34534242420',6),
('22424242423',7),
('23142424242',7),
('99829842425',8);