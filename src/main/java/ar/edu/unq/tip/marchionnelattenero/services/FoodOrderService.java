package ar.edu.unq.tip.marchionnelattenero.services;

import ar.edu.unq.tip.marchionnelattenero.controllers.responses.FoodOrderCreationResponse;
import ar.edu.unq.tip.marchionnelattenero.controllers.responses.FoodOrderResponse;
import ar.edu.unq.tip.marchionnelattenero.factories.FoodOrderFactory;
import ar.edu.unq.tip.marchionnelattenero.models.FoodOrder;
import ar.edu.unq.tip.marchionnelattenero.models.Product;
import ar.edu.unq.tip.marchionnelattenero.repositories.FoodOrderRepository;
import ar.edu.unq.tip.marchionnelattenero.repositories.FoodOrderRepository;
import ar.edu.unq.tip.marchionnelattenero.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("foodOrderService")
public class FoodOrderService {
    @Autowired
    private FoodOrderRepository foodOrderRepository;

    @Autowired
    private FoodOrderFactory foodOrderFactory;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public FoodOrder createFoodOrder(int idProduct, int amount) {
        Product p = productRepository.findById(idProduct);
        FoodOrder foodOrder = new FoodOrder(p,amount);
        this.foodOrderRepository.save(foodOrder);
        return foodOrder;
    }
    @Transactional
    public List<FoodOrderResponse> findAll() {

        List<FoodOrderResponse> orders = new ArrayList<>();

        for(FoodOrder f : foodOrderRepository.findAll()){
            orders.add((new FoodOrderResponse(f.getProduct().getName(),f.getAmount(),f.getId())));
        }

        return orders;
    }

    @Transactional
    public void deleteFoodOrder(FoodOrder foodOrder) {
        foodOrderRepository.delete(foodOrder);
    }

    public FoodOrder getFoodOrder(Integer id) {
        return this.foodOrderFactory.getFoodOrderById(id);
    }

    public FoodOrderRepository getFoodOrderRepository() {
        return foodOrderRepository;
    }
}
