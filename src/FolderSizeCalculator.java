import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderSizeCalculator extends RecursiveTask<Long> {

   private File folder;

   public FolderSizeCalculator(File folder) {
       this.folder = folder;
   }

    @Override
    protected Long compute() {

       if(folder.isFile()){
           return folder.length();
       }
        List<FolderSizeCalculator> subtasks = new LinkedList<>();
       long summ = 0;
       File[] files = folder.listFiles();

       for (File file : files) {
           FolderSizeCalculator task = new FolderSizeCalculator(file);
           task.fork();
           subtasks.add(task);
       }

       for (FolderSizeCalculator task : subtasks) {
           summ += task.join();
       }

       return summ;
    }
}
