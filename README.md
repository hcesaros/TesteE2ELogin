# 🧪 Projeto de Testes E2E - Site OrangeHRM

Este projeto realiza testes automatizados de ponta a ponta (E2E) no site do **OrangeHRM** utilizando as ferramentas:

- Java
- Selenium WebDriver
- Cucumber
- TestNG
- Maven

## 🌐 Site alvo

Utiliza o ambiente de demonstração oficial do OrangeHRM:  
🔗 [https://opensource-demo.orangehrmlive.com](https://opensource-demo.orangehrmlive.com)

## ✅ Funcionalidades Testadas

- Login com credenciais válidas
- Login com usuário ou senha inválidos
- Tentativa de login com campos vazios
- Navegação até o menu **PIM**
- Acesso ao formulário **Add Employee**

## 🧱 Estrutura do Projeto

src
├── test
│ ├── java
│ │ ├── pages (Page Objects)
│ │ ├── runner (RunnerTest)
│ │ ├── steps (Step Definitions)
│ │ └── support (Drive e utilitarios)
│ └── resources
│ └── features (Cenários .feature em Gherkin)


## ▶️ Como executar os testes

### Pré-requisitos

- Java 11+
- Maven 3.6+
- Chrome instalado
- ChromeDriver compatível com a versão do seu navegador

### Passos para executar

# 1. Clone o projeto
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio

# 2. Execute os testes
mvn test

Exemplo de comando para abrir relatório HTML

Após execução, abra o relatório gerado em:
target/relatorios-cucumber.html

### 🧪 Exemplo de cenário (Gherkin)

Cenário: Login com credenciais válidas
  Dado que o usuário está na página de login do OrangeHRM
  Quando ele faz login com o usuário "Admin" e a senha "admin123"
  Então ele deve visualizar o painel principal

### 📸 Page Objects utilizados

* LoginPage.java

* DashboardPage.java

* PIMPage.java

### 🛠️ Tecnologias e Bibliotecas

* Selenium 4

* Cucumber 7

* TestNG

* Maven

### 📂 Relatórios

* Geração de relatórios HTML padrão do Cucumber

* (Opcional) Pode ser integrado ao Allure Reports

