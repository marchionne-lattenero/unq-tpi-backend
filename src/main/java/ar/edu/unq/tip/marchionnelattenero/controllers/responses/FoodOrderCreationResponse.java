package ar.edu.unq.tip.marchionnelattenero.controllers.responses;


import ar.edu.unq.tip.marchionnelattenero.models.FoodOrder;

public class FoodOrderCreationResponse {

    //TODO PENSAR BIEN QUE RESPONDE, POR AHORA LA CANTIDAD DE PRODS  PENDIENTES
    private int productsPending;
    private Integer id;


    public FoodOrderCreationResponse(int productsPending, int id) {

        this.setProductsPending(productsPending);
        this.setId(id);

    }


    public static FoodOrderResponse build(FoodOrder foodOrder) {
        //TODO: ACTUALIZAR LA CANTIDAD DEL MAPA
        return new FoodOrderResponse(foodOrder.getProduct().getName(), foodOrder.getAmount(), foodOrder.getId());
    }

    public int getProductsPending() {
        return productsPending;
    }

    public void setProductsPending(int productsPending) {
        this.productsPending = productsPending;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
