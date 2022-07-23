import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoTest {

  private TestDemo testDemo;
  
  @BeforeEach
  void setUp() {
    testDemo = new TestDemo();
  }
  static Stream<Arguments> argumentsForAddPositive() {
    return Stream.of(
        arguments(2, 4, 6, false),
        arguments(0, 3, 3, true),
        arguments(-3, 4, 1, true),
        arguments(10, 3, 13, false)); 
  }
  @ParameterizedTest
  @MethodSource("TestDemoTest#argumentsForAddPositive")
  void assertThatTwoPositiveNumbersAreCorrectly(
      int a, int b, int expected, Boolean expectException) {
    if(!expectException) {
      assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
    }
    else {
      assertThatThrownBy(()-> testDemo.addPositive(a, b))
      .isInstanceOf(IllegalArgumentException.class);
    }
  
  }
  
  @Test
  void assertThatNumberSquaredIsCorrect() {
    TestDemo mockDemo = spy(testDemo);
    
    //doReturn(5).when(mockDemo).getRandomInt();
    doReturn(6).when(mockDemo).getRandomInt();
  
    //int fiveSquared = mockDemo.randomNumberSquared();
    //assertThat(fiveSquared).isEqualTo(25);
    int sixSquared = mockDemo.randomNumberSquared();
    assertThat(sixSquared).isEqualTo(36);
  }
}

