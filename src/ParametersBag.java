import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ParametersBag {

    private String path;
    private String limit;

    public ParametersBag(String argm[]) {

        if (argm.length != 4) {
            throw new IllegalArgumentException("Ошибка_0_Не правильный формат команды." +
                    " Правильный формат: -d Путь до файла -l Размер файла");
        }

        if (!(argm[0].equals("-d") && argm[2].equals("-l")) && !(argm[0].equals("-l") && argm[2].equals("-d"))) {
            throw new IllegalArgumentException("Ошибка_1_Не правильный формат команды." +
                    " Правильный формат: -d Путь до файла -l Размер файла");
        }

        for (int i = 0; i < argm.length; i += 2) {
            if (argm[i].matches("-l")) {
                limit = argm[i+1];
            } else path = argm[i+1];
        }

        if (!Files.isDirectory(Path.of(path)) || !Files.exists(Path.of(path))) {
            throw new IllegalArgumentException("Ошибка_3_Не правильно задан путь");
        }

       if(!limit.matches("\\d+(b)?(Kb)?(Mb)?(T)?")){ // проверка на введение отрицательного значения в том числе
           throw new IllegalArgumentException("Не правильный формат лимита, Правильный формат [число][b,Mb,G,T]");
       }
    }


    public long getLimit() {

        return InputFormater.getLimitFromString(limit);
    }

    public String getPath() {
        return path;
    }
}
