package functions;

import java.text.DecimalFormat;

public class Beef extends Sandwich {

    public Extra[] ingredients = {new Extra("Roast Beef"), new Extra("Provolone Cheese"),new Extra("Mustard")};

    @Override
    public double price() {
        DecimalFormat moneyFormat = new DecimalFormat("0.00");
        if (extras == null) return 10.99;
        return Double.parseDouble(moneyFormat.format(10.99 + extras.size()*PER_EXTRA));
    }

    @Override
    public String toString() {
        if (super.toString().isBlank()) {
            return "Beef:" + getBasicIngredientsOrderDetails(ingredients);
        }
        return "Beef:" + getBasicIngredientsOrderDetails(ingredients) + super.toString();
    }
}
