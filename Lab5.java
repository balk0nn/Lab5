import java.util.Arrays;
import java.util.Scanner;
public class Lab5 {
    public static void main(String[] Args) {
        Scanner scan = new Scanner(System.in);
        int[] array = new int[0];
        System.out.println("Вводите числа, чтобы заполнить массив\n" +
                "Когда закончите, введите \"quit\"");
        String input = null;
        int element = 0;
        do {
            input = scan.nextLine();
            try {
                element = Integer.parseInt(input);
                array = Arrays.copyOf(array, array.length + 1);
                array[array.length - 1] = element;
            } catch (Exception NumberFormatException) {
                if (!input.equals("quit")) {
                    System.out.println("Not an integer");
                }
            }
        }
        while (!input.equals("quit"));
        System.out.println("Enter the number you want " +
                "to exclude from the array");
        int ban = 0;
        while (!scan.hasNextInt()) {
            System.out.println("Not an integer");
            scan.next();
        }
        ban = scan.nextInt();
        scan.close();
        int count = 0;
        int[] arr = Arrays.copyOf(array, array.length);
        int dlina = arr.length;
        for (int i = 0; i < dlina; i++) {
            if (arr[i] == ban) {
                count++;
                dlina--;
                for (int k = i; k < arr.length - count; k++) {
                    arr[k] = arr[k + 1];
                }
                i--;
            }
        }
        arr = Arrays.copyOf(arr, arr.length - count);
        System.out.println("Your original array "+ Arrays.toString(array));
        System.out.println("You chose to ban number " + ban);
        System.out.println("Your array without " +
                "the banned number: " + Arrays.toString(arr));
    }
}