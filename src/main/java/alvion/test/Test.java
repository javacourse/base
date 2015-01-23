/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alvion.test;

import java.util.Locale;

/**
 *
 * @author elazarchuk
 */
public class Test {
    public static final String NAME = "Eugene";
    
    public static void main(String[] args){
        Integer a = 10;
        System.out.println(a.compareTo(-10));
        for(TestEnum item : TestEnum.values()){
            System.out.println(item);
        }
    }
            
}
