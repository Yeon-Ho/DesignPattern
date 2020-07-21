package run;

import builder.Arithmetic;

public class ArithmeticRun {
	public static void main(String[] args) {

		
		Arithmetic arithmetic = new Arithmetic.ArithmeticBuilder()
								.add(4).add(5).substract(3).out()
								.build();
		
		System.out.println(arithmetic);
		
		System.out.println("================");
		
		
		
	}
}
