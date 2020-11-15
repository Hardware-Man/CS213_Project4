package functions;

public class Fish extends Sandwich {

    private Extra[] ingredients = {new Extra("Grilled Snapper"), new Extra("Cilantro"),new Extra("Lime")};

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
        return 12.99 + extras.size()*PER_EXTRA;
    }

    @Override
    public String toString() {
        if (super.toString().isBlank()) {
            return "Fish";
        }
        return "Fish," + super.toString();
    }
}
