package morse;

public class ArvoreBinariaMorse {

    private Nodo raiz;

    public void inicializar() {
        raiz = new Nodo();
    }

    public boolean inserir(String codigoMorse, char simbolo) {
        if (codigoMorse == null || codigoMorse.length() == 0) {
            return false;
        }

        Nodo atual = raiz;

        for (int i = 0; i < codigoMorse.length(); i++) {
            char caractere = codigoMorse.charAt(i);

            if (caractere == '.') {
                if (atual.esquerdo == null) {
                    atual.esquerdo = new Nodo();
                }
                atual = atual.esquerdo;
            } else if (caractere == '-') {
                if (atual.direito == null) {
                    atual.direito = new Nodo();
                }
                atual = atual.direito;
            } else {
                return false;
            }
        }

        atual.simbolo = simbolo;
        return true;
    }

    public char buscar(String codigoMorse) {
        if (codigoMorse == null || codigoMorse.length() == 0) {
            return '\0';
        }

        Nodo atual = raiz;

        for (int i = 0; i < codigoMorse.length(); i++) {
            char caractere = codigoMorse.charAt(i);

            if (caractere == '.') {
                if (atual.esquerdo == null) {
                    return '\0';
                }
                atual = atual.esquerdo;
            } else if (caractere == '-') {
                if (atual.direito == null) {
                    return '\0';
                }
                atual = atual.direito;
            } else {
                return '\0';
            }
        }

        return atual.simbolo;
    }

    public boolean remover(String codigoMorse) {
        if (codigoMorse == null || codigoMorse.length() == 0) {
            return false;
        }

        Nodo atual = raiz;

        for (int i = 0; i < codigoMorse.length(); i++) {
            char caractere = codigoMorse.charAt(i);

            if (caractere == '.') {
                if (atual.esquerdo == null) {
                    return false;
                }
                atual = atual.esquerdo;
            } else if (caractere == '-') {
                if (atual.direito == null) {
                    return false;
                }
                atual = atual.direito;
            } else {
                return false;
            }
        }

        atual.simbolo = '\0';
        return true;
    }

    public String buscarMorsePorCaractere(char simbolo) {
        String caminho = buscarMorseProfundidade(raiz, simbolo, "");
        if (caminho == null) {
            return "";
        }
        return caminho;
    }

    private String buscarMorseProfundidade(Nodo nodo, char alvo, String prefixo) {
        if (nodo == null) {
            return null;
        }

        if (nodo.simbolo == alvo) {
            return prefixo;
        }

        String resultadoEsquerda = buscarMorseProfundidade(nodo.esquerdo, alvo, prefixo + ".");
        if (resultadoEsquerda != null) {
            return resultadoEsquerda;
        }

        String resultadoDireita = buscarMorseProfundidade(nodo.direito, alvo, prefixo + "-");
        if (resultadoDireita != null) {
            return resultadoDireita;
        }

        return null;
    }

    public String textoParaMorse(String texto) {
        String resultado = "";

        for (int i = 0; i < texto.length(); i++) {
            char caractere = texto.charAt(i);

            if (caractere == ' ') {
                if (resultado.length() > 0 && resultado.charAt(resultado.length() - 1) != ' ') {
                    resultado = resultado + "/ ";
                }
                continue;
            }

            if (caractereValido(caractere)) {
                String codigo = buscarMorsePorCaractere(caractere);

                if (codigo.length() > 0) {
                    boolean precisaEspaco =
                        resultado.length() > 0 &&
                        resultado.charAt(resultado.length() - 1) != ' ' &&
                        resultado.charAt(resultado.length() - 1) != '/';

                    if (precisaEspaco) {
                        resultado = resultado + " ";
                    }

                    resultado = resultado + codigo;
                }
            }
        }

        return resultado;
    }

    public String morseParaTexto(String codigoMorse) {
        String texto = "";
        int indice = 0;

        while (indice < codigoMorse.length()) {
            char caractereAtual = codigoMorse.charAt(indice);

            if (caractereAtual == ' ') {
                indice++;
                continue;
            }

            if (caractereAtual == '/') {
                texto = texto + " ";
                indice++;
                continue;
            }

            String token = "";

            while (indice < codigoMorse.length()) {
                char caractere = codigoMorse.charAt(indice);

                if (caractere == '.' || caractere == '-') {
                    token = token + caractere;
                    indice++;
                } else {
                    break;
                }
            }

            char simbolo = buscar(token);

            if (simbolo != '\0') {
                texto = texto + simbolo;
            }

            while (indice < codigoMorse.length() && codigoMorse.charAt(indice) == ' ') {
                indice++;
            }
        }

        return texto;
    }

    public void exibir() {
        exibirRecursivo(raiz, 0, ' ');
    }

    private void exibirRecursivo(Nodo nodo, int nivel, char direcao) {
        if (nodo == null) {
            return;
        }

        String espacos = "";
        for (int i = 0; i < nivel; i++) {
            espacos = espacos + "  ";
        }

        String simbolo = "_";
        if (nodo.simbolo != '\0') {
            simbolo = String.valueOf(nodo.simbolo);
        }

        if (nivel == 0) {
            System.out.println("(root) " + simbolo);
        } else {
            System.out.println(espacos + direcao + "> " + simbolo);
        }

        exibirRecursivo(nodo.esquerdo, nivel + 1, '.');
        exibirRecursivo(nodo.direito, nivel + 1, '-');
    }

    private boolean caractereValido(char caractere) {
        boolean letraMaiuscula = caractere >= 'A' && caractere <= 'Z';
        boolean digito = caractere >= '0' && caractere <= '9';
        return letraMaiuscula || digito;
    }

    public void popularPadrao() {
        String[] simbolos = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
        };

        String[] codigos = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
            "-----", ".----", "..---", "...--", "....-", ".....", "-....",
            "--...", "---..", "----."
        };

        for (int i = 0; i < simbolos.length; i++) {
            inserir(codigos[i], simbolos[i].charAt(0));
        }
    }
}
