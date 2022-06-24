# FindFakeProject

Projeto da disciplina de Linguagem de Programação II

# Requisitos

- **JavaSDK** versão [18.0.1.1](https://www.oracle.com/java/technologies/downloads/)
  
- **JavaFx SDK** versão [18.0.1](https://gluonhq.com/products/javafx/)
  
- [**Maven**](https://maven.apache.org/download.cgi)
  
- [**Eclipse IDE**](https://www.eclipse.org/downloads/)
  
  - Plugins: **E(fx)clipse** para javaFX e **Eclipse m2e** para o Maven
    

# Configuração do Eclipse

Para configurar o eclipse é preciso apenas a instalação dos Plugins listados nos Requisitos e configurar o caminho até a pasta lib dentro do JavaFX.

Para acessar essa configuração os passos dentro do Eclipse: `Windows -> Preferences -> JavaFX`

Logo essa tela, será possível ver o campo **JavaFX 11+ SDK** e nele será adicionado o caminho até a pasta lib dentro do SDK do JavaFX. Se você adicionar a pasta do JavaFX SDK dentro da pasta do Java (**Recomendado**) você terá o seguinte caminho:

`C:\Program Files\Java\javafx-sdk-18.0.1\lib`

# Importando o projeto

Clone o repositório na pasta que preferir.

Abra o eclipse e siga em : `File -> Import -> Maven -> Existing Maven Projects`e selecione a pasta `FindFakeNews`dentro do repositório.

# Executando o projeto

Para executar o projeto siga em: `Run -> Run as -> Maven Build`