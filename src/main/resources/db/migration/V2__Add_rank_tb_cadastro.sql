-- V2: Migrations para adicionar a coluna de RANK na tabela de ninjas

ALTER TABLE tb_ninjas
ADD COLUMN skills VARCHAR(255);