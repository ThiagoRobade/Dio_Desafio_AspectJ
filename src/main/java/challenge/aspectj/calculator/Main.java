package challenge.aspectj.calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("Adição: " + calculator.add(10, 5));
        System.out.println("Subtração: " + calculator.subtract(10, 5));
        System.out.println("Multiplicação: " + calculator.multiply(10, 5));
        try {
            System.out.println("Divisão: " + calculator.divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Exceção capturada: " + e.getMessage());// A Mensagem sairá em inglês
        }
    }
}

