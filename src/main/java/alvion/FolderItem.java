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
        if(this.content.size() > 0){
            for(int i = 0; i < this.content.size() - 1 ; i++){
                
            }
        } else {
            this.content.add(file);
        }
    }
    
}
