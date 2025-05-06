#language: pt

#Autor: Henrique Cesar
#Data: 06/05/2025

Funcionalidade: Login e navegação no OrangeHRM

  Contexto:
    Dado que o usuário está na página de login do OrangeHRM

  Cenario: Login com credenciais válidas
    Quando ele faz login com usuário "Admin" e senha "admin123"
    Entao ele deve visualizar o Dashboard

  Cenario: Login com usuário inválido
    Quando ele faz login com usuário "invalido" e senha "admin123"
    Entao uma mensagem de erro de credenciais deve ser exibida

  Cenario: Login com senha inválida
    Quando ele faz login com usuário "Admin" e senha "errada"
    Entao uma mensagem de erro de credenciais deve ser exibida

  Cenario: Login com campos vazios
    Quando ele tenta fazer login sem preencher os campos
    Entao uma mensagem de erro de campos obrigatórios deve ser exibida

  Cenario: Navegar até Add Employee após login
    Quando ele faz login com usuário "Admin" e senha "admin123"
    E ele navega até o menu PIM e seleciona Add Employee
    Entao o formulário de cadastro de funcionário deve ser exibido