/*
Autores
Atilio Almeida Costa CB3025497
Leandro Felix Nunes  CB3026159
*/
import java.util.Scanner;

public class Hora {
    private int hora;
    private int min;
    private int seg;

    // Construtor padrao que pede ao usuario para inserir valores
    public Hora() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira a hora (0-23):");
        this.hora = lerIntValido(scanner, 0, 23);
        System.out.println("Insira os minutos (0-59):");
        this.min = lerIntValido(scanner, 0, 59);
        System.out.println("Insira os segundos (0-59):");
        this.seg = lerIntValido(scanner, 0, 59);
    }

    // Construtor que recebe valores de hora, minuto e segundo
    public Hora(int h, int m, int s) {
        this.hora = ajustarParaLimite(h, 0, 23);
        this.min = ajustarParaLimite(m, 0, 59);
        this.seg = ajustarParaLimite(s, 0, 59);
    }

    // Metodos de configuracao
    public void setHor(int h) {
        this.hora = ajustarParaLimite(h, 0, 23);
    }

    public void setMin(int m) {
        this.min = ajustarParaLimite(m, 0, 59);
    }

    public void setSeg(int s) {
        this.seg = ajustarParaLimite(s, 0, 59);
    }

    public void setHor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira a nova hora (0-23):");
        this.hora = lerIntValido(scanner, 0, 23);
    }

    public void setMin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira os novos minutos (0-59):");
        this.min = lerIntValido(scanner, 0, 59);
    }

    public void setSeg() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira os novos segundos (0-59):");
        this.seg = lerIntValido(scanner, 0, 59);
    }

    // Metodos de obtencao
    public int getHor() {
        return this.hora;
    }

    public int getMin() {
        return this.min;
    }

    public int getSeg() {
        return this.seg;
    }

    // Obter a hora no formato hh:mm:ss
    public String getHora1() {
	System.out.println("");
	System.out.println("-----------------------------------------");
        System.out.println("");
        return String.format("%02d:%02d:%02d", this.hora, this.min, this.seg);

    }

    // Obter a hora no formato hh:mm:ss (AM/PM)
    public String getHora2() {
        int horas12 = this.hora % 12;
        if (horas12 == 0) {
            horas12 = 12;
        }

        String ampm = (this.hora >= 12) ? "PM" : "AM";
        System.out.println("");
	System.out.println("-----------------------------------------");
        System.out.println("");
        return String.format("%02d:%02d:%02d %s", horas12, this.min, this.seg, ampm);
    }

    // Obter a quantidade de segundos no total
    public int getSegundos() {
        System.out.println("");
	System.out.println("-----------------------------------------");
        System.out.println("");
        return this.hora * 3600 + this.min * 60 + this.seg;
    }

    // Metodos privados para validacao
    private int ajustarParaLimite(int valor, int min, int max) {
        if (valor < min) {
            return min;
        } else if (valor > max) {
            return max;
        }
        return valor;
    }

    // Metodo para ler um valor inteiro valido entre um intervalo especifico
    private int lerIntValido(Scanner scanner, int min, int max) {
        while (true) {
            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Valor fora do limite. Tente novamente.");
                }
            } else {
                System.out.println("Entrada invalida. Por favor, insira um numero.");
                scanner.next(); // Limpar entrada incorreta
            }
        }
    }
public static void main(String[] args) {
        // Testando os construtores
        Hora hora1 = new Hora(); // Construtor que pede entrada do usuario
        System.out.println("Hora 1: " + hora1.getHora1());
        
        Hora hora2 = new Hora(); // Construtor com argumentos
        System.out.println("Hora 2: " + hora2.getHora1());

        // Testando os metodos de obtencao
        System.out.println("Hora 1 (formato 12 horas): " + hora1.getHora2());
        System.out.println("Hora 2 (formato 12 horas): " + hora2.getHora2());

        System.out.println("Hora 1 em segundos: " + hora1.getSegundos());
        System.out.println("Hora 2 em segundos: " + hora2.getSegundos());
    }
}
