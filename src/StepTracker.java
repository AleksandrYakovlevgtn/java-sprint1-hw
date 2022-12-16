
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

    void statistiсStepByDays(int monthINT) {
        for (int i = 0; i < monthToData.length; i++) {
            System.out.print((i + 1) + " день: " + monthToData[monthINT].days[i] + ", ");
        }
        System.out.println();
    }

    void sumStepInMonth(int monthINT) {
        int sumStepInMonth = 0;
        for (int i = 0; i < monthToData.length; i++) {
            sumStepInMonth = sumStepInMonth + monthToData[monthINT].days[i];
        }
        System.out.println("Общее количество шагов за " + months[monthINT - 1] + " составляет " + sumStepInMonth);
        converter.distanceInMonthKM(sumStepInMonth);
        System.out.println("Пройденная дистанция за " + months[monthINT - 1] + " составляет " + converter.distance + " км.");
        System.out.println("Количество сожжённых килокалорий за " + months[monthINT - 1] + " составляет " + converter.kKal + " .");
    }

    void maxStepInMonth(int monthINT) {
        double maxStep = 0;
        for (int i = 0; i < monthToData.length; i++) {
            if (monthToData[monthINT].days[i] > maxStep) {
                maxStep = monthToData[monthINT].days[i];
            }
        }
        System.out.println("Максимальное количество шагов за " + months[monthINT - 1] + ": " + maxStep);
    }

    void averageStepInMonth(int monthINT) {
        int averageStepInMonth = 0;
        int sum = 0;
        for (int i = 0; i < monthToData.length; i++) {
            sum += monthToData[monthINT].days[i];
        }
        averageStepInMonth = sum / monthToData.length;
        System.out.println("Среднее количество шагов за " + months[monthINT - 1] + " " + averageStepInMonth);
    }

    void seriesStep(int monthINT) {
        int longestSeries = 0;
        int longestSeriesDays = 0;
        for (int i = 0; i < monthToData.length; i++) {
            if (monthToData[monthINT].days[i] >= targetStep) {
                longestSeries++;

            } else if (longestSeries > longestSeriesDays) {
                longestSeriesDays = longestSeries;
                longestSeries = 0;
            }
        }
        System.out.println("Лучшая серия дней " + longestSeriesDays);
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
