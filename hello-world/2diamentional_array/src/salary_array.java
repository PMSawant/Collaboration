
public class salary_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[];
		num = new int[10];
		int i,sum=0,a;
		for(i=0;i<=9;i++)
		{
		num[i]=Integer.parseInt(args[i]);
	    int a=sum+num;
		}
		System.out.println("Total salary is"+sum);
	}

}
