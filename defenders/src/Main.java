import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // Создаем список защитников
        Defenders defenders = new Defenders();
        // Добавляем защитников по одному
        defenders.add(Defender.Club.ARSENAL, "Кумиров", LocalDate.parse("2003-02-03"), "Крушитель", 53, "Мадрид");
        defenders.add(Defender.Club.BRENTFORD, "Попов", LocalDate.parse("1997-04-05"), "Деликатный", 30, "Киев");
        defenders.add(Defender.Club.BARSELONA, "Простов", LocalDate.parse("1996-08-12"), "Аккуратный", 20, "Мадрид");
        defenders.add(Defender.Club.ARSENAL, "Потрясов", LocalDate.parse("2005-01-06"), "Гроза", 62, "Париж");

        // Выводим информацию о тех, кто младше 20 и сыграл за команду более 40 раз
        defenders.printSpecial();
    }

}
