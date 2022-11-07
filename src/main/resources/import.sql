insert into marca (nome) values
    ('LG'), ('Samsung'), ('Apple');

insert into categoria (titulo, descricao) values
            ('Eletrônicos', 'Eletrônicos nacionais'),
            ('Smartphones', 'Smartphones e tablets'),
            ('Roupas', 'Roupas masculinas e femininas'),
            ('Brinquedos', 'Brinquedos nacionais'),
            ('Alimentos', 'Alimentos não parecíveis');

insert into produto (descricao, preco, categoria_id)  values
            ('TV', 2000, 1),
            ('iPhone', 4000, 2);

insert into cliente (nome, email, cpf, cidade, sexo)  values
            ('Manoel', 'manoel@email.com', '11111111111', 'Palmas', 'M'),
            ('Breno', 'breno@email.com', '22222222222', 'Palmas', 'M'),
            ('Alberto', 'alberto@email.com', '33333333333', 'Porto', 'M'),
            ('Raysa', 'raysa@email.com',   '44444444444', 'Palmas', 'F'),
            ('Joana', 'joana@email.com',   '55555555555', 'Palmas', 'F'),
            ('Fernando', 'fernando@email.com',   '66666666666', 'Palmas', 'M');
