package bikeshowroom;

public class TestBike {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bike bike= new Bike();
		
		bike.setBikeName("Unicorn");
		bike.setManufacturer("Honda");
		bike.setRegNo(154974564);
		bike.setPrice(850000);
		
		System.out.println(bike.getBikeName());
		System.out.println(bike.getManufacturer());
		System.out.println(bike.getRegNo());
		System.out.println(bike.getPrice());

	}

}
