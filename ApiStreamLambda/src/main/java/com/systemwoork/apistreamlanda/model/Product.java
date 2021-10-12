/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.systemwoork.apistreamlanda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Eduardo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    
    private Integer id;
    private String name;
    private Double price;
}
