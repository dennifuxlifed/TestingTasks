package Task3;

import java.security.SecureRandom;
import java.util.Scanner;

class PasswordGenerator {

    private static final String UpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LowerCase = "abcdefghijklmnopqrstuvwxyz";
    private static final String Numbers = "0123456789";
    private static final String SpecialSymbols = "!@#$%^&*()-_+=<>?";

    private static final String AllSymbols = UpperCase + LowerCase + Numbers + SpecialSymbols;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину пароля (от 8 до 12): ");
        int length = scanner.nextInt();

        if (length < 8 || length > 12) {
            System.out.println("Длина пароля должна быть от 8 до 12 символов.");
        } else {
            String password = generatePassword(length);
            System.out.println("Сгенерированный пароль: " + password);
        }
        scanner.close();
    }

    public static String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        password.append(UpperCase.charAt(random.nextInt(UpperCase.length())));
        password.append(LowerCase.charAt(random.nextInt(LowerCase.length())));
        password.append(Numbers.charAt(random.nextInt(Numbers.length())));
        password.append(SpecialSymbols.charAt(random.nextInt(SpecialSymbols.length())));

        for (int i = 4; i < length; i++) {
            password.append(AllSymbols.charAt(random.nextInt(AllSymbols.length())));
        }

        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        SecureRandom random = new SecureRandom();
        char[] array = input.toCharArray();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return new String(array);
    }
}

