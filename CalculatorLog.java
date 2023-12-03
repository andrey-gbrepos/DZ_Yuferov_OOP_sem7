import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Для работы с файлом
 */
public class CalculatorLog {
 String line;
 File logFile;
 Path filePath;
 FileWriter writer;


 public CalculatorLog(){
    line = "";
    filePath = Path.of("log.txt");
    this.logFile = new File(filePath.toString());
 }

/**
 * Записывает строку в файл
 * @param result
 */
 public void writeTofile(String result){
   try {
    if (logFile.createNewFile()) {
        writer = new FileWriter(logFile, true);
        writer.append("\n"+result);
        writer.flush();
    }
    else {
        writer = new FileWriter(logFile, true);
        writer.append("\n"+result);
        writer.flush();
    }
} catch (Exception e) {
 //e.printStackTrace();
} finally {
 System.out.println(line);
    }
}

/**
 * Возвращает содержимое файла в список
 * @return
 * @throws IOException
 */
public List <String> readFromfile() throws IOException{
    List<String> lines = Files.readAllLines(filePath);
    return lines;
}

}
