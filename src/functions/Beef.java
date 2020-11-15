package functions;

public class Beef extends Sandwich {

    private Extra[] ingredients = {new Extra("Roast Beef"), new Extra("Provolone Cheese"),new Extra("Mustard")};

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
        return 10.99 + extras.size()*PER_EXTRA;
    }

    @Override
    public String toString() {
        if (super.toString().isBlank()) {
            return "Beef";
        }
        return "Beef," + super.toString();
    }
}
