// Нам нужны библиотеки: Список
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

// Класс Защитники будет хранить список защитников (объектов)
public class Defenders {
    // Задаем список «Защитники» типа Защитник
    private ArrayList<Defender> defenders = new ArrayList<Defender>();

    // Конструктор пустой, задавать значения будем используя сеттеры
    public Defenders() {
    }

    // Функция для добавления в список нового работника
    public void add(Defender.Club club, String lastName, LocalDate birthDate, String amplua, int gamesNumber, String birthPlace) {
        // Создаем новый объект работника
        Defender defender = new Defender();
        // Задаем все необходимые значения
        defender.setLastName(lastName);
        defender.setBirthDate(birthDate);
        defender.setClub(club);
        defender.setAmplua(amplua);
        defender.setGamesNumber(gamesNumber);
        defender.setBirthPlace(birthPlace);
        // Добавляем защитника в список защитников
        defenders.add(defender);
    }

    // Функция для печати данных всех защитников, подходящих по критериям
    public void printSpecial() {
        // Создаем новый список для таких защитников
        ArrayList<Defender> specialDefenders = (ArrayList<Defender>) defenders
                // Используем «потоки» (stream) для сортировки
                .stream()
                // Метод фильтрации, в него передаем функцию с критериями
                .filter(q -> q.calculateAge() < 20 && q.getGamesNumber() > 40)
                // Собираем оставшиеся значения в список (метод collect)
                .collect(Collectors.toList());
        // Выводим вступительный текст
        System.out.println("Подходящие защитники: ");
        // Проходимся по всем элементам
        for (int i = 0; i < specialDefenders.size(); i++) {
            // Выводим значения всех полей для каждого
            System.out.println(defenders.get(i).getLastName()
                    + ", родившийся " + defenders.get(i).getBirthDate()
                    + ", состоявщий в клубе " + defenders.get(i).getClub()
                    + " с амплуа " + defenders.get(i).getAmplua()
                    + ", с количеством игр: " + defenders.get(i).getGamesNumber()
                    + ", родившийся в " + defenders.get(i).getBirthPlace());
        }
    }
}
