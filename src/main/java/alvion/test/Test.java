/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alvion.test;

/**
 *
 * @author elazarchuk
 */
public class Test {
    public static final String NAME = "Eugene";
    
    public static void main(String[] args){
        for(TestEnum item : TestEnum.values()){
            System.out.println(item);
        }
    }
            
}
