package Task1;

import java.util.Scanner;

public class Game {
    private final Drawer hangmandrawer = new Drawer();
    private final Rws wordSelector = new Rws();
    private final Mask maskOperator = new Mask();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String option;
        int misstakeCount;

        while (true){
            System.out.println("Виселица \nМеню: [N]ew game / [E]xit");
            option = scanner.nextLine();


            if (option.equalsIgnoreCase("N")){
                misstakeCount = 0;
                maskOperator.cleanBuffer();
                hangmandrawer.clearDrawing();
                String letter;
                String guessWord = wordSelector.getWords();
                maskOperator.setWord(guessWord);
                System.out.println("Случайное слово загадано!");
                maskOperator.printMask();

                while (!maskOperator.UserWon()){
                    System.out.println("Введите букву: ");
                    letter = scanner.nextLine();

                    if (maskOperator.AllreadyUsedLetters(letter)){
                        System.out.println("Вы уже вводили данную букву "+ letter);
                    }
                    else {
                        maskOperator.setUserLetters(letter);
                        if (maskOperator.containsLetter(letter)){
                            System.out.println("Вы угадали букву!");
                            System.out.println("Слово:");
                            maskOperator.updateMask(letter);
                            maskOperator.printMask();
                        }else {
                            System.out.println("Вы не угадали букву!");
                            misstakeCount++;
                            System.out.println("Количество ошибок: " + misstakeCount);
                            hangmandrawer.updateHangmanDrawingMatrix(misstakeCount);
                            hangmandrawer.printHangman();
                        }
                    }
                    if(misstakeCount == 5){
                        System.out.println("Вы проиграли!");
                        System.out.printf("Слово было: %s! \n",guessWord);
                        break;
                    } else if (maskOperator.UserWon()){
                        System.out.println("Вы выиграли, поздравляем!");
                    }
                }

            }
            else if (option.equalsIgnoreCase("E")) {
                System.out.println("Выходим из игры...");
                System.exit(0);
            } else {
                System.out.println("Неккоректный ввод... Попробуйте еще раз");
            }
        }
    }




}
