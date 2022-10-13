import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {

        /* Пример для ввода
        String[] arg = {"-d", "C:\\Users\\Bot19\\Desktop, "-l", "10Mb"};*/

        Scanner scanner = new Scanner(System.in);

        for (; ; ) {
            try {
                System.out.println("Введите команду в формате: -d <Путь до файла> -l <Размер файла>, или 0 для того чтобы завершить программу:");
                String input = scanner.nextLine();

                if (input.equals("0")) {
                    break;
                }

                String[] arg = input.split(" ");

                ParametersBag bag = new ParametersBag(arg);
                String path = bag.getPath();
                File file = new File(path);
                long limit = bag.getLimit();

                long start = System.currentTimeMillis();

                Node root = new Node(file);
                root.setLimit(limit);
                FolderSizeCalculator calculator = new FolderSizeCalculator(root);
                ForkJoinPool pool = new ForkJoinPool();
                pool.invoke(calculator);
                System.out.println(root);
                System.out.println("Время выполнения - " + (System.currentTimeMillis() - start) + " мс");
            } catch (IllegalArgumentException exception) {
                exception.printStackTrace();
            }
        }
    }
}
