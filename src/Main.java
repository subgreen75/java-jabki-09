import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        /**
         * Set / HashSet
         *
         * 1. Создание множества
         * Создайте HashSet<String>, добавьте 5 слов и выведите все элементы
         */
        System.out.println("1.1. Создание множества");
        HashSet<String> set = new HashSet<>(List.of("Собака", "Книга", "Камень", "Точка", "Java"));
        System.out.println(set);

        /**
         * 2. Проверка на наличие элемента
         * Проверьте, содержится ли слово "java" в множестве
         */
        System.out.println("1.2. Проверьте, содержится ли слово \"java\" в множестве");
        System.out.printf("Слово \"java\" в множестве %s %s\n", set, set.contains("java") ? "содержится" : "не содержится");

        /**
         * 3. Удаление элемента
         * Удалите слово "python" из множества (если оно есть)
         */
        System.out.println("1.3. Удалите слово \"python\" из множества (если оно есть)");
        set.add("python");
        System.out.printf("Список до удаления %s\n", set);
        set.remove("python");
        System.out.printf("Список после удаления %s\n", set);

        /**
         * 4. Подсчёт уникальных
         * Дан список строк с повторами. Добавьте их в HashSet и выведите количество уникальных слов
         */
        System.out.println("1.4. Дан список строк с повторами. Добавьте их в HashSet и выведите количество уникальных слов");
        List<String> monthList = new ArrayList<>(List.of("Январь", "Февраль", "Март", "Март", "Март"));
        //преобразуем список в HashSet
        HashSet<String> monthSet = new HashSet<>(monthList);
        System.out.printf("Список (с повторами): %s\n", monthList);
        System.out.printf("HashSet (уникальные значения): %s\n", monthSet);
        Integer countUnique = 0;
        for (String month : monthSet) {
            long count = monthList.stream()
                    .filter(s -> s.equals(month))
                    .count();
            if (count == 1) {
                countUnique++;
            }
        }
        System.out.printf("Список (количество уникальных значений): %s\n", countUnique);

        /**
         * Map / HashMap
         * 1. Создание и вывод Map
         * Создайте HashMap<String, Integer> с названиями предметов и оценками. Выведите все пары ключ-значение
         */
        System.out.println("2.1. Создайте HashMap<String, Integer> с названиями предметов и оценками. Выведите все пары ключ-значение");
        HashMap<String, Integer> schoolSubjects = new HashMap<>();
        schoolSubjects.put("Math", 5);
        schoolSubjects.put("English", 4);
        schoolSubjects.put("Chemistry", 3);
        schoolSubjects.put("History", 4);
        schoolSubjects.put("Physics", 4);

        System.out.printf("Оценки: %s\n", schoolSubjects);
        for (Map.Entry<String, Integer> entry : schoolSubjects.entrySet()) {
            System.out.printf("Предмет: %s, Оценка: %s\n", entry.getKey(), entry.getValue());
        }

        /**
         * 2. Получение значения по ключу
         * Выведите значение по ключу "Math"
         */
        System.out.println("2.2. Выведите значение по ключу \"Math\"");
        System.out.printf("Предмет: %s, Оценка: %s\n", "Math", schoolSubjects.get("Math"));

        /**
         * 3. Изменение значения
         * Измените значение по ключу "English" на 5
         */
        System.out.println("2.3. Измените значение по ключу \"English\" на 5");
        if (schoolSubjects.containsKey("English")) {
            schoolSubjects.put("English", 5);
        }
        System.out.printf("Оценки: %s\n", schoolSubjects);

        /**
         * 4. Проверка наличия ключа
         * Проверьте, есть ли в мапе ключ "History"
         */
        System.out.println("2.4. Проверьте, есть ли в мапе ключ \"History\"");
        String subject = "History";
        System.out.printf("%s в мапе %s %s\n", subject, schoolSubjects, schoolSubjects.containsKey(subject) ? "содержится" : "не содержится");

        /**
         * 5. Удаление ключа
         * Удалите ключ "Physics" из мапы
         */
        System.out.println("2.5. Удалите ключ \"Physics\" из мапы");
        System.out.printf("Оценки до удаления: %s\n", schoolSubjects);
        schoolSubjects.remove("Physics");
        System.out.printf("Оценки после удаления: %s\n", schoolSubjects);

        /**
         * Medium
         * 1. Анаграммы
         * Напишите метод areAnagrams(String a, String b), который возвращает true, если строки состоят из одинаковых символов (используйте Map<Character, Integer>).
         */
        System.out.println("3.1. Анаграммы");
        String firstString = "йцукен некуцй";
        String secondString = "некуцй йцукен";
        System.out.printf("Строка 1: %s , Мап 1: %s\n", firstString, getStringToCharMap(firstString));
        System.out.printf("Строка 2: %s , Мап 2: %s\n", secondString, getStringToCharMap(secondString));
        System.out.printf("Содержатся одинаковые символы %s\n", areAnagrams(firstString, secondString) ? "да" : "нет");

        /**
         * 2. Поиск дубликатов с помощью Set
         * Напишите метод hasDuplicates(List<Integer> list) — возвращает true, если в списке есть дубликаты
         */
        System.out.println("3.2. Поиск дубликатов с помощью Set");
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1));
        System.out.printf("В списке %s дубликаты %s\n", list, hasDuplicates(list) ? "есть" : "нет");

        /**
         * 3. Рейтинг студентов
         * Дан Map<String, Integer> (имя студента → балл). Верните имя студента с максимальным баллом
         */
        System.out.println("3.3. Рейтинг студентов");
        Map<String, Integer> students = new HashMap<>();
        students.put("Иванов", 1);
        students.put("Петров", 2);
        students.put("Сидоров", 3);
        students.put("Сидорова", 3);
        Integer maxBall = Collections.max(students.values());
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            if (entry.getValue() == maxBall) {
                System.out.printf("Максимальный балл: %s, у студента: %s\n", maxBall, entry.getKey());
            }
        }

        /**
         * 4. Словарь синонимов
         * Создайте Map<String, Set<String>> — ключ: слово, значение: набор синонимов. Реализуйте метод addSynonym(String word, String synonym)
         */
        System.out.println("3.4. Словарь синонимов");
        Map<String, Set<String>> synonyms = new HashMap<>();
        //заполним первоначальными значениями
        synonyms.put("Встреча", new HashSet<>(List.of("Форум", "Свидание", "Знакомство", "Рандеву", "Совещание")));
        synonyms.put("Взгляд", new HashSet<>(List.of("Взор", "Глаз", "Зрение")));
        //выведем на экран словарь
        displaySynonyms(synonyms);
        //добавим слово
        addSynonym(synonyms, "Взгляд", "Точка зрения");
        addSynonym(synonyms, "Глаз", "Око");
        addSynonym(synonyms, "Глаз", "Взор");
        addSynonym(synonyms, "Напиток", "Квас");
        //выведем на экран словарь
        displaySynonyms(synonyms);
    }

    //возвращает true, если строки состоят из одинаковых символов
    public static boolean areAnagrams(String firstString, String secondString) {
        Map<Character, Integer> firstMap = new HashMap<>();
        Map<Character, Integer> secondMap = new HashMap<>();
        //преобразуем обе строки в мап
        firstMap = getStringToCharMap(firstString);
        secondMap = getStringToCharMap(secondString);
        //сравним ключи (символы в первой и второй строке)
        return firstMap.equals(secondMap);
    }

    // преобразует строку (input) в мап <Character, Integer>
    public static Map<Character, Integer> getStringToCharMap(String input) {
        Map<Character, Integer> map = new HashMap<>();
        char symbol;
        for (int i = 0; i < input.length(); i++) {
            symbol = input.toUpperCase().charAt(i);
            if (map.containsKey(symbol)) {
                map.put(symbol, map.get(symbol) + 1);
            } else {
                map.put(symbol, 1);
            }
        }
        return map;
    }

    //возвращает true, если в списке list есть дубликаты
    public static boolean hasDuplicates(List<Integer> list) {
        //преобразуем список в HashSet
        HashSet<Integer> hashSet = new HashSet<>(list);
        //сравним размер списка и HashSet
        return hashSet.size() != list.size();
    }

    //добавлет synonym в мап synonyms по ключу word
    public static void addSynonym(Map<String, Set<String>> synonymsMap, String word, String synonym) {
        Set<String> set = synonymsMap.get(word);
        if (set == null) {
            set = new HashSet<>(List.of(synonym));
        } else {
            set.add(synonym);
        }
        synonymsMap.put(word, set);
    }

    //выводит на экрапн список синонимов по мапу
    public static void displaySynonyms(Map<String, Set<String>> synonymsMap) {
        System.out.println("Словарь синонимов:");
        for (Map.Entry<String, Set<String>> entry : synonymsMap.entrySet()) {
            System.out.printf("Слово: %s, Список синонимов: %s\n", entry.getKey(), entry.getValue());
        }
    }
}