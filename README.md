# Sistema de Cadastro e Classificação de Notícias

Este projeto consiste em uma aplicação Java executada via console, desenvolvida como base para a aplicação de conceitos de Boas Práticas de Programação. O sistema permite cadastrar notícias ou textos informativos, classificá-los manualmente ou automaticamente e listar os registros armazenados durante a execução.

A proposta principal do projeto é demonstrar melhorias relacionadas à organização do código, separação de responsabilidades, validação de entradas, tratamento de erros simples e prevenção de comportamentos inesperados.

## Funcionalidades

O sistema apresenta um menu com as seguintes opções:

1. **Adicionar manual**: permite que o usuário informe o texto da notícia e defina manualmente sua classificação.
2. **Adicionar automático**: permite que o usuário informe apenas o texto da notícia, enquanto o sistema realiza uma classificação automática com base em regras simples.
3. **Listar**: exibe todas as notícias cadastradas e suas respectivas classificações.
4. **Sair**: encerra a execução da aplicação.

## Classificações utilizadas

As notícias podem receber uma das seguintes classificações:

- `confiavel`
- `duvidosa`
- `falsa`

Na classificação manual, o sistema valida a entrada do usuário e aceita apenas valores previstos. Na classificação automática, são utilizados critérios simples, como presença de fonte e sinais textuais de alerta.

## Validações implementadas

Foram adicionadas validações com o objetivo de aplicar Programação Defensiva e tornar o sistema mais robusto. Entre as principais validações implementadas, destacam-se:

- validação da opção informada no menu;
- tratamento de entradas não numéricas;
- impedimento de textos nulos ou vazios;
- exigência de tamanho mínimo para o texto da notícia;
- definição de tamanho máximo para evitar entradas excessivamente longas;
- verificação de presença de caracteres alfabéticos no texto;
- normalização de espaços duplicados;
- validação das classificações permitidas;
- normalização de classificações com ou sem acento;
- impedimento de cadastro de notícias duplicadas.

Essas validações evitam que entradas inadequadas interrompam a execução do sistema ou gerem dados inconsistentes.

## Estrutura do projeto

```text
BPP-main/
├── README.md
├── src/
│   ├── Main.java
│   ├── Model/
│   │   ├── Dashboard.java
│   │   ├── NewsRepository.java
│   │   └── SystemOfAdditionAndClassification.java
│   └── Verification/
│       ├── News.java
│       ├── NewsClassification.java
│       └── NewsValidator.java
```

## Descrição das principais classes

### `Main`

Classe principal da aplicação. É responsável por iniciar o sistema e chamar o menu principal.

### `Dashboard`

Responsável pela exibição do menu e pela navegação entre as funcionalidades disponíveis. Também valida a opção informada pelo usuário, evitando falhas causadas por entradas inválidas.

### `SystemOfAdditionAndClassification`

Controla as operações de cadastro, classificação e listagem de notícias. Essa classe faz a mediação entre a entrada do usuário, o classificador automático e o repositório.

### `NewsRepository`

Armazena as notícias cadastradas em memória. Também impede o cadastro de textos duplicados e protege a lista interna contra modificações externas indevidas.

### `News`

Representa uma notícia cadastrada no sistema. A classe garante que todo objeto criado possua texto e classificação válidos.

### `NewsClassification`

Realiza a classificação automática das notícias com base em critérios simples, como presença de fonte e sinais textuais de alerta.

### `NewsValidator`

Centraliza as regras de validação e normalização utilizadas no projeto. Essa separação evita duplicação de código e facilita futuras manutenções.

## Documentação no código

O projeto recebeu comentários úteis e documentação básica em formato Javadoc. Os comentários foram adicionados principalmente em classes e métodos que possuem responsabilidades relevantes dentro do sistema.

A documentação foi mantida objetiva, evitando excesso de comentários em trechos simples ou autoexplicativos. Dessa forma, os comentários contribuem para a compreensão do código sem prejudicar sua leitura.

## Como executar

Para compilar o projeto pelo terminal, acesse a pasta raiz do projeto e execute:

```bash
javac -encoding UTF-8 -d out $(find src -name "*.java")
```

Em seguida, execute a aplicação com:

```bash
java -cp out Main
```

Caso esteja utilizando uma IDE, como IntelliJ IDEA, Eclipse ou VS Code, basta abrir a pasta do projeto, localizar a classe `Main` e executar o método `main`.

## Observações

Os dados cadastrados são mantidos apenas em memória. Portanto, ao encerrar o programa, as notícias cadastradas durante a execução são perdidas.

O classificador automático utiliza regras simples e não tem como objetivo realizar uma verificação real de notícias falsas. Sua finalidade é demonstrar organização de código, modularização e aplicação de boas práticas em um contexto didático.
