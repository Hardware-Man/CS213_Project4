package functions;

import java.text.DecimalFormat;
/**
 *Class representing fish sandwiches
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
public class Fish extends Sandwich {

    public Extra[] ingredients = {new Extra("Grilled Snapper"), new Extra("Cilantro"),new Extra("Lime")};

    /**
     * Calculates and returns price
     * @return price
     */
    @Override
    public double price() {
        DecimalFormat moneyFormat = new DecimalFormat("0.00");
        if (extras == null) return 12.99;
        return Double.parseDouble(moneyFormat.format(12.99 + extras.size()*PER_EXTRA));
    }

    /**
     * Returns string representation of sandwich and ingredients
     * @return String
     */
    @Override
    public String toString() {
        if (super.toString().isBlank()) {
            return "Fish:" + getBasicIngredientsOrderDetails(ingredients);
        }
        return "Fish:" + getBasicIngredientsOrderDetails(ingredients) + super.toString();
    }
}
