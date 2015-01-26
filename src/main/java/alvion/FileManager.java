package alvion;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mbondar on 1/26/2015.
 */
public class FileManager
{
    public String currentFolder;

    public FileManager(String initPath)
    {
        currentFolder = initPath;
    }


    public void Run() throws IOException {
        while (true)
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            String[] parsedInput = input.split(" ");

            if (parsedInput == null || parsedInput.length == 0 || parsedInput[0].toLowerCase() != "cd" || parsedInput[0].toLowerCase() != "dir" ||
                    parsedInput[0] != "exit")
            {
                String command = parsedInput[0];
                StringBuilder result = new StringBuilder();
                switch (command.toLowerCase())
                {
                    case "cd":
                        if (parsedInput.length < 2)
                        {
                            result.append("CD parameter is required!");
                        }
                        result.append(changeCurrentDir(parsedInput[1]));
                        break;

                    case "dir":
                        showFolderContent(currentFolder);
                        break;

                    case "exit":
                        break;

                    default:
                        result.append("Such command doesn't support");
                        break;
                }

                if (command.equals("exit"))
                {
                    break;
                }

                System.out.println(result.toString());
                result = new StringBuilder();

            }
        }
    }

    public String changeCurrentDir(String folderName)
    {
        String temp = null;
        if (folderName.equals(".."))
        {
           int indexOf = currentFolder.lastIndexOf("//");
            if (indexOf > 0)
            {
                temp = currentFolder.substring(0, indexOf);
            }
        }
        /*else if (currentFolder.lastIndexOf("//") == currentFolder.length() - 1)
        {
            temp = currentFolder + "//" + folderName;
        }*/
        else
        {
            temp = currentFolder + "//" +  folderName;
        }


        File file =  new File(temp);
        if (file.exists() && file.isDirectory())
        {
            currentFolder = temp;
            return currentFolder;
        }

        File path =  new File(folderName);
        if (path.exists() && path.isDirectory())
        {
            currentFolder = folderName;
            return currentFolder;
        }
        else
        {
            return folderName + " doesn't exist";
        }
    }

    public void showFolderContent(String path)
    {
        for (FileInfo file : getFiles(getFolderContent(path), false))
        {
            System.out.println(file.getName());
        }

        for (FileInfo file : getFiles(getFolderContent(path), true))
        {
            System.out.println(file.getName());
        }
    }

    private List<FileInfo> getFiles(List<FileInfo> files, boolean isFile)
    {
        if (files == null)
            return null;
        ArrayList<FileInfo> resultFiles = new ArrayList<FileInfo>();

        for (FileInfo fileInfo: files)
        {
            if (fileInfo.isFile == isFile)
                resultFiles.add(fileInfo);
        }
        Collections.sort(resultFiles);
        return resultFiles;
    }

    private List<FileInfo> getFolderContent(String path)
    {
        ArrayList<FileInfo> result = new ArrayList<FileInfo>();

        File file =  new File(path);
        if (!file.exists())
            return null;
        if (file.isFile())
            return null;

        if (file.isDirectory())
        {
            File[] files =  file.listFiles();

            for ( File item : files){

                FileInfo fileInfo = new FileInfo();
                fileInfo.name =  item.getName();
                fileInfo.size = item.getUsableSpace();
                fileInfo.isFile = item.isFile();
                result.add(fileInfo);
            }
        }

        return result;
    }

}