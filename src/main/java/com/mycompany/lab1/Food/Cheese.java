/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1.Food;

/**
 *
 * @author Acer
 */
public class Cheese extends Food {
    public Cheese() {
        super("Cheese");
    }
    
    @Override
    public void consume() {
        System.out.println(this + " consumed");
    }

    @Override
    public int calculateCalories() {
        return 250;
    }
}
