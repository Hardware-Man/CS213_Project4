package functions;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public abstract class Sandwich implements Customizable {
    static final int MAX_EXTRAS = 6;
    static final double PER_EXTRA = 1.99;
    protected ArrayList<Extra> extras;

    public abstract double price();

    public String getBasicIngredients(Extra[] ingredients){
        String ingredientString = "";
        for(Extra e:ingredients){
            ingredientString = ingredientString.concat(e.getName() + "\n");
        }
        return ingredientString;
    }

    public String getBasicIngredientsOrderDetails(Extra[] ingredients){
        String ingredientString = "";
        for(Extra e:ingredients){
            ingredientString = ingredientString.concat(e.getName() + ", ");
        }
        return ingredientString;
    }

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

    public<Extra> void addAll(ObservableList<Extra> list){
        for(Extra e:list){
            if(!add(e))return;
        }
    }

    public boolean checkForSpace(){
        if(extras == null)return true;
        if (extras.size() < MAX_EXTRAS) {
            return true;
        }
        return false;
    }

    public<T> boolean checkForSpace(ObservableList<T> list){
        if(extras == null){
            if(list.size() <= 6) {
                return true;
            } else return false;
        }
        if(extras.size() + list.size() > MAX_EXTRAS){
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Extra) {
            if(extras == null) return false;
            return extras.remove(obj);
        }
        return false;
    }

    public<Extra> void removeAll(ObservableList<Extra> list){
        for(Extra e:list){
            if(!remove(e))return;
        }
    }

    public void clear(){
        if(extras != null) {
            extras.clear();
        }
    }
}
