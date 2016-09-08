package model;

public class OrderStatePending extends OrderState {


    public OrderStatePending(Order order) {
        super(order);
    }

    @Override
    public boolean isPending() {
        return true;
    }

    @Override
    public boolean isCooked() {
        return false;
    }

    @Override
    public boolean isCanceled() {
        return false;
    }

    @Override
    public void cook() {
        this.order.setState(new OrderStateCooked(this.order));
    }

    @Override
    public void cancel() {
        this.order.setState(new OrderStateCanceled(this.order));
    }
}