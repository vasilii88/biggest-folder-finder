import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {

        String path = "C:\\Users\\Bot19\\Desktop";
        File file = new File(path);

        long start = System.currentTimeMillis();


            /*System.out.println(getFolderSize(file));*/
        FolderSizeCalculator calculator = new FolderSizeCalculator(file);
        ForkJoinPool pool = new ForkJoinPool();
        long size = pool.invoke(calculator);
        System.out.println(size);
        System.out.println((System.currentTimeMillis() - start) + " мс");
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
