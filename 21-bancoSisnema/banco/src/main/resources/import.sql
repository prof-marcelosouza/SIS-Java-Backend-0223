INSERT INTO tb_funcao (autoridade) VALUES ('ROLE_ADMIN');
INSERT INTO tb_funcao (autoridade) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_funcao (autoridade) VALUES ('ROLE_STUDENT');
INSERT INTO tb_funcao (autoridade) VALUES ('ROLE_PILOT');

-- 123456
INSERT INTO tb_usuario (nome, sobrenome, email, senha) VALUES ('Ayrton', 'Senna', 'senna@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_usuario (nome, sobrenome, email, senha) VALUES ('Alain', 'Prost', 'prost@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_usuario (nome, sobrenome, email, senha) VALUES ('Rubens', 'Barrichello', 'rb@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_usuario_funcao (usuario_id, funcao_id) VALUES (1L, 1L);
INSERT INTO tb_usuario_funcao (usuario_id, funcao_id) VALUES (1L, 2L);
INSERT INTO tb_usuario_funcao (usuario_id, funcao_id) VALUES (1L, 3L);
INSERT INTO tb_usuario_funcao (usuario_id, funcao_id) VALUES (2L, 2L);
INSERT INTO tb_usuario_funcao (usuario_id, funcao_id) VALUES (2L, 3L);
INSERT INTO tb_usuario_funcao (usuario_id, funcao_id) VALUES (3L, 2L);

INSERT INTO tb_cliente (nome, sobrenome, data_nasc, email, telefone) VALUES ('Charles', 'Darwin', '1895-10-02', 'darwin@gmail.com', '51 99855-5214');
INSERT INTO tb_cliente (nome, sobrenome, data_nasc, email, telefone) VALUES ('Jean', 'Piaget', '1892-11-22', 'piaget@gmail.com', '51 96212-5567');
INSERT INTO tb_cliente (nome, sobrenome, data_nasc, email, telefone) VALUES ('Sigmund', 'Freud', '1897-05-04', 'freud@gmail.com', '51 98466-8874');
INSERT INTO tb_cliente (nome, sobrenome, data_nasc, email, telefone) VALUES ('Michel', 'Foucault', '1894-08-07', 'foucault@gmail.com', '51 99952-6500');

INSERT INTO tb_endereco (logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES ('Rua Santana', '254', '402', 'Santana', '90652-654', 'Porto Alegre', 'RS');
INSERT INTO tb_endereco (logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES ('Av. Bento Gonçalves', '1002', 'N/A', 'Santana', '90741-524', 'Porto Alegre', 'RS');
INSERT INTO tb_endereco (logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES ('Av. Brasil', '369', '410', 'Centro', '95002-458', 'Caxias do Sul', 'RS');
INSERT INTO tb_endereco (logradouro, numero, complemento, bairro, cep, cidade, estado) VALUES ('Av. Paraguassú', '254', '111', 'Centro', '90250-412', 'Capão da Canoa', 'RS');

INSERT INTO tb_cliente_endereco (cliente_id, endereco_id) VALUES (1, 2);
INSERT INTO tb_cliente_endereco (cliente_id, endereco_id) VALUES (2, 1);
INSERT INTO tb_cliente_endereco (cliente_id, endereco_id) VALUES (3, 3);

INSERT INTO tb_tipo_conta (tipo) VALUES ('Corrente');
INSERT INTO tb_tipo_conta (tipo) VALUES ('Poupança');
INSERT INTO tb_tipo_conta (tipo) VALUES ('Salário');
INSERT INTO tb_tipo_conta (tipo) VALUES ('Digital');

INSERT INTO tb_conta (banco, agencia, numero, limite, saldo, tipo_conta_id, cliente_id) VALUES (1, '255', '23541-6', 0.0, 650.25, 3, 3);
INSERT INTO tb_conta (banco, agencia, numero, limite, saldo, tipo_conta_id, cliente_id) VALUES (104, '210', '24551-5', 200.0, 3365.14, 1, 2);
INSERT INTO tb_conta (banco, agencia, numero, limite, saldo, tipo_conta_id, cliente_id) VALUES (1, '552', '65431-2', 5000.0, 4.1, 1, 1);
INSERT INTO tb_conta (banco, agencia, numero, limite, saldo, tipo_conta_id, cliente_id) VALUES (77, '1', '25434-1', 750.0, 369.87, 1, 2);
INSERT INTO tb_conta (banco, agencia, numero, limite, saldo, tipo_conta_id, cliente_id) VALUES (260, '1', '23441-2', 350.0, 14.785, 1, 1);