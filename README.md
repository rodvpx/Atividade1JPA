# 📚 Projeto de Gestão de Livros

Este projeto é uma aplicação Java que utiliza Hibernate para gerenciar o cadastro e as operações relacionadas a **livros**, **autores** e **editoras**. Ele oferece funcionalidades para salvar, buscar, excluir e realizar consultas por autor ou editora.

## 🚀 Funcionalidades

- **Gestão de Livros**: Permite o cadastro de livros com título, ano de publicação, ISBN, autor e editora.
- **Gestão de Autores**: Cadastro e gerenciamento de informações sobre autores, incluindo nome.
- **Gestão de Editoras**: Cadastro e gerenciamento de editoras, incluindo nome.
- **Consultas Avançadas**: Realiza buscas de livros filtrados por autor ou editora.
- **Persistência com Hibernate**: Utiliza o Hibernate para persistir dados no banco de dados.

## 🔧 Requisitos

- **Java 21** ou superior
- **Hibernate 6.x**
- **Banco de dados MySQL** ou qualquer banco relacional compatível com JDBC
- **UUID** como identificadores únicos para as entidades

## 🛠️ Tecnologias Utilizadas

- **Java 21**: Linguagem de programação para a implementação da aplicação.
- **Hibernate 6.x**: Framework ORM (Object-Relational Mapping) para persistência de dados.
- **MySQL**: Banco de dados relacional para armazenar informações.
- **UUID**: Identificadores únicos para garantir a unicidade das entidades.

## 📁 Estrutura do Projeto

- **`org.example.model`**: Contém as classes de modelo de dados (Livro, Autor, Editora).
- **`org.example.dao`**: Contém as classes DAO (Data Access Object) para operações de CRUD e consultas.
- **`org.example.util`**: Contém utilitários, como a configuração do Hibernate e outras funções auxiliares.
- **`Main.java`**: Classe principal para testes e demonstração da aplicação.

## 📜 Configuração do Hibernate (hibernate.cfg.xml)

O arquivo `hibernate.cfg.xml` é onde estão configuradas as informações de conexão com o banco de dados e outras opções do Hibernate. Veja um exemplo de como ele pode ser configurado:

```xml
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

    <session-factory>
        <!-- Configuração da Conexão com o Banco de Dados -->
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/seu_banco_de_dados</property>
        <property name="hibernate.connection.username">seu_usuario</property>
        <property name="hibernate.connection.password">seu_admin</property>

        <!-- Configurações do Hibernate -->
        <property name="hibernate.hbm2ddl.auto">update</property>
        <property name="hibernate.show_sql">true</property>
        <property name="hibernate.format_sql">true</property>

        <!-- Pool de Conexões com HikariCP -->
        <property name="hibernate.hikari.minimumIdle">5</property>
        <property name="hibernate.hikari.maximumPoolSize">20</property>
        <property name="hibernate.hikari.idleTimeout">30000</property>

        <!-- Configuração de Transações -->
        <property name="hibernate.transaction.coordinator_class">jdbc</property>

        <!-- Desativando o cache de segundo nível -->
        <property name="hibernate.cache.use_second_level_cache">false</property>

        <!-- Ajustes de timezone -->
        <property name="hibernate.jdbc.time_zone">UTC</property>

        <property name="hibernate.current_session_context_class">thread</property>

    </session-factory>

</hibernate-configuration>

```

### 🔄 Detalhes da Configuração:

- **Conexão com o banco**: As informações como `hibernate.connection.url`, `username` e `password` devem ser ajustadas para o seu banco de dados MySQL.
- **Configuração do Pool de Conexões**: Usamos o **HikariCP** para gerenciar conexões de forma eficiente.
- **Transações e Cache**: A configuração desativa o cache de segundo nível, para evitar conflitos e garantir um funcionamento mais simples durante o desenvolvimento.

## ⚙️ Dependências do `pom.xml`

O arquivo `pom.xml` contém as dependências necessárias para rodar o projeto. Aqui estão algumas das principais dependências que você precisa incluir no seu projeto:

```xml
<dependencies>
    <!-- Hibernate Core -->
    <dependency>
        <groupId>org.hibernate.orm</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>6.4.2.Final</version>
    </dependency>

    <!-- MySQL JDBC Driver -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.3.0</version>
    </dependency>

    <!-- Jakarta XML Binding (JAXB) API -->
    <dependency>
        <groupId>jakarta.xml.bind</groupId>
        <artifactId>jakarta.xml.bind-api</artifactId>
        <version>4.0.0</version>
    </dependency>

    <!-- Implementação do JAXB -->
    <dependency>
        <groupId>org.glassfish.jaxb</groupId>
        <artifactId>jaxb-runtime</artifactId>
        <version>4.0.4</version>
    </dependency>

    <!-- HikariCP (Pool de Conexões) -->
    <dependency>
        <groupId>com.zaxxer</groupId>
        <artifactId>HikariCP</artifactId>
        <version>5.1.0</version>
    </dependency>

    <!-- Logger SLF4J + Logback -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>2.0.12</version>
    </dependency>
</dependencies>
```

### 🔄 Detalhes das Dependências:

- **Hibernate**: A versão 6.4.2.Final do Hibernate é usada para persistência e mapeamento objeto-relacional.
- **MySQL JDBC Driver**: Essencial para a conexão com o banco de dados MySQL.
- **JAXB**: Necessário para o mapeamento XML (se aplicável).
- **HikariCP**: Usado para gerenciar o pool de conexões ao banco de dados.
- **SLF4J + Logback**: Usado para logging, ajudando na depuração e acompanhamento da execução.

## 📝 Instruções de Uso

1. **Configuração do Banco de Dados**:
    - Certifique-se de ter um banco de dados MySQL rodando e com a tabela `crud_library` configurada.
    - Ajuste o arquivo `hibernate.cfg.xml` conforme necessário (usuário, senha, URL de conexão).

2. **Configuração do Hibernate**:
    - Verifique se o arquivo `hibernate.cfg.xml` está corretamente configurado para a conexão com o banco.

3. **Execução**:
    - Compile e execute a classe `Main.java`.
    - A classe `Main` contém exemplos de operações CRUD e consultas, como salvar livros e buscar livros por autor ou editora.
```