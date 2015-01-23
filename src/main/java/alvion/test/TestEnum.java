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
public enum TestEnum {
    ADMIN(){public String toString(){return "Administrator";}},
    USER(){public String toString(){return "User";}},
    SUPER_ADMIN(){public String toString(){return "Super Admin";}};
    
}
