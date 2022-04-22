# ProjetoFX

Demonstração de como criar um projeto modular simples usando JavaFX, Lombok e Maven.

### Tecnologias abordadas

- **Oracle Java 17:** para criar o projeto modular.
- **JavaFX 17:** obtido através do Maven, possui os componentes para criação da interface gráfica.
- **FXML** e **CSS:** Usados, respectivamente, para desenvolver e estilizar a interface gráfica.
- **Lombok:** Obtido através do Maven. Nessa demonstração o lombok foi usado apenas para mascarar o lançamento de algumas exceções, mas ele possui muitas outras funcionalidades. [Site](https://projectlombok.org/).
- **Preloader:** O projeto implementa uma janela de preloader para melhorar a experiência de usuário.

### Imagem de Execução Personalizada

Por ser um projeto modular, podemos gerar uma Imagem de Execução Personalizada
dele. Usando o plugin do JavaFx no maven essa tarefa se torna bem fácil.

Esse é o [plugin](https://github.com/openjfx/javafx-maven-plugin) responsável 
pela criação da imagem:

```xml
<plugin>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-maven-plugin</artifactId>
    <version>0.0.8</version>
    <configuration>
        <jmodsPath>/usr/lib/jvm/javafx-jmods-17.0.2/</jmodsPath>
        <compress>2</compress>
        <noHeaderFiles>true</noHeaderFiles>
        <noManPages>true</noManPages>
        <stripDebug>true</stripDebug>
        <mainClass>ProjetoFX/projetofx.principal.Principal</mainClass>
        <jlinkImageName>ProjetoFXImage</jlinkImageName>
        <launcher>ProjetoFX-Launcher</launcher>
    </configuration>
</plugin>
```

Para utilizá-lo, basta usar o comando:

```
mvn javafx:jlink
```

**Observação:** adicionando a linha nas configurações

```xml
<jlinkZipName>ProjetoFX-${version}</jlinkZipName>
```

fará com que o plugin crie um pacote zip contendo a imagem gerada, nomeado de
acordo com a versão do projeto.

Caso o projeto não esteja compilado ainda, pode usar esse comando:

```
mvn compile javafx:jlink
```

Se desejar fazer uma compilação limpa, faça assim:

```
mvn clean compile javafx:jlink
```

**Atenção:** Para que o maven possa compilar o projeto, é necessário adicionar o
plugin de compilação:

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.8.1</version>
    <configuration>
        <source>17</source>
        <target>17</target>
        <annotationProcessorPaths>
            <path>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <version>1.18.22</version>
            </path>
        </annotationProcessorPaths>
    </configuration>
</plugin>
```

**Observação:** nesse exemplo, o plugin já está configurado para trabalhar com o
lombok.
