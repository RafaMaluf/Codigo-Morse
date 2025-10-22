# Árvore Binária de Código Morse (Java)

Implementação em Java de uma árvore binária para Código Morse, onde ponto (.) navega pra esquerda e traço (-) pra direita até o nó que armazena o símbolo.  
O programa tem um menu no console para popular a árvore com o alfabeto padrão, inserir novos mapeamentos, codificar e decodificar mensagens, e exibir a árvore.
O código foi feito sem o uso de bibliotecas ou estruturas prontas, seguindo as seguintes restrições da disciplina
- Sem estruturas prontas de dados: `List`, `ArrayList`, `Map`, `StringBuilder`, etc.  
- Permitido: `String`, tipos primitivos (`int`, `float`), `try-catch`, `throws` e funções básicas de entrada.  
- `length` apenas em **String**.  
- Árvore binária implementada manualmente com nós encadeados (`Nodo` com `esquerdo` e `direito`).  
- Sem dependências externas.

### Universidade: 
**Pontifícia Universidade Católica do Paraná (PUCPR)**  

### Professor: 
**Andrey Cabral Meira**

### Equipe:  
**Henry Mendes**  
**Kaue Fontoura**  
**Matheus Bernardi**  
**Rafael Maluf**

## Arquivos:
- **Nodo.java:** nó mínimo com `char simbolo`, `Nodo esquerdo`, `Nodo direito`.  
- **ArvoreBinariaMorse.java:** árvore de Morse com:
  - `inicializar()`
  - `inserir(String codigoMorse, char simbolo)`
  - `buscar(String codigoMorse)`
  - `remover(String codigoMorse)`
  - `buscarMorsePorCaractere(char simbolo)`
  - `textoParaMorse(String texto)`
  - `morseParaTexto(String codigoMorse)`
  - `exibir()`
  - `popularPadrao()` → carrega **A–Z** e **0–9** conforme a tabela tradicional.  
- **Main.java:** cria a árvore, chama `popularPadrao()` e apresenta **menu interativo** no console.


## Uso – fluxo geral

Ao iniciar:

1. A árvore é criada e `popularPadrao()` insere os códigos de **A–Z** e **0–9**.  
2. O menu interativo do `Main` oferece operações como:
   - Inserir novo mapeamento (código Morse e símbolo).  
   - Codificar texto em Morse.  
   - Decodificar Morse para texto.  
   - Remover um mapeamento existente.  
   - Exibir a árvore no console.  
   - Sair do programa.


## Exemplos rápidos

### Decodificar

Entrada:
```
.---- ..--- ...-- ....- -----
```
Saída:
```
12345
```


### Codificar

Entrada:
```
PUCPR
```
Saída:
```
.--. ..- -.-. .--. .-.
```


### Inserir mapeamento

Código:
```
.-.--
```
Símbolo:
```
X
```
Resultado: Grava `X` no nó destino.

## Decisões de implementação

- Navegação por string: `.` segue para nodo `esquerdo`, `-` para nodo `direito`.  
- Operações **somente com String e tipos primitivos**, sem coleções prontas.  
- `popularPadrao()` monta a base completa de **A–Z** e **0–9**.  
- Métodos adicionais para suporte bidirecional:
  - `textoParaMorse()` → codificação.  
  - `morseParaTexto()` → decodificação.  
  - `buscarMorsePorCaractere()` → busca reversa de símbolo.

## Testes manuais sugeridos

- Popular a árvore padrão e decodificar `... --- ...` → `SOS`.  
- Codificar `PUCPR` → `.--. ..- -.-. .--. .-.`.  
- Inserir um novo mapeamento (`.-.-` → `X`) e validar com codificar/decodificar.  
- Remover um mapeamento e verificar comportamento ao decodificar aquele caminho.  
- Exibir a árvore e conferir a distribuição esquerda/direita conforme `.` e `-`.
