package functions;

import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 *Abstract class representing sandwiches
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
public abstract class Sandwich implements Customizable {
    static final int MAX_EXTRAS = 6;
    static final double PER_EXTRA = 1.99;
    protected ArrayList<Extra> extras;

    public abstract double price();

    public abstract String[] basicIng();

    /**
     * Returns a formatted string of sandwich ingredients separated by newlines
     * @return formatted string
     */
    public String getBasicIngredients(){
        String ingredientString = "";
        for(String e:basicIng()){
            ingredientString = ingredientString.concat(e + "\n");
        }
        return ingredientString;
    }

    /**
     * Returns a formatted string of sandwich ingredients separated by commas
     * @return formatted string
     */
    public String getBasicIngredientsOrderDetails(){
        String ingredientString = "";
        for(String e:basicIng()){
            ingredientString = ingredientString.concat(e + ", ");
        }
        return ingredientString;
    }

    /**
     * Returns string representation of Extra ingredients in sandwich
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder extrasString = new StringBuilder();
        extrasString.append("Extra: ");

        if(extras != null) {
            if(extras.isEmpty()){
                extrasString.append("None");
            }else {
                for (int i = 0; i < extras.size(); i++) {
                    if (i == extras.size() - 1) {
                        extrasString.append(extras.get(i).getName());
                    } else {
                        extrasString.append(extras.get(i).getName()).append(",");
                    }
                }
            }
        }else extrasString.append("None");
        return extrasString.toString();
    }

    /**
     * Adds an ingredient to the sandwich's extra ingredients
     * @param obj ingredient to be added
     * @return true for success, false for fail
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Extra) {
            if(extras == null)extras = new ArrayList<>();
            if (checkForSpace()) {
                if (!extras.contains(obj)) {
                    return extras.add((Extra) obj);
                }
            }
        }
        return false;
    }

    /**
     * Adds a list of ingredients to sandwich
     * @param list list of ingredients to add
     */
    public void addAll(ObservableList<Extra> list){
        for(Extra e:list){
            if(!add(e))return;
        }
    }

    /**
     * Checks if there is space to add one more ingredient
     * @return true if there is space, false otherwise
     */
    public boolean checkForSpace(){
        if(extras == null)return true;
        return extras.size() < MAX_EXTRAS;
    }

    /**
     * Checks if there's enough space to add a list of ingredients to sandwich
     * @param list input list
     * @param <T> type of list(Extra)
     * @return true if there is space, false otherwise
     */
    public<T> boolean checkForSpace(ObservableList<T> list){
        if(extras == null){
            return list.size() <= 6;
        }
        return extras.size() + list.size() <= MAX_EXTRAS;
    }

    /**
     * Removes an ingredient from the sandwich, if it exists
     * @param obj ingredient to remove
     * @return false if remove failed, true otherwise
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Extra) {
            if(extras == null) return false;
            return extras.remove(obj);
        }
        return false;
    }

    /**
     * Removes all the ingredients in a list from sandwich
     * @param list of ingredients to remove
     */
    public void removeAll(ObservableList<Extra> list){
        for(Extra e:list){
            if(!remove(e))return;
        }
    }

    /**
     * Clears the ingredients list
     */
    public void clear(){
        if(extras != null) {
            extras.clear();
        }
    }
}
