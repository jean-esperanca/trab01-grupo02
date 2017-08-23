-- EMPLOYEE PHOTOS
insert into file(id, content) values
(0,  FILE_READ('./src/main/resources/static/photos/face.jpg'));

--AUTHENTICATION
INSERT into user(id, username, password, name, email, experience, skill, active, picture_id) VALUES
(1, 'user', '$2a$10$Qji2/icFWIGGQEAv8bbwNuKGrSZyiUUPqE/0SNO2M.BpU.NA6xPhW', 'Master Yoda','yoda@stars.wars','Masters Unidentified Jedi, Garro, Qui-Gon Jinn', 'Deflect Force Lightning, Strategic Mastery, Acting Skills, Indomitable Will, Battle Meditation, Sensing Death And Force-aided Acrobatics.',  TRUE, 0);

--ROLES
insert into role(id, role) values
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN'),
(3, 'ROLE_MANAGER');

-- USER_ROLES
insert into user_roles (user_id, roles_id) values
(1, 1);

-- CLIENTS
insert into CLIENT (ID ,NAME, LAST_NAME ,EMAIL ,PHONE ,CPF ,STREET ,STREET_NUMBER ,COMPLEMENTS ,NEIGHBORHOOD ,CITY ,STATE ,ZIPCODE  ) values
(101, 'Joao', 'Silva', 'joao.silva@email.com.br', '51-98765-4321', '012.345.678-90', 'Rua A', 12, 'Casa', 'Centro', 'Santa Maria', 'RS', '92000-000'),
(102, 'Maria', 'Silva', 'maria.silva@email.com.br', '51-98765-4321', '102.345.678-90', 'Rua A', 12, 'Casa', 'Centro', 'Santa Maria', 'RS', '92000-000'),
(103, 'Pedro', 'Silva', 'pedro.silva@email.com.br', '51-98765-4321', '002.345.678-90', 'Rua A', 12, 'Casa', 'Centro', 'Santa Maria', 'RS', '92000-000');

-- PROVIDER
insert into PROVIDER (ID, CNPJ , EMAIL, NAME, PHONE) values 
(101, '03.364.322/0001-08', 'wayne.inc@email.com', 'Bruce Wayne', '51-98765-4321'),
(102, '22.686.317/0001-66', 'oliver.inc@email.com', 'Oliver Queen', '51-98765-4321');

-- CATEGORY
insert into CATEGORY (ID, NAME) values
(101,'Placa-mãe'),
(102,'Processador'),
(103,'Memória RAM'),
(104,'HD'),
(105,'Placa de Vídeo'),
(106,'Cabo');
