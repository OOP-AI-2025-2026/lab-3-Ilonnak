package org.example.task2;

public class Order {
    private final long id;
    private final String customer;

    public Order(long id, String customer) {
        if (customer == null || customer.isBlank()) throw new IllegalArgumentException("empty customer");
        this.id = id;
        this.customer = customer;
    }

    public String formOrderBill(Cart cart) {
        StringBuilder b = new StringBuilder();
        b.append("Order number ").append(id).append(" for customer ").append(customer)
                .append("\n------------------\n");

        double sum = 0.0;
        for (int i = 0; i < cart.size(); i++) {
            Item it = cart.get(i);
            sum += it.getPrice();
            b.append("Item id: ").append(it.getId())
                    .append(" name: ").append(it.getName())
                    .append(" price: ").append(it.getPrice()).append("\n");
        }
        b.append("------------------\nTotal sum: ").append(sum);
        return b.toString();
    }
}
