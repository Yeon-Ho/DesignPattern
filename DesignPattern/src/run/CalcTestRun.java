package run;

import builder.CalcTest;

public class CalcTestRun {
	public static void main(String[] args) {
		
		int res = new CalcTest().add(4).add(5).sub(3).out();
		System.out.println(res);
		
	}

}
