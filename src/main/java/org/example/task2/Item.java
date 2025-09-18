package org.example.task2;

public class Item {
    private final long id;
    private String name;
    private double price;

    public Item(long id, String name, double price) {
        this.id = id;
        setName(name);
        setPrice(price);
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name is empty");
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("price < 0");
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{id=" + id + ", price=" + price + ", name='" + name + "'}";
    }
}

