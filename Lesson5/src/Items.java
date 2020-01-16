public class Items {

    public String name;
    public double weight;
    public double price;

    public Items (String _name, double _weigth, double _price) {
        this.name = _name;
        this.weight = _weigth;
        this.price = _price;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
