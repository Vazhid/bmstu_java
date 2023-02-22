import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(password_check(args[0])); //вариант 1 задача 3
        System.out.println(div_test_3_9(Integer.parseInt(args[1]))); //вариант 1 задача 4
        System.out.println(div_test_5_7(Integer.parseInt(args[2]))); //вариант 2 задача 3
        n_strings(Integer.parseInt(args[3])); //вариант 2 задача 4
    }

    public static void n_strings(int n) {

        Scanner inp = new Scanner(System.in);
        String[] strings = new String[n];

        for (int i = 0; i < n; ++i) {
            if (inp.hasNextLine()) {
                strings[i] = inp.nextLine();
            }
        }

        for (int i = 0; i < n; ++i) {
            System.out.println(strings[i]);
        }

        for (int i = 0; i < n; ++i) {
            System.out.print(strings[i]);
        }
    }

    public static boolean password_check(String pass) {
        String password = "";
        System.out.print("Password: ");
        Scanner in = new Scanner(System.in);
        if (in.hasNextLine()) {
            password = in.nextLine();
        }
        return password.equals(pass);
    }

    public static boolean div_test_3_9(int number) {
        return (number % 3 == 0);
    }

    public static boolean div_test_5_7(int number) {
        return number % 5 == 0 && number % 7 == 0;
    }
}