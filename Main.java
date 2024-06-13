import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Введите два числа и оператор:");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        try {
            String result = calc(userInput);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        Integer result;
        String[] symbols = input.split(" ");
        String value1 = symbols[0];
        String value2 = symbols[2];
        String operand = symbols[1];
        if (symbols.length != 3) {
            throw new Exception("Ошибка, введите два числа и оператор.");
        }

        int num1 = Integer.parseInt(symbols[0]);
        int num2 = Integer.parseInt(symbols[2]);
        result = calc(num1, num2, operand);
        return result.toString();
    }

    private static int calc(int num1, int num2, String operand) throws Exception {
        int result;
        if (operand.equals("/") && num2 == 0) {
            throw new Exception("Ошибка, на ноль делить нельзя");
        } else if ((num1 > 0 && num1 <= 10) && (num2 > 0 && num2 <= 10)) {
            switch (operand) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                default:
                    throw new Exception("Ошибка, введите корректный оператор (+, -, *, /).");
            }

        } else  {
            throw new Exception("Ошибка, введите числа от 1 до 10");
        }
        return result;
    }
}
