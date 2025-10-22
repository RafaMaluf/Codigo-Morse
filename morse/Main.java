package morse;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        arvore.inicializar();
        arvore.popularPadrao(); 

        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {

            System.out.println("\n=== ÁRVORE DE CÓDIGO MORSE ===");
            System.out.println("1) Converter texto para Morse");
            System.out.println("2) Converter Morse para texto");
            System.out.println("3) Inserir ou atualizar caractere");
            System.out.println("4) Remover caractere");
            System.out.println("5) Exibir árvore");
            System.out.println("0) Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine().trim();

            switch (opcao) {

                case "0":
                    executando = false;
                    break;

                case "1":
                    System.out.print("Digite o texto (A–Z ou 0–9): ");
                    String texto = scanner.nextLine().toUpperCase();
                    String codigoMorse = arvore.textoParaMorse(texto);
                    System.out.println("Código Morse: " + codigoMorse);
                    break;

                case "2":
                    System.out.println("Informe o código Morse separando letras por ESPAÇO e palavras por '/'.");
                    System.out.print("Código Morse: ");
                    String entradaMorse = scanner.nextLine().trim();
                    String textoConvertido = arvore.morseParaTexto(entradaMorse);
                    System.out.println("Texto convertido: " + textoConvertido);
                    break;

                case "3":
                    System.out.print("Informe o código Morse (exemplo: ...): ");
                    String caminho = scanner.nextLine().trim();

                    System.out.print("Informe o símbolo (A–Z ou 0–9): ");
                    String entradaSimbolo = scanner.nextLine().trim().toUpperCase();

                    if (entradaSimbolo.isEmpty()) {
                        System.out.println("Símbolo inválido. Operação cancelada.");
                        break;
                    }

                    char simbolo = entradaSimbolo.charAt(0);
                    boolean inserido = arvore.inserir(caminho, simbolo);

                    if (inserido) {
                        System.out.println("Caractere inserido ou atualizado com sucesso!");
                    } else {
                        System.out.println("Falha ao inserir: caminho inválido.");
                    }
                    break;

                case "4":
                    System.out.print("Informe o código Morse a remover (apenas limpa o símbolo): ");
                    String codigoRemover = scanner.nextLine().trim();
                    boolean removido = arvore.remover(codigoRemover);

                    if (removido) {
                        System.out.println("Caractere removido com sucesso!");
                    } else {
                        System.out.println("Falha ao remover: caminho inválido.");
                    }
                    break;

                case "5":
                    arvore.exibir();
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }
}
