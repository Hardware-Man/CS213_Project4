package functions;

public class Chicken extends Sandwich{

    private Extra[] ingredients = {new Extra("Fried Chicken"), new Extra("Spicy Sauce"),new Extra("Pickles")};


    public String getBasicIngredients(){
        String ingredientString = "";
        for(Extra e:ingredients){
            ingredientString = ingredientString.concat(e.getName() + "\n");
        }
        return ingredientString;
    }

    @Override
    public double price() {
        if (extras == null) return 12.99;
        return 8.99 + extras.size()*PER_EXTRA;
    }

    @Override
    public String toString() {
        if (super.toString().isBlank()) {
            return "Chicken";
        }
        return "Chicken," + super.toString();
    }
}
