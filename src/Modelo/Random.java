/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Equipo1
 */
public class Random {
    
    public static int randomNumber(int limiteInferior, int limiteSuperior) {
        return (int) (Math.random() * (limiteSuperior - limiteInferior + 1) + limiteInferior);
    }
    
}
