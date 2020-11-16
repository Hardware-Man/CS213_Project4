package functions;

import java.text.DecimalFormat;

public class Fish extends Sandwich {

    public Extra[] ingredients = {new Extra("Grilled Snapper"), new Extra("Cilantro"),new Extra("Lime")};

    @Override
    public double price() {
        DecimalFormat moneyFormat = new DecimalFormat("0.00");
        if (extras == null) return 12.99;
        return Double.parseDouble(moneyFormat.format(12.99 + extras.size()*PER_EXTRA));
    }

    @Override
    public String toString() {
        if (super.toString().isBlank()) {
            return "Fish:" + getBasicIngredientsOrderDetails(ingredients);
        }
        return "Fish:" + getBasicIngredientsOrderDetails(ingredients) + super.toString();
    }
}
