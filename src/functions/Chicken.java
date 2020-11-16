package functions;

import java.text.DecimalFormat;

public class Chicken extends Sandwich{

    public Extra[] ingredients = {new Extra("Fried Chicken"), new Extra("Spicy Sauce"),new Extra("Pickles")};

    @Override
    public double price() {
        DecimalFormat moneyFormat = new DecimalFormat("0.00");
        if (extras == null) return 8.99;
        return Double.parseDouble(moneyFormat.format(8.99 + extras.size()*PER_EXTRA));
    }

    @Override
    public String toString() {
        if (super.toString().isBlank()) {
            return "Chicken:" + getBasicIngredientsOrderDetails(ingredients);
        }
        return "Chicken:" + getBasicIngredientsOrderDetails(ingredients) + super.toString();
    }
}
