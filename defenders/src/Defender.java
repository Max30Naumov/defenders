import java.time.LocalDate;
import java.time.Period;

public class Defender {
    // Конструктор, не принимает значений
    public Defender() {
    }

    // Поля (всегда должны быть приватными)
    private String lastName; // Фамилия
    private LocalDate birthDate;
    private Club club; // Клуб, типа enum (выбор из списка допустимых значений)

    // Список допустимых значений для клуба
    enum Club {
        BARSELONA,
        REAL_MADRID,
        CHELSEA,
        BRENTFORD,
        ARSENAL,
    }

    private String amplua; // Амплуа
    private int gamesNumber; // Количество игр
    private String birthPlace; // Место рождения

    // Сеттер (для изменения приватных полей)
    public void setClub(Club club) {
        this.club = club;
    }

    // Если метод может выбросить исключение, обязательно использовать throws с типом исключения
    public void setLastName(String lastName) throws IllegalArgumentException {
        // Проверка фамилии на содержание символов помимо букв и пробелов
        if (!lastName.matches("[A-Za-zА-Яа-я\\s]*"))
            // Если содержит, то кидаем исключение (и прекращаем работу)
            throw new IllegalArgumentException("Фамилия должна содержать только латинские или кириллические буквы и пробелы");
        // Если исключение не было выброшено, то присваиваем значение
        this.lastName = lastName;
    }

    // Аналогичный сеттер для дня рождения
    public void setBirthDate(LocalDate birthDate) throws IllegalArgumentException {
        this.birthDate = birthDate;
    }

    public void setAmplua(String amplua) { // Сеттер для амплуа
        this.amplua = amplua;
    }

    public void setGamesNumber(int gamesNumber) { // Сеттер для количества игр
        // Допустимые значения: >= 0, инвертируем условие, если не совпадает -- выбрасываем исключение
        if (gamesNumber <= 0)
            throw new IllegalArgumentException("Введено некорректное количество игр");
        this.gamesNumber = gamesNumber;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    // Геттеры
    public String getLastName() {
        return lastName;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public Club getClub() {
        return club;
    }
    public String getAmplua() {
        return amplua;
    }
    public int getGamesNumber() {
        return gamesNumber;
    }
    public String getBirthPlace() {
        return birthPlace;
    }
    public int calculateAge() {
        LocalDate currentDate = LocalDate.now();
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

}
