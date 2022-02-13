import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {

        //String[] arg = {"-d", "C:\\Users\\Bot19\\Desktop\\работа Uran", "-l", "50Mb"};

        ParametersBag bag = new ParametersBag(args);
        String path = bag.getPath(); //"C:\\Users\\Bot19\\Desktop\\работа Uran", C:\DIP
        File file = new File(path);
        long limit = bag.getLimit(); //50 * 1024 * 1024;

        long start = System.currentTimeMillis();

        Node root = new Node(file);
        root.setLimit(limit); //передаем лимит в корень
        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(calculator);
        System.out.println(root);
        System.out.println("Время выполнения - " + (System.currentTimeMillis() - start) + " мс");
    }

}
