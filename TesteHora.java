/*
Autores
Atilio Almeida Costa CB3025497
Leandro Felix Nunes  CB3026159
*/

import java.util.Scanner;

public class TesteHora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean repetir = true;

        // Loop para permitir que o usuário teste a classe Hora várias vezes
        while (repetir) {
            // Criação de um objeto Hora
            Hora hora = new Hora();

            // Exibição da hora no formato hh:mm:ss
            System.out.println("Hora atual: " + hora.getHora1());

            // Exibição da hora no formato 12 horas
            System.out.println("Hora atual (formato 12 horas): " + hora.getHora2());

            // Exibição da hora em segundos
            System.out.println("Hora atual em segundos: " + hora.getSegundos());

            // Pergunta ao usuário se deseja continuar
            System.out.println("");
            System.out.println("-----------------------------------------");
            System.out.println("");
            System.out.println("Deseja inserir outra hora? (S/N)");
            String continuar = scanner.next();

            // Verifica se o usuário deseja continuar ou sair do programa
            if (continuar.equalsIgnoreCase("n")) { // Usando equalsIgnoreCase() para comparar as strings
                repetir = false;
                System.out.println("Encerrando o programa...");
            }
        }

        // Fechando o scanner
        scanner.close();
    }
}
