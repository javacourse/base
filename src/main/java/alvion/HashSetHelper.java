/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alvion;

import java.util.HashSet;

public class HashSetHelper{
    public static HashSet<String> stringFilter(String substring, HashSet<String> set){
        HashSet<String> result = new HashSet<>();
        for(String item: set){
            if(item.contains(substring)){
                result.add(item);
            }
        }
        return result;
    }
    
    public static HashSet<String> abbrFilter(String abbr, HashSet<String> set){
        HashSet<String> result = new HashSet<>();
        for(String item: set){
            boolean isMatched = true;
            String[] words = item.split(" ");
            if(abbr.length() == words.length){
                for(int i = 0; i < words.length; i++){
                    if(abbr.charAt(i) != words[i].charAt(0) ){
                        isMatched = false;
                        break;
                    }
                }
                if(isMatched){
                    result.add(item);
                }
            }
        }
        return result;
    }
}
