package builder;

public class Arithmetic {

	private final int add;
	private final int substract;
	private final int out;
	
	public Arithmetic(ArithmeticBuilder builder) {
		add = builder.add;
		substract = builder.substract;
		out = builder.out;
		
	}
	
	public static class ArithmeticBuilder {
		
		private int add = 0;
		private int substract = 0;
		private int out = 0;
		
		public ArithmeticBuilder add(int val) {
			add += val;
			return this;
		}
		
		public ArithmeticBuilder substract(int val) {
			substract += val;
			return this;
		}
		
		public ArithmeticBuilder out() {
			out = add - substract;
			return this;
		}
		
		
		public Arithmetic build() {
			return new Arithmetic(this);
		}
		
	}

	@Override
	public String toString() {
		return "Arithmetic [out=" + out + "]";
	}

	

	

	
	
	
	
	
}
