package comsam.spring02.DI02_Construct;

public class OrderServiceImpl implements OrderService{
 private String productName;
 private int price;
 
 
 public OrderServiceImpl(String productName) {
		this.productName = productName;
	
	}
 
public OrderServiceImpl(String productName, int price) {
		this.productName = productName;
		this.price = price;
}

@Override
public void order() {
	System.out.println("제품명:"+productName);
	System.out.println("가격:"+price);
}

}

