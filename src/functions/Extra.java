package functions;

public class Extra {
    private String name;

    public String getName() {
        return name;
    }

    public Extra(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Extra) {
            return ((Extra) obj).getName().equals(name);
        }
        return false;
    }

    @Override
    public String toString(){
        return getName();
    }
}
