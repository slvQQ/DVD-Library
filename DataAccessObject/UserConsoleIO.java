package DataAccessObject;

import java.util.Scanner;

public class UserConsoleIO implements UserIO{

    Scanner in = new Scanner(System.in);

    public void print(String message) {
        System.out.println(message);
    }

    public String readString(String prompt) {
        System.out.println(prompt);

        String a = in.nextLine();
        return a;
    }

    public double readDouble(String prompt) {
        System.out.println(prompt);
        Double a = in.nextDouble();
        return a;
    }

    public double readDouble(String prompt, double min, double max) {
        Double a;

        do {
            System.out.println(prompt);

            a = Double.parseDouble(in.nextLine());

            if (a > max || a < min) {
                System.out.println("Your input does not match the specified bounds.");
            }

        } while (a > max || a < min);

        return a;
    }

    public float readFloat(String prompt) {
        System.out.println(prompt);
        float a = in.nextFloat();
        return a;
    }

    public float readFloat(String prompt, float min, float max) {
        float a;

        do {
            System.out.println(prompt);

            a = in.nextFloat();

            if (a > max || a < min) {
                System.out.println("Your entry was not within the specified bounds.");
            }

        } while (a > max || a < min);

        return a;
    }

    public int readInt(String prompt) {
        System.out.println(prompt);
        int a = Integer.parseInt(in.nextLine());
        return a;
    }

    public int readInt(String prompt, int min, int max) {
        int a;

        do {
            System.out.println(prompt);

            a = Integer.parseInt(in.nextLine());

            if (a > max || a < min) {
                System.out.println("Your entry was not within the specified bounds.");
            }

        } while (a > max || a < min);

        return a;
    }

    public long readLong(String prompt) {
        System.out.println(prompt);
        long a = in.nextLong();
        return a;
    }

    public long readLong(String prompt, long min, long max) {
        long a;

        do {
            System.out.println(prompt);

            a = in.nextLong();

            if (a > max || a < min) {
                System.out.println("Your entry was not within the specified bounds.");
            }

        } while (a > max || a < min);

        return a;
    }


}
