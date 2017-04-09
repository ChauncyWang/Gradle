import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Chauncy on 2017/4/7.
 */
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i = 1;
		while (in.hasNext()){
			if(i==0){
				System.out.println();
			}else i=0;
			BigInteger a = new BigInteger(in.next());
			BigInteger b = a.add(new BigInteger("1")).multiply(a).divide(new BigInteger("2"));
			System.out.print(b);
		}
	}
}
