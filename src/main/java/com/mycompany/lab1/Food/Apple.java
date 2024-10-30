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
public class Apple extends Food {
    
    private String size;
    
    public Apple(String size) {
        // Вызвать конструктор предка, передав ему имя класса
        super("Apple");
        // Инициализировать размер яблока
        this.size = size;
    }
    // Переопределить способ употребления яблока
    @Override
    public void consume() {
        System.out.println(this + " consumed");
    }
    // Селектор для доступа к полю данных РАЗМЕР
    public String getSize() {
        return size;
    }
    // Модификатор для изменения поля данных РАЗМЕР
    public void setSize(String size) {
        this.size = size;
    }
    // Переопределѐнная версия метода equals(), которая при сравнении 
    // учитывает не только поле name (Шаг 1), но и проверяет совместимость 
    // типов (Шаг 2) и совпадение размеров (Шаг 3)
    @Override
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) { // Шаг 1
        if (!(arg0 instanceof Apple)) return false; // Шаг 2
            return size.equals(((Apple)arg0).size); // Шаг 3
        } else
            return false;
    }
    // Переопределѐнная версия метода toString(), возвращающая не только 
    // название продукта, но и его размер
    @Override
    public String toString() {
        return super.toString() + " of size " + size;
    }

    @Override
    public int calculateCalories() throws Exception {
        if(null == size) throw new Exception("bad apple size");
        else  
            return switch (size) {
            case "big" -> 400;
            case "medium" -> 300;
            case "small" -> 250;
            default -> throw new Exception("bad apple size");
        };
        
    }
}
