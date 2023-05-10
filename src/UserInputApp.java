import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserInputApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Введите данные в формате: Фамилия Имя Отчество
                дата рождения, номер телефона, пол латинской буквой m или f
                вводите данные через пробел, без знаков препинания""");
        String input = scanner.nextLine();
        String[] inputData = input.split(" ");


        try {
            if (inputData.length != 6) {
                throw new InputDataLengthException();
            }
            String surname = inputData[0];
            String name = inputData[1];
            String patronymic = inputData[2];
            String birthDate = inputData[3];
            int phoneNumber = Integer.parseInt(inputData[4]);
            String gender = inputData[5];

            if (!isValidDate(birthDate)) {
                throw new InvalidDateException();
            }

            if (!isValidGender(gender)) {
                throw new InvalidGenderException();
            }
            String fileName = inputData[0] + ".txt";
            try (FileWriter writer = new FileWriter(fileName, true)) {
                String data = inputData[0] + " " + inputData[1] + " " +
                              inputData[2] + " " + inputData[3] + " " +
                              inputData[4] + " " + inputData[5] + "\n";
                writer.write(data);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Фамилия: " + surname);
            System.out.println("Имя: " + name);
            System.out.println("Отчество: " + patronymic);
            System.out.println("Дата рождения: " + birthDate);
            System.out.println("Номер телефона: " + phoneNumber);
            System.out.println("Пол: " + gender);
        } catch (InputDataLengthException e) {
            System.out.println("Ошибка: введено неверное количество параметров");
        } catch (InvalidDateException e) {
            System.out.println("Ошибка: неверный формат даты. Должен быть формат dd.mm.yyyy");
        } catch (InvalidGenderException e) {
            System.out.println("Ошибка: неверный формат пола. Должно быть m или f");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат номера телефона. " +
                               "Должно быть целое число без знаков");
        }


    }

    private static boolean isValidDate(String date) {
        return date.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
    }

    private static boolean isValidGender(String gender) {
        return gender.equals("m") || gender.equals("f");
    }
}

class InputDataLengthException extends Exception {
}

class InvalidDateException extends Exception {
}

class InvalidGenderException extends Exception {
}
