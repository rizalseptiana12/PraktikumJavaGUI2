/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konversi;

/**
 *
 * @author KHM
 */
public class fahrenheit {
    public double toCalvin(double n){
        double k;
        k = (n + 456.67)/1.8;
        return k ;
    }public double toFahrenheit(double n){
        double k;
        k = n;
        return k ;
    }public double toCelcius(double n){
        double k;
        k = (n - 32)/1.8;
        return k ;
    }
    
}
