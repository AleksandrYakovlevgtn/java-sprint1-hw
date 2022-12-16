import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Здравствуйте это приложение \"Счетчик шагов!\"");
        StepTracker stepTracker = new StepTracker();


        while (true) {
            System.out.println("Ваше целевое значение шагов в день - " + stepTracker.targetStep + " !");
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                int step = 0;
                int monthINT;
                int day;
                while (true) {
                    System.out.println("За какой месяц внести количество шагов?");
                    System.out.println(" Январь - 1 ... Декабрь - 12 ");
                    monthINT = scanner.nextInt();
                    if (monthINT <= 0 || monthINT >= 13) {
                        System.out.println("В году 12 месецев!");
                    } else {
                        break;
                    }
                }
                while (true) {
                    System.out.println("за какой день \"" + stepTracker.months[monthINT - 1] + "\" внести шаги ?");
                    day = scanner.nextInt();
                    if (day < 1 || day > 30) {
                        System.out.println("В месяце всего 30 дней!");
                    } else {
                        break;
                    }
                }
                while (true) {
                    System.out.println("Введите колличество шагов !");
                    step = scanner.nextInt();
                    if (step < 0) {
                        System.out.println("Неможет быть! Постарайтесь еще.");
                    } else {
                        System.out.println("Отлично ! Осталось еще " + (stepTracker.targetStep - step) + " шагов за сегодня. ");
                        break;
                    }
                }
                stepTracker.addStep(monthINT, day, step);
            } else if (userInput == 2) {
                System.out.println("За какой месяц хотели бы получить статистику?");
                System.out.println(" Январь - 1 ... Декабрь - 12 ");
                int monthINT = scanner.nextInt();
                stepTracker.statistiсStepByDays(monthINT);
                stepTracker.maxStepInMonth(monthINT);
                stepTracker.averageStepInMonth(monthINT);
                stepTracker.sumStepInMonth(monthINT);
                stepTracker.seriesStep(monthINT);
            } else if (userInput == 3) {
                System.out.println("Введите новую цель по количеству шагов в день.");
                int newTargetStep = scanner.nextInt();
                stepTracker.changeTargetStep(newTargetStep);
            } else if (userInput == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день месяца");
        System.out.println("2 - Вывод статистики за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }
}
