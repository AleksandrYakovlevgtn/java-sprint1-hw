import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Здравствуйте это приложение \"Счетчик шагов!\"");
        StepTracker stepTracker = new StepTracker();


        while (true){
            System.out.println("Ваше целевое значение шагов в день - " + stepTracker.targetStep + " !");
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 1){
                int step = 0;
                System.out.println("За какой месяц внести количество шагов?");
                System.out.println(" Январь - 1 ... Декабрь - 12 ");
                int monthINT = scanner.nextInt();
                System.out.println("за какой день \"" + stepTracker.months[monthINT - 1] + "\" внести шаги ?");
                int day = scanner.nextInt();
                while (true){
                    System.out.println("Введите колличество шагов !");
                    step = scanner.nextInt();
                    if(step < 0){
                    System.out.println("Неможет быть! Постарайтесь еще.");
                    }else {
                        System.out.println("Отлично ! Осталось еще " + (stepTracker.targetStep - step) + " шагов за сегодня. ");
                        break;
                    }
                }
                stepTracker.addStep(monthINT,day,step);// Надо отправить в класс StepTracker в в метод добавления шагов
            }else if (userInput == 2){
                System.out.println("За какой месяц хотели бы получить статистику?");
                System.out.println(" Январь - 1 ... Декабрь - 12 ");
                int monthINT = scanner.nextInt();
                stepTracker.statistikaStepByDays(monthINT);
                stepTracker.sumStepInMonth(monthINT);
                stepTracker.maxStepInMonth(monthINT);
                stepTracker.sredeeStepInMonth(monthINT);

                // Надо отправить в класс StepTracker в ~~ 7 методов
            }else if(userInput == 3){
                //**********************
            }else if(userInput == 0){
                System.out.println("Выход");
                break;
            }else {
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
