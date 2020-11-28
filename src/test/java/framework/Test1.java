package framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Test1 {
    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithExplicitLocalMethodSource(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> stringProvider() {
        return Stream.of("apple", "banana");
    }

    @ParameterizedTest
    @MethodSource()
    void search (TestCase testCase) {
        System.setProperty("webdriver.chrome.driver","E:/exe/chromedriver_win32/chromedriver.exe/");
        System.out.println(testCase);
        testCase.run();
    }

    static Stream<TestCase> search() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TestCase testCase = mapper.readValue(
                Test1.class.getResourceAsStream("/framework/search.yaml"),
                TestCase.class);
        return Stream.of(testCase);
    }

}
