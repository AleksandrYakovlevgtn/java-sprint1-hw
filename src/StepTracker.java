import java.util.Scanner;
public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    MonthData[] monthToData;
    int targetStep = 10_000;


    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData {
        int[] days = new int[30];
    }

    void addStep(int monthINT, int day, int step) {
        monthToData[monthINT].days[day - 1] = monthToData[monthINT].days[day - 1] + step;

    }

    void statistikaStepByDays(int monthINT) {
        for (int i = 0; i < 30; i++) {
            System.out.println((i + 1) + " день: " + monthToData[monthINT].days[i]);
        }
    }

    void sumStepInMonth(int monthINT) {
        int sumStepInMonth = 0;
        for (int i = 0; i < 30; i++) {
            sumStepInMonth = sumStepInMonth + monthToData[monthINT].days[i];
        }
        System.out.println("Общее количество шагов за " + monthINT + " составляет ");
    }
}






      //    System.out.println("Введите количество шагов: ");
      //    monthToData[month].dayData[day]=scanner.nextInt();