# FindFakeProject

Projeto da disciplina de Linguagem de Programação II

# Requisitos

- [**Maven**](https://maven.apache.org/download.cgi)
  

# Como executar

Primeiramente, é necessário clonar o repósitório em sua máquina local. Use:

```
git clone https://github.com/AndreLiberato/FindFakeProject.git
```

Acesse a pasta do projeto:

```
cd FindFakeProject
```

Acesse a pasta do código fonte do projeto 
```
cd FindFakeNews
```

Compile e execute o projeto usando:

```
mvn javafx:run
```

# No Eclipse

Para executar o projeto usando o eclipse é necessário que você tenha instalado em sua máquina os sequintes requisitos:

- [**Maven**](https://maven.apache.org/download.cgi)
  
- [**Eclipse IDE**](https://www.eclipse.org/downloads/)
  

  - Plugins: **E(fx)clipse** para javaFX e **Eclipse m2e** para o Maven

## Importando o projeto

Abra o eclipse e siga em : `File -> Import -> Maven -> Existing Maven Projects`e selecione a pasta `FindFakeNews`dentro do repositório do projeto.

## Executando o projeto no eclipse

Para executar o projeto siga em: `Run -> Run as -> Maven Build...`

Na tela `Edit Configuration` no campo `Goals:` adicione o seguinte comando:

```
clean javafx:run
```

# Relatório do projeto

O relatório final do projeto pode ser acesso clicando [**aqui**](https://drive.google.com/file/d/1yzYCjH2uwvR5Z4YVVOe8Gsy6li1LTu2i/view?usp=sharing)