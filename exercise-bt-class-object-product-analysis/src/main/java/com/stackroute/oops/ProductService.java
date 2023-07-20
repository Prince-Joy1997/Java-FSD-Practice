package com.stackroute.oops;

import java.util.Arrays;

/*
    Class for Analyzing the products present in ProductRepository
 */
public class ProductService {

    Product[] productsArray = ProductRepository.getProducts();

    /*
        Returns the name of the product given the productCode
     */
    public String findProductNameByCode(int productCode) {

        String result = "";

        if(productCode == 0){

            return null;
        }
        else {
        for( Product items:productsArray){
            if(items.getProductCode() == productCode) {
                result = items.getName();
                return result;
            }
        }
        return null;
        }
    }

    /*
        Returns the Product with maximum price in a given category
     */
    public Product findMaxPriceProductInCategory(String category) {

        Product max = null;
        for (Product items:productsArray){
            if(items.getCategory().equals(category)){
                if (max == null) {

                    max = items;
                }
                if (items.getPrice() > max.getPrice()){
                    max=items;
                }
            }
        }

        return max;

    }

    /*
        Returns a array of products for a given category
     */
    public Product[] getProductsByCategory(String category) {


        int i = 0, flag = 0;
        Product[] p = new Product[8];

        for (Product items:productsArray){
            if (items.getCategory().equals(category)){
                p[i] = items;
                i++;
                flag = 1;
            }
        }

        if (flag == 0){

            return null;
        }
        else {
            return Arrays.copyOf(p, i);
        }
    }
}
