package de.telran.springdemo.service;

import de.telran.springdemo.model.Greeting;
import de.telran.springdemo.repository.GreetingRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SuppressWarnings("unused")
public class GreetingServiceTest {

    @InjectMocks GreetingServiceImpl service;
    @Mock GreetingRepository repository;

    @Nested
    @DisplayName("Greeting creation tests")
    class CreateTests {

        static Random r;
        Greeting g;

        @BeforeEach
        void initializeGreeting() {
            g = new Greeting("Hello " + r.nextInt(10), r.nextInt(5));
        }

        @BeforeAll
        static void initializeRandom() { r = new Random(); }

        @Test
        void Should_returnIdAndNotModifyGreeting() {
            var a = 1L;
            var count = g.getCount();
            var value = g.getValue();

            when(repository.save(any(Greeting.class)))
                    .thenAnswer(i -> a);
            var b = service.create(g);

            assertAll(
                    () -> assertEquals(a, b),
                    () -> assertEquals(count, g.getCount()),
                    () -> assertEquals(value, g.getValue())
            );
        }
    }

    @Nested
    @DisplayName("Greeting fetch tests")
    class GetTests {

        @Test
        void Should_returnGreetingWithGivenId() {

        }

        @Test
        void Should_throwIllegalArgumentException() {

        }
    }
}
