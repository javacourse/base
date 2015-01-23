/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alvion;

import java.io.File;

/**
 *
 * @author elazarchuk
 */
public class FileItem {
    private String location;
    private String name;
    private boolean isDirectory;
    private long size;

    public FileItem(String location, String name) {
        this.name = name;
        this.location = location;
        File file = new File(this._getFullPath());
        this.isDirectory = file.isDirectory();
        this.size = file.length();
    }
    
    public String getLocation(){
        return this.location;
    }
    
    public String getName(){
        return this.name;
    }
    
    public boolean isDirectory(){
        return this.isDirectory;
    }
    
    public long getSize(){
        return this.size;
    }
    
    public String getFullPath(){
        return this._getFullPath();
    }
    
    private String _getFullPath(){
        return this.location.concat("/".concat(this.name));
    }
}
