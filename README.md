# Concessionária AP3

Programa feito com Java Swing para a avaliação de Estratégias de Programação Orientada a Objeto no primeiro semestre de 2020.

Feito para o gerenciamento de clientes e carros, permitindo adicionar, visualizar, editar e excluir os dados de cada um. Além disso, o programa possibilita realizar vendas e acompanhar o histórico de cada transação. O programa também conta com a opção de salvar e carregar as informações sobre carros, clientes e vendas em arquivos.

### Atalhos:
- `Ctrl + O` : Abrir arquivo salvo.
- `Ctrl + S` : Salvar informações em arquivo.
- `Ctrl + W` : Encerrar o programa.

Funciona em [Windows](#windows), [Linux](#linux-gnome) e [Mac](#mac-os).

## Feito com
* **IDE**: [Apache NetBeans 17](https://netbeans.apache.org/download/nb17/ "IDE para desenvolvimento de aplicações Java")
* **Editor**: [Visual Studio Code 1.77.1](https://code.visualstudio.com/download "Editor de código simplificado com suporte para operações de desenvolvimento como depuração, execução de tarefas e controle de versão")
* **Java**: [JDK 17 ou superior](https://www.oracle.com/java/technologies/downloads/#java17 "Java Development Kit 17 - Ambiente de desenvolvimento para construção de aplicativos e componentes usando o Java")
* **Gerenciador de Pacotes**: [Maven](https://maven.apache.org/download.cgi "Ferramenta de gerenciamento de projetos de software")
* **Visual**: [FlatLaf](https://github.com/JFormDesigner/FlatLaf "Aparência multiplataforma para aplicações Java Swing desktop")
* **Dados**: [Json](https://mvnrepository.com/artifact/org.json/json "JavaScript Object Notation")

## Como testar?
_Obs¹.: Precisa de [JDK 17](https://oracle.com/java/technologies/downloads/ "Java Development Kit 11") ou superior instalado._<br>
_Obs².: Será necessário [permitir a execução de software sem assinatura no MacOS](https://support.apple.com/guide/mac-help/open-a-mac-app-from-an-unidentified-developer-mh40616/mac)._
1. Baixe a `release` no GitHub
2. Execute (Double-click ou digite no terminal `java -jar Concessionaria-AP3-1.0.jar`)

## Como compilar?
1. Instale [JDK 17 ou superior](https://www.oracle.com/java/technologies/downloads/#java17 "Java Development Kit 17 - Ambiente de desenvolvimento para construção de aplicativos e componentes usando o Java")
2. Instale [Maven](https://maven.apache.org/download.cgi "Ferramenta de gerenciamento de projetos de software")
3. Execute o comando `mvn clean package` na pasta
4. Maven criará uma pasta `/target` com o o `.jar`
5. Inicie o programa com o `java -jar ./target/Concessionaria-AP3-1.0.jar` ou dê double-click

## Demonstração:
![Gif de demonstração no UNIX-Like](/img/app-demo.gif)

## Mac OS
![Tela vendas no macOS](/img/osx-print.webp)
## Windows
![Tela vendas no Windows](/img/win-print.webp)
## Linux Gnome
![Tela vendas no Linux Gnome](/img/gnome-print.webp)