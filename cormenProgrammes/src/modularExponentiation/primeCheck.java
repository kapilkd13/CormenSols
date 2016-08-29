package modularExponentiation;

import java.util.Scanner;

public class primeCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		primeCheck p = new primeCheck();
		int num = p.getInputNum();
		modularExpo me = new modularExpo();
		int d = me.getExponentiation(2, num - 1, num);
		if ((d - 1) % num == 0)
			System.out.println("composite" + num + " " + (d - 1) % num);
		else
			System.out.println("prime" + num + " " + (d - 1) % num + " " + d);
	}

	public int getInputNum() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();

	}
}
