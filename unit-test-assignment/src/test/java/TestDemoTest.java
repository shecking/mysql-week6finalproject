import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

class TestDemoTest {
	
	
	// adding private instance variable testDemo
	private TestDemo testDemo = new TestDemo();
	
	@BeforeEach
	void setUp() {
		// create TestDemo object in setUp(), new object will be made before each test
		new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	// testing addPositive method in TestDemo
	// assert method with four parameters
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
		// test the value of expectException
		// using assertEquals() instead of assertThat()
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			// add test for thrown exception
			assertThatThrownBy(() -> 
				testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	// adding parameter source method
	// no arguments, return Stream of Arguments
	static Stream<Arguments> argumentsForAddPositive() {
		// return a Stream of Arguments using Stream.of()
		// we are testing the addPositive method with this stream
		// this stream provides the raw test data in the form of arguments() objects
		return Stream.of(
				// both positive
				arguments(2, 2, 4, false),
				// 0 in either field
				arguments(4, 0, 4, true),
				arguments(0, 4, 4, true),
				// negative in either field
				arguments(-3, 7, 4, true),
				arguments(7, -3, 4, true)
		);
	}
	
	@Test
	// package visibility
	// testing randomNumberSquared in TestDemo
	void assertThatNumberSquaredIsCorrect() {
		// mocking TestDemo class, creating a goof object to test
		// spy lets us call all the normal methods of a real object on a fake(mock) object
		TestDemo mockDemo = spy(testDemo);
		// return 5 when getRandomInt is called on this new mock object
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
}
