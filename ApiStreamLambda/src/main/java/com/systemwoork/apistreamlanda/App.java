/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systemwoork.apistreamlanda;

import com.systemwoork.apistreamlanda.model.Person;
import com.systemwoork.apistreamlanda.model.Product;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Eduardo
 */
public class App {
    
    public static void main(String[] args) {
        
        Person p1 = new Person(1,"Luis", LocalDate.of(1993,1,16));
        Person p2 = new Person(2,"Eduardo", LocalDate.of(1993,1,17));
        Person p3 = new Person(3,"Antonio", LocalDate.of(1990,3,24));
        Person p4 = new Person(4,"David", LocalDate.of(2005,5,4));
        Person p5 = new Person(5,"Dulce", LocalDate.of(2016,6,25));
        
        Product pr1 = new Product(1, "Pescado", 40.0);
        Product pr2 = new Product(2, "Pollo", 35.0);
        Product pr3 = new Product(3, "Cabiar", 60.0);
        Product pr4 = new Product(4, "Carne de Res", 70.0);
        Product pr5 = new Product(5, "Frijoles", 20.0);
        
        List<Person> persons = Arrays.asList(p1,p2,p3,p4,p5);
        List<Product> products = Arrays.asList(pr1,pr2,pr3,pr4,pr5);
        
        
        // Lambda (method reference)
        // list.forEach(System.out::println);
        // for (int i = 0; i < persons.size(); i++){
        //     System.out.println(persons.get(i));
        // }
        
        
        // Cuando tengo una expresión de estas caracteristicas
        // donde el parametro de la izquierda y el parametro
        // de la derecha sean el mismo.
        // persons.forEach(p -> System.out.println(p));
        // persons.forEach(p -> System.out.println(p.getName()));
        
        // Se puede reescribir de esta manera.
        // Esto es una forma que se llama metodos a referencia
        // Se utiliza mucho cuando estás trabajando en la
        // programación funcional o también en algunas librerias
        // que nos permiten generar programación reactiva.
        persons.forEach(System.out::println);
        
        // Otros ejemplos
        // Imagina que tienes una lógica y utilizas un sevicio.
        // persons.forEach(x -> service.registrar(x));
        // Sobreescribimos para simplificar mejor.
        // persons.forEach(service::registrar);
        
        
        // 1.- Filter (param: Predicate)
        // Imaginemos que queremos traer a las personas > 18 años.
        // Forma imperactiva
        
        // for(Person p: persons){
        //     if(p.edad() > 18)
        // } 
       
        // Forma declarativa.
        // El .stream() es una forma de trabajar más declarativa
        // de una forma muy amena con las coleciones y poder
        // operar en ello.
        List<Person> filteredList = persons.stream()
                                            .filter(p -> App.getAge(p.getBirthDate()) >= 18)
                                            .collect(Collectors.toList());
        
        // App.printList(filteredList);
        
        
        // 2.- Map (param: Function)
        // List<Integer> filteredListInt = persons.stream()
        //                                     .map(p->App.getAge(p.getBirthDate()))
        //                                     .collect(Collectors.toList());
        List<Integer> filteredListInt = persons.stream()
                                            .filter(p -> App.getAge(p.getBirthDate()) >= 18)
                                            .map(p->App.getAge(p.getBirthDate()))
                                            .collect(Collectors.toList());
        App.printList(filteredListInt);
        
        // 3.- Sorted (param: Predicate)
        
    }
    
    public static int getAge(LocalDate birthDate){
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
    
    public static void printList(List<?> list){
        list.forEach(System.out::println);
    }
}
