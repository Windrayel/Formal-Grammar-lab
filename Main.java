import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char[] symbols = in.nextLine().toCharArray();
        boolean status = false;
        int currentState = 1;
        boolean breakFlag = false;
        for (char symbol : symbols) {
            if (breakFlag)
                break;
            switch (currentState) {
                case 1 -> {
                    switch (symbol) {
                        case 'a' -> currentState = 2;
                        case 'b', 'c' -> breakFlag = true;
                    }
                }
                case 2 -> {
                    switch (symbol) {
                        case 'b' -> currentState = 3;
                        case 'c' -> breakFlag = true;
                    }
                }
                case 3 -> {
                    switch (symbol) {
                        case 'a' -> currentState = 2;
                        case 'c' -> {
                            currentState = 4;
                            status = true;
                        }
                    }
                }
                case 4 -> {
                    switch (symbol) {
                        case 'a' -> {
                            status = false;
                            breakFlag = true;
                        }
                        case 'b' -> {
                            currentState = 5;
                            status = false;
                        }
                    }
                }
                case 5 -> {
                    switch (symbol) {
                        case 'a' -> breakFlag = true;
                        case 'c' -> {
                            currentState = 4;
                            status = true;
                        }
                    }
                }
            }
        }
        System.out.println(status);
    }
}
