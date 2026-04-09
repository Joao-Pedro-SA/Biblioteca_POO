# 📚 Sistema de Biblioteca em Java (POO)


Projeto desenvolvido como atividade prática da faculdade com o objetivo de aplicar os conceitos de Programação Orientada a Objetos (POO) em Java.

# 👥 Integrantes


- João Pedro de Souza Araujo
- Kauã Thalles Silva de Jesus
- Gabriel Emídio Deolindo
- Guilherme Rodrigues


# 🎯 Objetivo


Simular o funcionamento básico de um sistema de biblioteca, permitindo o gerenciamento de livros, usuários e empréstimos, utilizando boas práticas de POO como:

- Encapsulamento
- Herança
- Composição
- Organização em classes



# ⚙️ Funcionalidades


O sistema permite:

- 📌 Cadastrar livros
- 👤 Cadastrar usuários
- 🔄 Realizar empréstimo de livros
- ✅ Realizar devolução de livros
- 📖 Listar livros disponíveis
- 📚 Listar livros emprestados


# 🧱 Estrutura do Projeto

O sistema foi desenvolvido utilizando uma estrutura orientada a objetos com as seguintes classes:

🔹 Classes principais
- Livro → Representa um livro da biblioteca
- Usuario → Classe base para usuários
- Aluno → Herda de Usuario (limite de 3 empréstimos)
- Professor → Herda de Usuario (limite de 5 empréstimos)
- Emprestimo → Representa a relação entre usuário e livro
- Biblioteca → Classe responsável pelo controle do sistema
- Main → Classe principal com execução do programa


# 🧬 Conceitos de POO aplicados

### 🔒 Encapsulamento
- Atributos privados
- Uso de getters e setters

### 🧬 Herança

- Usuario é a classe base
- Aluno e Professor possuem regras específicas de empréstimo

### 🔗 Composição
- Um Emprestimo possui:
    - 1 Livro
    - 1 Usuario
    - Data do empréstimo


  
# 🖥️ Interface (Terminal)

O sistema funciona via terminal utilizando Scanner, com o seguinte menu:

````
1 - Cadastrar livro
2 - Cadastrar usuário
3 - Emprestar livro
4 - Devolver livro
5 - Listar livros disponíveis
6 - Listar empréstimos
0 - Sair
````

# ⚠️ Regras de Negócio

- ❌ Não é permitido emprestar um livro já emprestado
- ❌ Usuários não podem ultrapassar o limite de empréstimos
  - Aluno → até 3 livros
  - Professor → até 5 livros
- ✅ Ao devolver um livro, ele volta a ficar disponível



# 🚀 Como executar o projeto

1. Clone o repositório:
````
https://github.com/Joao-Pedro-SA/Biblioteca_POO.git
````
2. Acesse a pasta do projeto:
````
cd Biblioteca_POO
````
3. Compile os arquivos:
````
javac Main.java
````
4. Execute o programa:
````
java Main
````

# 🛠️ Tecnologias utilizadas
- ☕ Java
- 📦 Programação Orientada a Objetos (POO)
- 💻 Execução via terminal


# 📌 Observações

Este projeto tem fins educacionais e foi desenvolvido para praticar conceitos fundamentais de Java e POO.