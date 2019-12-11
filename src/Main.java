import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите команду:\n" +
                "LIST - показывает список дел\n" +
                "ADD <номер> <дело> - добавляет дело в позицию <номер>\n" +
                "ADD <дело> - добавляет дело в конец списка\n" +
                "EDIT <номер> - заменяет дело с указанным номером <номер> на новое\n" +
                "DELETE <номер> - удаляет дело с указанным номером <номер>");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = null;
        ArrayList<String> list = new ArrayList<>();
        list.add("На Работу");
        list.add("На Учебу");
        list.add("Зайти в магазин");

        while (true) {
            try {
                System.out.print("ввод: ");
                command = reader.readLine(); //command = ADD 4 NA RABOTU
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] array = command.split(" ", 3);

            switch (array[0]) {
                case "LIST":
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(i+1 + " - " + list.get(i));
                    }
                    break;

                case "ADD":
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(array[1]);
                    boolean found = matcher.matches();
                    if (found) {
                        list.add(Integer.parseInt(array[1])-1, array[2]);
                    } else {
                        String add = (command.replace("ADD", "")).trim();
                        list.add(add);
                    }
                    break;

                case "EDIT":
                    int value = Integer.parseInt(array[1]);
                    String business = array[2];
                    list.set(value-1, business);
                    break;

                case "DELETE":
                    value = Integer.parseInt(array[1]);
                    list.remove(value-1);
                    break;

                default:
                    break;
            }
        }
    }
}




