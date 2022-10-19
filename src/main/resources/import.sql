insert into categoria (titulo, descricao) values
            ('Eletrônicos', 'Eletrônicos nacionais'),
            ('Smartphones', 'Smartphones e tablets'),
            ('Roupas', 'Roupas masculinas e femininas'),
            ('Brinquedos', 'Brinquedos nacionais'),
            ('Alimentos', 'Alimentos não parecíveis');

insert into produto (descricao, preco, categoria_id)  values
            ('TV', 2000, 1),
            ('iPhone', 4000, 2);

insert into cliente (nome, email, cpf)  values
            ('Manoel', 'manoel@email.com', '11111111111'),
            ('Joana', 'joana@email.com',   '22222222222');
