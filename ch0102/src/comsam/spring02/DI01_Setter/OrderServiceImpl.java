package comsam.spring02.DI01_Setter;
/* PersonSerVice  <----주입  PersonServiceImpl
 * 
 * 
 */
public class OrderServiceImpl  implements OrderService {

	private String productName;
	private int price;
	
	//getter,setter메서드는 최소한 보안 장치이다
	
	public void setProductName(String productName) {
		this.productName=productName; //<value> 값을 setter를 이용해 설정한다 
	}
	
	@Override
	public void order() {
	System.out.println("커피명 :"+productName);
	System.out.println("가격"+price);
	
	}
}
