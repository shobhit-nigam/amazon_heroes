class Sale{
  
}

class Payment{

}

class Product {
  
}

class Register{
  
}
class ShoppingBasket{

  public int getTotal(){
    int total = 0;
    for (ShoppingBasket objs: items){
      Product p = objs.getProductdata();
      total = total + objs.getQuantity() * p.getPrice();
    }
    return total;
  }  
}