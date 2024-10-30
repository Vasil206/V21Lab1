/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1.Food;

import com.mycompany.lab1.interfaces.IConsumable;
import com.mycompany.lab1.interfaces.INutritious;

/**
 *
 * @author Acer
 */
@SuppressWarnings("EqualsAndHashcode")
public abstract class Food implements IConsumable, INutritious {
    
    String name = null;
    
    public Food(String name) {
        this.name = name;
    }
    
    /**
     *
     * @param arg0
     * @return
     */
    @Override
    public boolean equals(Object arg0) {
        if (!(arg0 instanceof Food)) return false; // Шаг 1
        if (name == null || ((Food)arg0).name == null) return false; // Шаг 2
        return name.equals(((Food)arg0).name); // Шаг 3
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

}
