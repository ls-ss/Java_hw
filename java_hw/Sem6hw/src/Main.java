/*  Урок 6. Сдавать код на гитхабе, само задание - здесь https://pastebin.com/ns2gM2Py
    Определить класс Reader, хранящий такую информацию о пользователе библиотеки:
    1. ФИО,
    2. номер читательского билета,
    3. факультет,
    4. дата рождения,
    5. телефон.
    6. Методы (экземпляра, без слова static) takeBook(), returnBook().
    7. Разработать программу, в которой создается массив объектов данного класса.
    8. Перегрузить методы takeBook(), returnBook():
    9. takeBook, который будет принимать количество взятых книг. Выводит на консоль сообщение "Петров В. В. взял 3 книги".
    10. takeBook, который будет принимать переменное количество названий книг. Выводит на консоль сообщение
        "Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".
    11. takeBook, который будет принимать переменное количество (Тип... parameterName) объектов класса Book
        (создать новый класс, содержащий имя и автора книги).
        Выводит на консоль сообщение "Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".
    12. Аналогичным образом перегрузить метод returnBook(). Выводит на консоль сообщение "Петров В. В. вернул книги:
        Приключения, Словарь, Энциклопедия". Или "Петров В. В. вернул 3 книги".
 */

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Reader reader1 = new Reader("Иванов И.И.", 1024, "Экономический",
                "01/11/2001", "+7(911)111-11-11");
        Reader reader2 = new Reader("Петров П.П.", 2024, "Юридический  ",
                "02/12/1999", "+7(912)222-22-22");
        Reader reader3 = new Reader("Егоров Е.Е.", 3007, "Психологии   ",
                "03/10/2002", "+7(913)333-33-33");
        Reader reader4 = new Reader("Глебов Г.Г.", 2101, "Исторический ",
                "04/09/2003", "+7(914)444-44-44");
        Reader reader5 = new Reader("Ефимов Е.Е.", 1048, "Экономичесий ",
                "05/01/2002", "+7(915)555-55-55");

        Book book1 = new Book("Война и Мир", "Толстой Л.Н.");
        Book book2 = new Book("Тарас Бульба", "Гоголь Н.В.");
        Book book3 = new Book("Евгений Онегин", "Пушкин А.С.");

        Reader[] readers = new Reader[]{reader1, reader2, reader3, reader4, reader5};

        for (Reader reader : readers) {
            reader.getAllReaderInformation();
        }
        System.out.println();

        System.out.println(Arrays.toString(readers));
        System.out.println();

        reader1.takeBook(4);
        reader2.takeBook(book1);
        reader3.takeBook(book2, book3);
        reader4.takeBook(book3, book2, new Book("Двенадцать", "Блок А.А."));
        System.out.println();

        reader5.returnBook(2);
        reader4.returnBook(book2);
        reader1.returnBook(book3, book1);
        reader5.returnBook(book2, book3, new Book("Стихи", "Барто А."));
    }
}