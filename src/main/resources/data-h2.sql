-- EMPLOYEE PHOTOS
insert into file(id, content) values
(0,  FILE_READ('./src/main/resources/static/photos/face.jpg'));

--AUTHENTICATION
INSERT into user(id, username, password, name, email, experience, skill, active, picture_id) VALUES
(100, 'user', '$2a$10$Qji2/icFWIGGQEAv8bbwNuKGrSZyiUUPqE/0SNO2M.BpU.NA6xPhW', 'Master Yoda','yoda@stars.wars','Masters Unidentified Jedi, Garro, Qui-Gon Jinn', 'Deflect Force Lightning, Strategic Mastery, Acting Skills, Indomitable Will, Battle Meditation, Sensing Death And Force-aided Acrobatics.',  TRUE, 0),
(200, 'admin','$2a$10$Qji2/icFWIGGQEAv8bbwNuKGrSZyiUUPqE/0SNO2M.BpU.NA6xPhW', 'Usuário Teste ','usuario@ifrs.canoas','Masters Unidentified Jedi, Garro, Qui-Gon Jinn', 'Deflect Force Lightning, Strategic Mastery, Acting Skills, Indomitable Will, Battle Meditation, Sensing Death And Force-aided Acrobatics.',  TRUE, 0);
--ROLES
insert into role(id, role) values
(100, 'ROLE_USER'),
(200, 'ROLE_ADMIN'),
(300, 'ROLE_MANAGER');

-- USER_ROLES
insert into user_roles (user_id, roles_id) values
(100, 100),
(200, 200);

-- CLIENTS
insert into CLIENT (ID ,NAME, LAST_NAME ,EMAIL ,PHONE ,CPF, STREET ,STREET_NUMBER ,COMPLEMENTS ,NEIGHBORHOOD ,CITY ,STATE ,ZIPCODE ) values
(101, 'Joao', 'Silva', 'joao.silva@email.com.br', '(51)98765-4321', '012.345.678-90', 'Rua A', 10, 'Casa', 'Igara', 'Canoas', 'RS', '92000-000'),
(102, 'Maria', 'Silva', 'maria.silva@email.com.br', '(51)98765-4321', '102.345.678-90', 'Rua A', 10, 'Casa', 'Igara', 'Canoas', 'RS', '92000-000'),
(103, 'Pedro', 'Silva', 'pedro.silva@email.com.br', '(51)98765-4321', '002.345.678-90', 'Rua A', 10, 'Casa', 'Igara', 'Canoas', 'RS', '92000-000');

-- ADRESS
insert into ADRESS (ID ,STREET ,STREET_NUMBER ,COMPLEMENTS ,NEIGHBORHOOD ,CITY ,STATE ,ZIPCODE  ) values
(100, 'Rua A', 10, 'Casa', 'Igara', 'Canoas', 'RS', '92000-000'),
(101, 'Rua A', 20, 'Casa', 'Igara', 'Canoas', 'RS', '92000-000'),
(102, 'Rua A', 30, 'Casa', 'Igara', 'Canoas', 'RS', '92000-000'),
(103, 'Rua A', 40, 'Casa', 'Igara', 'Canoas', 'RS', '92000-000');

-- ADRESS_CLIENTS
insert into ADRESS_CLIENTS (CLIENTS_ID ,ADRESS_ID ) values
(101,100),
(102,100),
(103,101);

-- PROVIDER
insert into PROVIDER (ID, CNPJ , EMAIL, NAME, PHONE) values 
(101, '03.364.322/0001-08', 'wayne.inc@email.com', 'Bruce Wayne', '(51)98765-4321'),
(102, '22.686.317/0001-66', 'oliver.inc@email.com', 'Oliver Queen', '(51)98765-4321');

-- CATEGORY
insert into CATEGORY (ID, NAME) values
(101,'Placa-mãe'),
(102,'Processador'),
(103,'Memória RAM'),
(104,'HD'),
(105,'Placa de Vídeo'),
(106,'Cabo');

-- PRODUCT
insert into PRODUCT (ID ,CATEGORY_ID ,DESCRIPTION ,NAME ,QUANTITY ,VALUE ,PROVIDER_ID) values
(100, 101, 'Qualquer Coisa', 'Computador', 5, 25, 101),
(200, 102, 'Outra Coisa', 'Notebook', 2, 2000, 102),
(300, 105, 'Teste', 'Monitor', 2, 200, 102);


--PURCHASE_STATUS
insert into PURCHASE_STATUS (ID ,DESCRIPTION)
 values
(1,'EM ABERTO'),
(2,'CONCLUIDO'),
(3,'CANCELADO');

--PURCHASE
insert into PURCHASE (ID ,PRICE,PURCHASE_DATE, CLIENT_ID, COMPLETION_DATE, PURCHASE_STATUS_ID)
 values
(100, 1.99    , PARSEDATETIME('28/02/17','dd/MM/yy') , 101, NULL, 1),
(200, 500.90  , PARSEDATETIME('01/04/17','dd/MM/yy') , 101, current_date(), 2),
(300, 1000.00 , current_date() , 103, NULL, 1);


insert into PURCHASE_PRODUCTS (PURCHASES_ID, PRODUCTS_ID)
VALUES
(100, 100),
(200, 300),
(200, 200),
(100, 300),
(300, 100),
(300, 200),
(300, 300);

