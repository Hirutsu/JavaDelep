import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileFind{
    public File root;
    public Path path;
    public List filesInFolder;
    public HashMap<String, Integer> filesByChar;
    public HashMap<String, Integer> foldersByChar;

    public  FileFind(String path) throws IOException {
        root = new File(path);
        this.path = Paths.get(path);
        this.filesInFolder = Files.walk(this.path)
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());
        filesByChar = new HashMap<>();
        foldersByChar = new HashMap<>();

    }

    public List findByFileName(String fileName) throws IOException {
        List result = null;

        try (Stream pathStream = Files.find(this.path, Integer.MAX_VALUE,
                (p, basicFileAttributes) -> p.getFileName().toString().equalsIgnoreCase(fileName))
        ) {
            result = (List) pathStream.collect(Collectors.toList());
        }

        return result;
    }

    public void findMaxS() throws IOException {
        ArrayList<String> nameFiles = new ArrayList();
        for (int i=0; i<filesInFolder.size(); i++)
        {
            File filePath = (File) filesInFolder.get(i);
            String[] nameAndType = filePath.toString().split("\\\\");
            nameFiles.add(nameAndType[nameAndType.length-1]);
        }

        int tempMaxS = 0;
        int maxS = 0;
        File path = null;
        String file = "";
        for (int i=0; i<nameFiles.size(); i++) {
            tempMaxS =0;
            for(int j=0;j<nameFiles.get(i).length();j++){
                if (nameFiles.get(i).charAt(j) == 's'){
                    tempMaxS++;
                }
            }
            if(tempMaxS>=maxS){
                maxS = tempMaxS;
                path = (File) filesInFolder.get(i);
                file = nameFiles.get(i);
            }
        }

        if(path != null) {
            System.out.println("path:" + path);
            System.out.println("FileName:" + file);
        }
    }

    public void findMaxSizeFiles(){
        Comparator<File> comparator = new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return getFileSizeMegaBytes(o1).compareTo(getFileSizeMegaBytes(o2));
            }
        } ;

        filesInFolder.sort(comparator);

        for (int i=filesInFolder.size() - 5; i<filesInFolder.size();i++){
            System.out.println(filesInFolder.get(i) + ": " + getFileSizeMegaBytes((File) filesInFolder.get(i)) + " MB");
        }
    }

    public long getFolderSize() throws IOException {
        Path folder = this.path;
        long size = Files.walk(folder)
                .map(Path::toFile)
                .filter(File::isFile)
                .mapToLong(File::length)
                .sum();
        return size/(1024*1024);
    }

    private Double getFileSizeMegaBytes(File file) {
        return (double) file.length()/(1024*1024);
    }

    public void getCountFilesByFirstChars(String path){
        String abc = "ABCDEFGHIKLMNOPQRSTVXYZ";
        for (int i = 0; i < abc.length(); i++){
            filesByChar.put(String.valueOf(abc.charAt(i)), 0);
            foldersByChar.put(String.valueOf(abc.charAt(i)), 0);
            getCountFilesByChar(String.valueOf(abc.charAt(i)));
            System.out.println(abc.charAt(i) + ": Кол-во папок: " + foldersByChar.get(String.valueOf(abc.charAt(i))) +
                    " Кол-во файлов: " + filesByChar.get(String.valueOf(abc.charAt(i))));
            this.root = new File(path);
        }
    }

    public void getCountFilesByChar(String ch){
        File[] files = root.listFiles();
        int length = files.length;
        for (int i = 0; i < length; i++){
            String fname = files[i].getName().toLowerCase();
            if (fname.indexOf(ch.toLowerCase()) == 0 || fname.indexOf(ch.toUpperCase()) == 0)  {
                if (files[i].isDirectory()){
                    foldersByChar.put(ch.toUpperCase(), foldersByChar.get(ch.toUpperCase())+1);
                    root = files[i];
                    getCountFilesByChar(ch);
                }
                else {
                    filesByChar.put(ch.toUpperCase(), filesByChar.get(ch.toUpperCase())+1);
                }
            }
        }
    }
}