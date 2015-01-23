/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alvion;

import java.util.ArrayList;
import java.io.File;

/**
 *
 * @author elazarchuk
 */
public class FolderItem {
    private String path;
    private ArrayList<FileItem> content;
    
    public FolderItem(String path){
        this._setPath(path);
    }

    public String getPath(){
        return this.path;
    }
    
    public void setPath(String path){
        _setPath(path);
    }
    
    private void _setPath(String path){
        this.path = path;
        this._setContent();
    }
    
    public ArrayList<FileItem> getContent(){
        return this.content;
    }
    
    private void _setContent(){
        this.content = new ArrayList<>();
        File file = new File(this.path);
        for (String item :file.list()){
            this._addToContent(new FileItem(this.path,item));
        }
    }
    
    private void _addToContent(FileItem file){
        boolean isAdded = false;
        
        for(int i = 0; i < this.content.size(); i++){
            if(!this._isGreater(file, this.content.get(i))){
                this.content.add(i, file);
                isAdded = true;
                break;
            }
        }
        
        if(!isAdded){
            this.content.add(file);
        }
    }
    
    private boolean _isGreater(FileItem first, FileItem second){
        if(first.isDirectory() && !second.isDirectory()){
            return false;
        }
        
        if(!first.isDirectory() && second.isDirectory()){
            return true;
        }
        
        return first.getName().compareTo(second.getName()) >= 0;
    }
    
}
