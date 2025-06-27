# API-de-Autenticacao-e-Autorizacao-JWT-

# 🔐 API JWT com Spring Boot

API RESTful de autenticação e autorização utilizando **Spring Boot**, **JWT**, **H2 Database**, **Swagger**, **Spring Security**, **JUnit** e monitoramento com **Spring Actuator + Prometheus**.

---

## ✅ Funcionalidades

- Registro e login de usuários com senha criptografada (BCrypt)
- Emissão de token JWT após login
- Validação automática do token em endpoints protegidos
- Endpoints protegidos acessíveis apenas com autenticação
- Console H2 para visualização de dados
- Documentação interativa via Swagger
- Monitoramento via Actuator e Prometheus

---

## 🛠️ Tecnologias

- Java 17+
- Spring Boot 3.x
- Spring Security
- JWT (jjwt)
- Spring Data JPA + H2 Database
- Swagger (springdoc-openapi)
- Spring Boot Actuator
- Prometheus
- JUnit 5

---

## ▶️ Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd apijwt
```
2. Compile e rode o projeto

Se estiver usando Maven:
```
./mvnw spring-boot:run
```
Ou via sua IDE (IntelliJ, Eclipse, VS Code).

---

📄 Configurações (application.properties)
O projeto usa banco H2 em modo arquivo:

```
spring.datasource.url=jdbc:h2:file:./src/main/resources/db/bancoDeDados
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
jwt.secret=3xAmpl3S3gr3tK3yT0Us3F0rJwtT0k3n!
```

🔐 Endpoints principais

🔓 Acesso público
```
Método	Rota	Descrição
POST	/auth/register	Cria um novo usuário
POST	/auth/login	Retorna JWT
POST	/auth/validate?token=...	Valida JWT manualmente
```
🔒 Endpoints protegidos (necessário JWT)
```
Método	Rota	Descrição
GET	/protected	Retorna mensagem se token for válido
GET	/auth/users	Lista todos os usuários
DELETE	/auth/users/{username}	Remove um usuário
```

🧪 Testes
Execute os testes com:

```
./mvnw test
```

💻 Swagger (Documentação)
Disponível em:

```
http://localhost:8080/swagger-ui/index.html
```

🧰 H2 Console (Banco de Dados)
Acesse:
```
http://localhost:8080/h2-console
```
Use:

JDBC URL: jdbc:h2:file:./src/main/resources/db/bancoDeDados

Username: sa

Senha: (em branco)

📈 Monitoramento (Actuator + Prometheus)
Health check: http://localhost:8080/actuator/health

Métricas Prometheus: http://localhost:8080/actuator/prometheus

🧙‍♂️ Usuários criados automaticamente
Se o banco estiver vazio, os seguintes usuários são criados:

Usuário	Senha	Papel
admin	123	ROLE_ADMIN
user	123	ROLE_USER

📂 Estrutura do Projeto
```
src
└── main
    ├── java
    │   └── com
    │       └── api
    │           └── apiajwt
    │               ├── ApiajwtApplication.java         ← classe principal
    │
    │               ├── config                          ← configurações gerais
    │               │   ├── DataInitializer.java
    │               │   ├── JwtAuthenticationFilter.java
    │               │   ├── SecurityConfig.java
    │               │   └── SwaggerConfig.java
    │
    │               ├── controller                      ← controladores REST
    │               │   ├── AuthController.java
    │               │   └── TestProtectedController.java
    │
    │               ├── dto                             ← objetos de transferência
    │               │   └── LoginRequest.java
    │
    │               ├── exception                       ← exceções personalizadas (crie se necessário)
    │
    │               ├── model                           ← entidades JPA
    │               │   └── User.java
    │
    │               ├── repository                      ← interfaces JPA
    │               │   └── UserRepository.java
    │
    │               ├── security                        ← lógica de segurança (JWT, AuthEntryPoint, etc.)
    │               │   ├── AuthEntryPoint.java
    │               │   ├── JwtService.java
    │               │   └── UserDetailsServiceImpl.java
    │
    │               └── service                         ← regras de negócio
    │                   └── AuthService.java
    │
    ├── resources
    │   ├── application.properties
    │   ├── db/                                          ← arquivos do H2 se necessário
    │   ├── static/                                      ← arquivos estáticos (ex: imagens, JS, CSS)
    │   └── templates/                                   ← templates Thymeleaf, se usar
    │
    └── jmeter                                           ← pasta separada para testes JMeter
        └── View Results Tree.jmx
```
