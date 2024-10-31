/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab1;

import com.mycompany.lab1.Food.Food;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Acer
 */
public class Lab1 {

    public static void main(String[] args) {
        try{
            // Определение ссылок на продукты завтрака
            Food[] breakfast = new Food[20];
             // Анализ аргументов командной строки и создание для них 
             // экземпляров соответствующих классов для завтрака
            int itemsSoFar = 0;
            for (String arg: args) {
                if(arg.startsWith("-")) continue;
                String[] parts = arg.split("/");
                
                //Reflection API construct an object
                String className = Food.class.getPackageName() + '.' + parts[0];
                Class clazz = Class.forName(className);
                
                Class[] parameterTypes = new Class[parts.length-1];
                for(int i=0;i + 1 < parts.length; i++)
                    parameterTypes[i] = parts[i + 1].getClass();
                
                var constructor = clazz.getConstructor(parameterTypes);
                
                var parameterValues = Arrays.stream(parts).skip(1).toArray(String[]::new);
                
                breakfast[itemsSoFar] = (Food)constructor.newInstance(parameterValues);
                //end of construction

                itemsSoFar++;
            }
            // Перебор всех элементов массива
            boolean isCalculatingCalories = Arrays.asList(args).contains("-calories");
            var calories = 0;
            for (Food item: breakfast) 
                if (item != null){
                    // Если элемент не null – употребить продукт
                    item.consume();
                    if(isCalculatingCalories)
                        calories += item.calculateCalories();
                }
                else
                    // Если дошли до элемента null – значит достигли конца
                    // списка продуктов, ведь 20 элементов в массиве было
                    // выделено с запасом, и они могут быть не 
                    // использованы все
                    break;
            
            //count of products
            System.out.println("count of different products:");
            Arrays.stream(breakfast).filter(x -> x != null).distinct().forEach(x ->
                    System.out.println(x.toString() + " : " +
                            Arrays.stream(breakfast).filter(y -> y != null && y.equals(x)).count()));

            if(isCalculatingCalories){
                System.out.println("All calories:" + calories);
            }
            
            //sotring products
            if(Arrays.asList(args).contains("-sort")){
                var comp = (Comparator<Food>) (Food food1, Food food2) -> {
                    try{
                        return food2.getClass().getConstructors()[0].getParameterCount() -
                                food1.getClass().getConstructors()[0].getParameterCount();
                    }
                    catch(Exception ex){
                        System.err.println(ex.getMessage());
                    }
                    return 0;
                };
                
                System.out.println();
                System.out.println("Products by components:");
                Arrays.stream(breakfast).filter(x -> x != null).sorted(comp)
                        .forEach(System.out::println);
            }
            
            System.out.println("Good luck!");
        }
        catch(ClassNotFoundException ex){
            System.err.println("class not found: " + ex.getLocalizedMessage());
        }
        catch(NoSuchMethodException ex){
            System.err.println("method not found: " + ex.getLocalizedMessage());
        }
        catch(Exception ex){
            System.err.print(ex.getMessage());
        }
    }
}
