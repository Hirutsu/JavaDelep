import java.util.List;

public class MyAppDiskAnalyzer {
    public static void main(String[] args) throws Exception {
        FileFind fileFind = new FileFind("G:\\YT&TT");

        List result = fileFind.findByFileName("google.psd");
        if(result.size() != 0){
            result.forEach(x -> System.out.println(x));
        }
        else{
            System.out.println("Файл не найден");
        }
        System.out.println();

        fileFind.findMaxS();
        System.out.println();

        fileFind.findMaxSizeFiles();
        System.out.println();

        System.out.println("Size directory: " + fileFind.getFolderSize() + " mb");
        System.out.println();

        fileFind.getCountFilesByFirstChars("G:\\GIT");
    }
}

