package functions;

import java.text.DecimalFormat;

/**
 *Class representing chicken sandwiches
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
public class Chicken extends Sandwich{

    public Extra[] ingredients = {new Extra("Fried Chicken"), new Extra("Spicy Sauce"),new Extra("Pickles")};

    /**
     * Calculates and returns price
     * @return price
     */
    @Override
    public double price() {
        DecimalFormat moneyFormat = new DecimalFormat("0.00");
        if (extras == null) return 8.99;
        return Double.parseDouble(moneyFormat.format(8.99 + extras.size()*PER_EXTRA));
    }

    /**
     * Returns string representation of sandwich and ingredients
     * @return String
     */
    @Override
    public String toString() {
        if (super.toString().isBlank()) {
            return "Chicken:" + getBasicIngredientsOrderDetails(ingredients);
        }
        return "Chicken:" + getBasicIngredientsOrderDetails(ingredients) + super.toString();
    }
}
