import java.util.Random;

public class TestDemo {
	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive");
		}
	}
	
	// no parameters
	// return int (squared num)
	public int randomNumberSquared() {
		int num = getRandomInt();
		return num * num;
	}

	// no parameters, using import java.util.Random;
	// return int (random number)
	int getRandomInt() {
		Random rand = new Random();
		return rand.nextInt(10) + 1;
	}
}
