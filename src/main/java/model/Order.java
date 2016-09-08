package model;

import org.joda.time.DateTime;

public class Order {
    private DateTime moment;
    private Product product;
    private User user;
    private Place place;
    private int amount;
    private OrderState state;

    public Order(Product product, User user) {
        this(product, user, 1);
    }

    public Order(Product product, User user, int amount) {
        this.moment = DateTime.now();
        this.product = product;
        this.user = user;
        this.place = user.getPlace();
        this.amount = amount;
        this.state = new OrderStatePending(this);
    }

    public Order() {

    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void cook() {
        this.state.cook();
    }

    public void cancel() {
        this.state.cancel();
    }

    public boolean isCooked() {
        return this.state.isCooked();
    }

    public boolean isPending() {
        return this.state.isPending();
    }

    public boolean isCanceled() {
        return this.state.isCanceled();
    }
}
