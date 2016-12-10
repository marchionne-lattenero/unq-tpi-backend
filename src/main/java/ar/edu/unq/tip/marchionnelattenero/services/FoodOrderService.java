package ar.edu.unq.tip.marchionnelattenero.services;

import ar.edu.unq.tip.marchionnelattenero.models.*;
import ar.edu.unq.tip.marchionnelattenero.repositories.FoodOrderRepository;
import ar.edu.unq.tip.marchionnelattenero.repositories.ProductRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service("foodOrderService")
public class FoodOrderService {
    @Autowired
    private FoodOrderRepository foodOrderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional

    private FoodOrder createFoodOrder(int idProduct, UserToken user, int amount, FoodOrderState state) {
        Product p = productRepository.findById(idProduct);
        FoodOrder foodOrder = new FoodOrder(p, state, amount, user);
        this.getFoodOrderRepository().save(foodOrder);
        return foodOrder;
    }

    public FoodOrder order(int idProduct, UserToken user, int amount) {
        return createFoodOrder(idProduct, user, amount, FoodOrderState.ORDER);
    }

    public FoodOrder cancelOrder(int idProduct, UserToken user, int amount) {
        return createFoodOrder(idProduct, user, amount, FoodOrderState.CANCELORDER);
    }

    public FoodOrder coocked(int idProduct, UserToken user, int amount) {
        Product p = productRepository.findById(idProduct);
        List<FoodOrder> foodOrdersToCook = this.getFoodOrderRepository().findOrdersToCook(p, new Timestamp(DateTime.now().getMillis()));
        for (FoodOrder order : foodOrdersToCook) {
            System.out.println("Ordenes para cocinar: " + order.getId() + " - Prod: " + order.getProduct().getName());
        }
        if (foodOrdersToCook.size()>0)
        {
            FoodOrder foodOrder = foodOrdersToCook.get(0);
            foodOrder.setReadyToDeliver();
            this.getFoodOrderRepository().update(foodOrder);
        }
        return createFoodOrder(idProduct, user, amount, FoodOrderState.COOKED);
    }

    public FoodOrder cancelCoocked(int idProduct, UserToken user, int amount) {
        return createFoodOrder(idProduct, user, amount, FoodOrderState.CANCELCOOKED);
    }


    public FoodOrderRepository getFoodOrderRepository() {
        return foodOrderRepository;
    }

    @Transactional
    public List<FoodOrder> findAll() {
        return this.getFoodOrderRepository().findAll();
    }

    public FoodOrder findById(Integer id) {
        return this.getFoodOrderRepository().findById(id);
    }

    public List<FoodOrder> findByDay(Timestamp day) {
        return this.getFoodOrderRepository().findByDay(day);
    }

    public List<Timestamp> findAllDays() {
        return this.findAllDays(0);
    }

    public List<Timestamp> findAllDays(int count) {
        return this.getFoodOrderRepository().findAllDaysNotArchived(count);
    }


}
