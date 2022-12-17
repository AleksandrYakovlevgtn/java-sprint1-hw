public class Converter {
    double km = 0.0075;
    double distance;
    double kKal;

    void distanceInMonthKM(double sumStepInMonth, int monthINT, String months[]) {
        distance = sumStepInMonth * km;
        System.out.println("Пройденная дистанция за " + months[monthINT] + " составляет " + distance + " км.");
    }
    void energySpent(double sumStepInMonth, int monthINT, String months[]) {
        kKal = (sumStepInMonth * 50) / 1_000;
        System.out.println("Количество сожжённых килокалорий за " + months[monthINT] + " составляет " + kKal + " .");
    }

}
