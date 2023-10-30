create table produtos
(
    id             serial primary key,
    nome           varchar not null,
    preco          numeric(19, 2) not null,
    categoria      varchar not null,
    descricao      varchar not null,
    imagem         varchar not null,
    deleted        boolean default false,
    created_at     timestamp default now(),
    updated_at     timestamp,
    deleted_at     timestamp
);