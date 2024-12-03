
# Chaos Trials - Backend

Bem-vindo ao repositório **Chaos Trials - Backend**, o coração que alimenta o emocionante RPG web! Este backend gerencia autenticação de usuários, desafios, progresso e muito mais. Ele é construído com tecnologias modernas para garantir que cada ação do jogador seja processada de forma rápida e segura.

## 🚀 Tecnologias Usadas  

- **Spring Boot**: Framework para desenvolvimento rápido de aplicações Java, agora com suporte ao **Spring Boot 3.4.0**, oferecendo uma solução escalável para criar APIs RESTful e serviços backend.  
- **Spring Security**: Implementação de autenticação e autorização com suporte a JWT (JSON Web Token) para segurança aprimorada, utilizando **spring-security-crypto** para criptografia avançada.  
- **PostgreSQL**: Banco de dados relacional robusto para armazenamento de informações, garantindo alta integridade e desempenho.  
- **JWT (JSON Web Token)**: Implementado com bibliotecas **jjwt** e **java-jwt** para gerenciamento seguro de autenticação e autorização de usuários.  
- **Spring Data JPA**: Simplifica a interação com o banco de dados, suportando operações eficientes e reutilizáveis no **PostgreSQL**.  
- **Spring Boot DevTools**: Ferramenta essencial para aumentar a produtividade no desenvolvimento com recarga automática.  
- **Argon2**: Algoritmo de hashing utilizado para criptografar senhas de maneira segura e resistente a ataques.  
- **Dotenv**: Gerenciamento de variáveis de ambiente com a biblioteca **dotenv-java** para maior flexibilidade e segurança na configuração de dados sensíveis.  
- **JUnit e Mockito**: Garantia de qualidade do código com testes unitários e de integração.  
- **Jakarta Servlet API**: Suporte ao desenvolvimento de aplicativos Java que utilizam servlets.  
- **Jackson**: Biblioteca para serialização e desserialização de objetos Java em formatos como JSON.   

## **🎮 Funcionalidades do Backend**  

O backend é responsável por uma série de funções essenciais para o jogo, como:  

### **Gerenciamento de Jogadores**  
- Registro de novos jogadores, incluindo validação de dados e criptografia de senhas.  
- Autenticação e login utilizando JWT para sessões seguras.  
- Recuperação e atualização de perfis de jogadores, incluindo estatísticas e configurações pessoais.  

### **Gerenciamento de Partidas**  
- Criação, listagem e acompanhamento de partidas em andamento.  
- Matchmaking, conectando jogadores com habilidades similares.  
- Salvamento de resultados e estatísticas das partidas.  

### **Gestão de Recursos do Jogo**  
- Controle e armazenamento de itens, habilidades e níveis dos jogadores.  
- Criação e aplicação de regras de gameplay no backend.  

### **Comunicação em Tempo Real**  
- Integração com WebSockets ou outros protocolos para enviar atualizações em tempo real.  
- Suporte a chats dentro do jogo, para comunicação entre jogadores.  

### **Lógica de Negócios**  
- Implementação de regras específicas do jogo, como sistema de pontuação e penalidades.  
- Configuração de eventos ou missões com tempo limitado.  

### **Segurança**  
- Proteção contra acessos não autorizados usando Spring Security.  
- Monitoramento de atividades suspeitas e prevenção contra trapaças (anti-cheat).  

### **Gerenciamento de Logs e Estatísticas**  
- Registro de logs detalhados para auditoria e depuração.  
- Geração de relatórios sobre o desempenho do jogo e engajamento dos jogadores.  

### **Administração**  
- Painel de administração para gerenciar jogadores, partidas, e configurações do jogo.  
- Ferramentas para monitorar e ajustar balanceamento de gameplay.  

Essas funcionalidades garantem uma experiência de jogo fluida, segura e escalável para os usuários, enquanto oferecem flexibilidade para ajustes e melhorias contínuas.

## 🏁 Como Rodar o Backend

### 1. Clonar o Repositório

Clone o repositório para a sua máquina local:

```bash
git clone https://github.com/username/chaos-trials-backend.git
cd chaos-trials-backend
```

### 2. Configurar o `.env`

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
PORT=8080                           # Porta onde o servidor irá rodar. Padrão: 8080
```

### 3. Rodar o Servidor

Para iniciar o servidor em modo de desenvolvimento, use o comando:

```bash
mvn spring-boot:run
```

Ou utilize alguma idea que possua o mvn para rodar, exemplo: Intellij

O servidor estará disponível em `http://localhost:8080` ou na porta escolhida.

## 🔧 Estrutura de Diretórios

A estrutura do projeto foi organizada para facilitar a manutenção e escalabilidade do backend:

```
chaos-trials-backend/
├── src/
│   ├── application/ 
│   │   ├── dto/                        # Objetos de transferência de dados
│   │   ├── form/                       # Estruturas de formulário para entrada de dados
│   │   └── usecase/                    # Lógica de casos de uso da aplicação
│   ├── domain/    
│   │   ├── model/                      # Modelos da aplicação
│   │   └── repository/                 # Repositórios para acesso a dados
│   ├── infrastructure/config/          # Configurações do projeto (banco de dados, autenticação, etc.)
│   ├── util/                           # Funções auxiliares (helpers, validações comuns)
│   └── web/controller/                 # Controladores (endpoints da API)
├── .env                                # Variáveis de ambiente
├── pom.xml                             # Configuração do Maven e dependências do projeto
└── README.md                           # Documentação do projeto
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
