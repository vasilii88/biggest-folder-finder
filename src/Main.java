import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {

        String path = "C:\\Users\\Bot19\\Desktop\\работа Uran";
        File file = new File(path);
        int limit = 50 * 1024 * 1024;

        long start = System.currentTimeMillis();
                    /*System.out.println(getFolderSize(file));*/
        Node root = new Node(file, limit);
        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(calculator);
        System.out.println(root);
        System.out.println("Време выполнения - " + (System.currentTimeMillis() - start) + " мс");
    }

    public static long getFolderSize(File folder) {

        if (folder.isFile()) {
            return folder.length();
        }
        File [] files =  folder.listFiles();

           long summ = 0;
           for (File file : files) {
               summ += getFolderSize(file);
           }
           return summ;
        }

}
