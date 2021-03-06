import java.util.Random;
import java.util.Scanner;
//Полностью разобраться с кодом;
//Переделать проверку победы, чтобы она не была реализована просто набором условий.
//* Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
//*** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока, и пытаться выиграть сам.
public class homeWork_2 {
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static int fieldSizeY;
    private static int fieldSizeX;
    private static char[][] field;

    private static void initField() {
        fieldSizeX = 3;
        fieldSizeY = 3;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.print("+");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++)
            System.out.print((x % 2 == 0) ? "-" : x / 2 + 1);
        System.out.println();

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++)
                System.out.print(field[y][x] + "|");
            System.out.println();
        }

        for (int x = 0; x <= fieldSizeX * 2 + 1; x++)
            System.out.print("-");
        System.out.println();
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты хода X и Y (от 1 до 3) через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static void aiTurn() {
        //int x;
        //int y;
            /*do {
                x = RANDOM.nextInt(fieldSizeX);
                y = RANDOM.nextInt(fieldSizeY);
            } while (!isEmptyCell(x, y));*/
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_HUMAN && !isEmptyCell(x + 1, y)) {
                    field[y][x + 1] = DOT_AI;
                } else if (field[y][x] == DOT_HUMAN && !isEmptyCell(x, y + 1)) {
                    field[y + 1][x] = DOT_AI;
                } else if (field[y][x] == DOT_HUMAN && !isEmptyCell(x + 1, y + 1)) {
                    field[y + 1][x + 1] = DOT_AI;
                } else if (field[y][x] == DOT_HUMAN && !isEmptyCell(x - 1, y)) {
                    field[y][x - 1] = DOT_AI;
                } else if (field[y][x] == DOT_HUMAN && !isEmptyCell(x, y - 1)) {
                    field[y - 1][x] = DOT_AI;
                } else if (field[y][x] == DOT_HUMAN && !isEmptyCell(x - 1, y - 1)) {
                    field[y - 1][x - 1] = DOT_AI;
                }
            }
        }
    }

    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(x, y)) return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char c) {
        // hor
        boolean w=false;
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == c && field[y][x + 1] == c && field[y][x + 2] == c) w= true;
                //if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
                //if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

                // ver
                if (field[y][x] == c && field[y + 1][x] == c && field[y + 2][x] == c) w= true;
                //if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
                //if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

                // dia
                if (field[y][x] == c && field[y + 1][x + 1] == c && field[y + 2][x + 2] == c) w= true;
                if (field[y][x + 2] == c && field[y + 1][x + 1] == c && field[y + 2][x] == c) w= true;

            }
        }
        return w;
    }

    public static void main(String[] args) {
        initField();
        printField();
        String answer;
        do {
            while (true) {
                humanTurn();
                if (checkEndGame(DOT_HUMAN, "Human win!")) break;
                aiTurn();
                if (checkEndGame(DOT_AI, "Computer win!")) break;
            }
            System.out.println("Wanna play again? (y/n) >>> ");
            answer = SCANNER.next();
        } while (answer.equals("y"));
        SCANNER.close();
    }

    private static boolean checkEndGame(char dot, String winMessage) {
        printField();
        if (checkWin(dot)) {
            System.out.println(winMessage);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Draw!");
            return true;
        }
        return false;
    }
}


