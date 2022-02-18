/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.inf1.crossyroads;

/**
 *
 * @author Johannes
 */
public class DoodException extends RuntimeException{

    /**
     * constructor voor de DoodException
     * @param msg de tekst die je in de console wilt schrijven.
     */
    public DoodException(String msg) {
        super(msg);
    }
    
    
}
