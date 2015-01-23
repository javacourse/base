package alvion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        fileOperations();
    }
    
    public static void fileOperations(){
        FolderItem folder = new FolderItem("/home/elazarchuk");
        for(FileItem item: folder.getContent()){
            if(item.isDirectory()) System.out.print('[');
            System.out.print(item.getName());
            if(item.isDirectory()) System.out.print(']');
            System.out.println();
        }
    }
    
    public static void setSearch(){
        HashSet<String> test = new HashSet<>();
        test.add("Class");
        test.add("Class Collection");
        test.add("Collection");
        test.add("Classical");
        test.add("Classical Music");
        
        HashSet<String> filtered;
        filtered = HashSetHelper.stringFilter("ass", test);
        for(String item: filtered){
            System.out.println(item);
        }
        filtered.clear();
        System.out.println("---------------------------");
        
        filtered = HashSetHelper.abbrFilter("CM", test);
        for(String item: filtered){
            System.out.println(item);
        }
    }
    
    public static void translitirate() {
        Translitiration translitiration = new Translitiration();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите текст для транслитерации : ");
        String username = null;
        try {
            username = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(translitiration.translitirate(username));
        
        System.out.println();
    }

    String helloWorld() {
        return "Hello world!";
    }
}
