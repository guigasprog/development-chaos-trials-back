Aqui está o **README.md** para o backend do jogo **Chaos Trials** sem o comando de commit:

````markdown
# Chaos Trials - Backend

Bem-vindo ao repositório **Chaos Trials - Backend**, o coração que alimenta o emocionante RPG web! Este backend gerencia autenticação de usuários, desafios, progresso e muito mais. Ele é construído com tecnologias modernas para garantir que cada ação do jogador seja processada de forma rápida e segura.

## 🚀 Tecnologias Usadas

- **Spring Boot**: Framework para desenvolvimento rápido de aplicações Java, oferecendo uma solução completa e escalável para criar APIs RESTful e serviços backend.
- **Spring Security**: Framework para segurança em aplicações Java, usado para implementar autenticação e autorização, incluindo suporte a JWT (JSON Web Token).
- **PostgreSQL**: Banco de dados relacional utilizado para armazenar dados dos jogadores e do jogo, com alta escalabilidade e integridade dos dados.
- **JWT (JSON Web Token)**: Utilizado para autenticação e autorização de usuários de maneira segura e prática. O Spring Security integra-se com JWT para validação de tokens.
- **Spring Data JPA**: Framework para facilitar o acesso ao banco de dados, com suporte a JPA (Java Persistence API) para interação com o PostgreSQL de maneira mais simples.
- **Spring Boot DevTools**: Ferramenta para aumentar a produtividade durante o desenvolvimento, com recarga automática e outras funcionalidades úteis.
- **BCrypt**: Algoritmo de criptografia utilizado para segurança das senhas dos jogadores, garantindo que as senhas sejam armazenadas de maneira segura e irrecuperável.
- **Dotenv**: Gerenciamento de variáveis de ambiente para configuração flexível e segura, ideal para armazenar dados sensíveis como chaves secretas e credenciais do banco de dados.
- **JUnit e Mockito**: Frameworks de testes utilizados para garantir a qualidade do código com testes unitários e mock de dependências durante o desenvolvimento.

## ⚙ Funcionalidades

O backend é responsável por uma série de funções essenciais para o jogo, como:

## 🏁 Como Rodar o Backend

### 1. Clonar o Repositório

Clone o repositório para a sua máquina local:

```bash
git clone https://github.com/username/chaos-trials-backend.git
cd chaos-trials-backend
```
````

### 2. Instalar Dependências

Instale todas as dependências necessárias com o seguinte comando:

```bash
npm install
```

### 3. Configurar o `.env`

Crie um arquivo `.env` na raiz do projeto e adicione as variáveis de ambiente necessárias:

```plaintext
# Banco de Dados
DB_HOST=localhost               # Endereço do servidor do banco de dados (pode ser localhost ou o IP do servidor)
DB_PORT=3306                    # Porta para conectar ao banco de dados (ex: 3306 para MySQL)
DB_NAME=chaos_trials_db         # Nome do banco de dados que será utilizado
DB_USERNAME=root                # Nome de usuário para autenticação no banco
DB_PASSWORD=your_db_password    # Senha do banco de dados
DB_DIALECT=mysql                # Dialeto do banco de dados (por exemplo, 'mysql', 'postgres', etc.)

# JWT (JSON Web Token)
JWT_SECRET_KEY=your_jwt_secret_key_here  # Chave secreta utilizada para assinar os tokens JWT.
                                        # Deve ser uma chave segura e única.
JWT_ISSUER=chaos_trials_app            # Nome da aplicação ou entidade que emite o token (geralmente o nome do projeto)
JWT_AUDIENCE=chaos_trials_users       # Nome da aplicação ou usuários que consomem o token

# Porta do Servidor
PORT=3000                           # Porta onde o servidor irá rodar. Padrão: 3000

# (Opcional) Variáveis adicionais para desenvolvimento:
# Caso esteja usando MongoDB, por exemplo:
# MONGO_URI=mongodb://localhost:27017/chaos_trials_db
```

### 4. Rodar o Servidor

Para iniciar o servidor em modo de desenvolvimento, use o comando:

```bash
npm run dev
```

O servidor estará disponível em `http://localhost:3000`.

## 🔧 Estrutura de Diretórios

A estrutura do projeto foi organizada para facilitar a manutenção e escalabilidade do backend:

```
chaos-trials-backend/
├── src/
│   ├── config/            # Arquivos de configuração do projeto (ex: banco de dados, autenticação)
│   ├── domain/            # Modelos de dados (ex: Mongoose models, entidades de negócios)
│   ├── entrypoint/        # Entradas da aplicação, como as rotas da API (controladores)
│   ├── usecase/           # Casos de uso (lógica de negócios)
│   ├── middleware/        # Middlewares (autenticação, validação, etc.)
│   └── utils/             # Funções auxiliares (ex: helpers, validações comuns)
├── .env                   # Variáveis de ambiente (configurações sensíveis)
├── package.json           # Dependências e scripts do projeto
└── README.md              # Este arquivo
```

## 🤝 Contribuindo

Contribuições são sempre bem-vindas! Para colaborar, siga as etapas abaixo:

1. Faça um fork do repositório.
2. Crie uma branch para a sua funcionalidade (`git checkout -b feature/nova-funcionalidade`).
3. Realize as alterações e faça o commit (`git commit -am 'Adiciona nova funcionalidade'`).
4. Envie as alterações para o repositório remoto (`git push origin feature/nova-funcionalidade`).
5. Abra um Pull Request detalhando as alterações.

## 📜 Licença

Este projeto é licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

### 💬 Fale Conosco

Se tiver dúvidas ou sugestões, sinta-se à vontade para abrir uma **issue** ou entrar em contato. Estamos sempre à disposição para melhorar a experiência de todos os jogadores de **Chaos Trials**!

---

**Chaos Trials** - Aventura, desafios e caos esperando por você! 🔥
