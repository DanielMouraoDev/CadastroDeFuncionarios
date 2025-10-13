# CadastroDeFuncionarios
Bem-vindo ao Sistema de Cadastro de Funcionarios!
Este projeto é uma aplicação de arquitetura em camadas desenvolvida com Spring Boot, projetada para cadastrar funcionarios e suas respectivas missões. O projeto utiliza H2 como banco de dados em memória, Flyway para migrações de banco de dados e segue boas práticas de desenvolvimento de software como controle de versão com Git e hospedagem de repositório no GitHub. 

**Visão Geral do Projeto**

Este sistema foi desenvolvido para gerenciar funcionarios e suas missões. Cada  funcionario pode ser atribuído um unico cargo, enquanto um cargo pode ser associada a vários funcionarios. As principais funcionalidades incluem:

Cadastro de funcionarios com nome, idade, email e senioridade.
Atribuição de um cargo para um funcionario.
Gerenciamento de cargos e dos funcionarios associados a elas.

**Tecnologias Utilizadas**

Spring Boot: Para criação da aplicação web e gerenciamento de dependências.
Banco de Dados H2: Banco de dados em memória para desenvolvimento e testes.
Flyway: Para gerenciamento de migrações do banco de dados.
JPA (Java Persistence API): Para mapeamento objeto-relacional (ORM).
Git: Controle de versão para gerenciamento de mudanças no código.
GitHub: Hospedagem do repositório para controle de versão.
Spring Data JPA: Para interação com o banco de dados.
Maven: Para build e gerenciamento de dependências do projeto.
Docker: Para build externo do banco de dados
SQL: Manipulação do banco de dados

**Design do Banco de Dados**

O esquema do banco de dados segue as seguintes relações:

Funcionario: Contém atributos como id, nome, idade, email e rank.
Cargo: Contém atributos como id, título e descrição.
Um funcionario pode ter apenas uma Cargo, mas um Cargo pode ser atribuída a vários Funcionarios.
