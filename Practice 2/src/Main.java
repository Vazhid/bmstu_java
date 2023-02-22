import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        n_strings(Integer.parseInt(args[0])); //вариант 1 задача 3
        count_various_symbols(Integer.parseInt(args[0])); //вариант 1 задача 4
        LIS_in_matrix(Integer.parseInt(args[0])); //вариант 2 задача 3
        sum_in_matrix(Integer.parseInt(args[0])); //вариант 2 задача 4
    }

    public static void n_strings(int n) {

        Scanner inp = new Scanner(System.in);
        String[] strings = new String[n];
        int[] len_strings = new int[n];

        for (int i = 0; i < n; ++i) {
            if (inp.hasNextLine()) {
                strings[i] = inp.nextLine();
                len_strings[i] = strings[i].length();
            }
        }

        double avg;
        OptionalDouble aver = IntStream.of(len_strings).average();

        if (aver.isPresent())
            avg = aver.getAsDouble();
        else return;

        System.out.printf("Average is %.1f\n", avg);

        System.out.println("\nAbove average:");
        for (int i = 0; i < n; ++i) {
            if (len_strings[i] > avg) {
                System.out.printf("string: '%s', len: %d\n", strings[i], len_strings[i]);
            }
        }

        System.out.println("\nBelow average:");
        for (int i = 0; i < n; ++i) {
            if (len_strings[i] < avg) {
                System.out.printf("string: '%s', len: %d\n", strings[i], len_strings[i]);
            }
        }

    }

    public static void count_various_symbols(int n) {

        Scanner inp = new Scanner(System.in);
        String[] strings = new String[n];

        for (int i = 0; i < n; ++i) {
            if (inp.hasNextLine()) {
                strings[i] = inp.nextLine();
            }
        }

        int min = (int) strings[0].chars().distinct().count();
        int index = 0;
        int tmp;

        for (int i = 1; i < n; ++i) {
            tmp = (int) strings[i].chars().distinct().count();
            if (tmp < min) {
                index = i;
                min = tmp;
            }
        }

        System.out.printf("String: '%s', Count: %d", strings[index], min);

    }

    public static int[][] fill_in_matrix(int n) {
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int element = (int) (Math.random() * (2 * n + 1)) - n;
                matrix[i][j] = element;
            }
        }

        return matrix;
    }

    public static void print_matrix(int[][] matrix) {
        for(int[] row: matrix) {
            for (int element: row) {
                System.out.printf("%4d", element);
            }
            System.out.println();
        }
    }

    public static int[] matrix_to_list(int[][] matrix){
        int n = matrix.length;
        int[] list = new int[n*n];
        int index_of_list = 0;
        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                list[index_of_list] = ints[j];
                index_of_list++;
            }
        }
        return list;
    }

    public static void LIS_in_list(int[] input) {
        int[] lens = new int[input.length];
        int max = 0;

        for(int i=1; i<input.length; i++)
        {
            if (input[i]>input[i-1])
                lens[i] = lens[i-1]+1;
            else lens[i] = 0;
            max = Math.max(lens[i], max);
        }

        System.out.println(max + 1);
        for(int i=0; i<input.length; i++)
        {
            if (lens[i] == max)
            {
                for(int j = i - lens[i]; j <= i; j++)
                    System.out.print(input[j] + " ");
                System.out.println();
            }
        }
    }

    public static void LIS_in_matrix(int n) {
        int[][] matrix = fill_in_matrix(n);
        print_matrix(matrix);
        int[] sequence = matrix_to_list(matrix);
        LIS_in_list(sequence);
    }

    public static void sum_in_matrix(int n) {
        int[][] matrix = fill_in_matrix(n);
        print_matrix(matrix);
        int ind = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] > 0) {
                    ind++;
                } else if (matrix[i][j] <= 0 && ind == 1) {
                    sum += matrix[i][j];
                }
            }
            ind = 0;
        }

        System.out.println(sum);
    }
}