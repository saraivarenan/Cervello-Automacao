#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Base de conhecimento
  Nesta feature iremos citar as funcionalidades da Base de conhecimento

Background:
Given eu devo está logado com usuario <user> senha <pass>
And Deve ser apresentado a página inicial


  @criarTopico
  Scenario: Criar topico
    When eu acessar  base de conhecimento deve ser apresentado o link para criação de tópico
    And clicar no link Registro de topicos  
    And preencher os campos Descricao <nomeTopico> Topico Pai <topicopai> e ordem <ordem>
		Then o sistema deve exibe o topico criado
 
  @EditarTopico
  Scenario Outline: Editar um tópico criado 
    Given que existe o topico <nomeTopico>
    When eu altero as informações do tópico 
    Then o sistema deve alterar as informações
    And deve apresentar o tópico alterado
    
    @CriarArtigo
  Scenario Outline: Criar um artigo  
  	When Eu acesso a base de conhecimento deve ser apresentado o link Novo Artigo
  	And eu clico no link Novo Artigo
  	And eu clico em salvar
  	Then Deve ser apresentado uma mensagem de campos obrigatórios
  	And preencho os campos Titulo <nomeArtigo> Descricao <descArtigo> palavra Chave <palChave> topico <nomeTopico>
  	And Clico em salvar
  	Then O sistema deve exibir uma mensagem informando que o artigo não foi preenchido
  	Then eu preencho o Artigo <conteudoArtigo> 
  	And clico em salvar
  	And após clico em Publicar
  	Then deve ser apresentado o artigo criado.
  	
 
  	
  	
  	
    Examples: 
      | user 		| pass 			| status  | nomeTopico				| 
      |cervello	|cervello01 | success |	Topico automatico	|
      | name2 	|     7 		| Fail    |
