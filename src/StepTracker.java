
public class StepTracker {
    Converter converter = new Converter();
    MonthData[] monthToData;
    int targetStep = 10_000;
    String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};


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
            System.out.print((i + 1) + " день: " + monthToData[monthINT].days[i] + " ");
        }
        System.out.println();
    }

    void sumStepInMonth(int monthINT) {
        int sumStepInMonth = 0;
        for (int i = 0; i < 30; i++) {
            sumStepInMonth = sumStepInMonth + monthToData[monthINT].days[i];
        }
        System.out.println("Общее количество шагов за " + months[monthINT - 1] + " составляет " + sumStepInMonth);
        converter.distanciyInMonthKM(sumStepInMonth);
        System.out.println("Пройденная дистанция за " + months[monthINT - 1] + " составляет " + converter.distanciy + " км.");
        System.out.println("Количество сожжённых килокалорий за " + months[monthINT - 1] + " составляет " + converter.kKal + " .");
    }

    void maxStepInMonth(int monthINT) {
        double maxStep = 0;
        for (int i = 0; i < 30; i++) {
            if (monthToData[monthINT].days[i] > maxStep) {
                maxStep = monthToData[monthINT].days[i];
            }
        }
        System.out.println("Максимальное количество шагов за " + months[monthINT - 1] + ": " + maxStep);
    }

    void sredeeStepInMonth(int monthINT) {
        int sredeeStepInMonth = 0;
        int sum = 0;
        for (int i = 0; i < 30; i++) {
            sum += monthToData[monthINT].days[i];
        }
        sredeeStepInMonth = sum / 30;
        System.out.println("Среднее количество шагов за " + months[monthINT - 1] + " " + sredeeStepInMonth);
    }

    void seriyStep(int monthINT) {
        int longestSeriy = 0;
        int longestSeriyDays = 0;
        for (int i = 0; i < 30; i++) {
            if (monthToData[monthINT].days[i] >= targetStep) {
                longestSeriy++;

            } else if (longestSeriy > longestSeriyDays) {
                longestSeriyDays = longestSeriy;
                longestSeriy = 0;
            }
        }
        System.out.println("Лучшая серия дней " + longestSeriyDays);
    }
    void changeTargetStep(int newTargetStep) {
        while (true) {
            if (newTargetStep < 0) {
                System.out.println("Целевое количество шагов не может быть отрицательным, пожалуйста исправтесь !");
            } else {
                targetStep = newTargetStep;
                break;
            }
        }
    }
}
