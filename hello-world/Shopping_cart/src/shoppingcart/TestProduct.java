package shoppingcart;

public class TestProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Product product=new Product();
		
		product.setId("1D00");
		product.setName("Mobile");
		product.setPrice(20000);
		
			System.out.println(product.getId() );
			System.out.println(product.getName() );
			System.out.println(product.getPrice() );
	}

}
