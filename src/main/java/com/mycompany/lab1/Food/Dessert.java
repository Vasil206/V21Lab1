/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1.Food;

/**
 *
 * @author Acer
 */
@SuppressWarnings("EqualsAndHashcode")
public class Dessert extends Food {

    private String component1;
    private String component2;
    
    
    public Dessert(String comp1, String comp2) {
        super("Dessert");
        
        component1 = comp1;
        component2 = comp2;
    }
    
    public String getComponent1(){
        return component1;
    }
    
    public void setComponent1(String comp1){
        component1 = comp1;
    }
    
    public String getComponent2(){
        return component2;
    }
    
    public void setComponent2(String comp2){
        component2 = comp2;
    }
    
    @Override
    public boolean equals(Object arg0){
        if(arg0 == null) return false;
        if(!(arg0 instanceof Dessert)) return false;
        return component1.equalsIgnoreCase(((Dessert)arg0).component1)&&
                component2.equalsIgnoreCase(((Dessert)arg0).component2);
    }
    
    @Override
    public String toString(){
        return super.toString() + " with " + component1 + " and " + component2;
    }
    
    @Override
    public void consume() {
        System.out.println(this + " consumed");
    }

    @Override
    public int calculateCalories() {
        return 700;
    }
    
}
