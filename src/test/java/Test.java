import org.example.Copier;
import org.example.IDestination;
import org.example.ISource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@DisplayName("All Tests")
public class Test {

    @Nested
    class successfulTest {

        @Mock
        private ISource mockSource;

        @Mock
        private IDestination mockDestination;

        @Mock
        private Copier copier;

        @BeforeEach
        public void setup() throws Exception {

            // Initialize mocks to be used for all subsequent tests
            mockSource = Mockito.mock(ISource.class);
            mockDestination = Mockito.mock(IDestination.class);

            copier = new Copier(mockSource, mockDestination);
        }

        @org.junit.jupiter.api.Test
        public void testValidCopy() throws Exception {

            // Mockito stubbing. When the mockSource.ReadChar() method is called, return the following characters.
            Mockito.when(mockSource.ReadChar()).thenReturn('k', 'a', 't', 'a', '\n');

            copier.Copy();

            // Verify interactions with mocks
            // ReadChar() is called supposed to be called 5 times
            Mockito.verify(mockSource, times(5)).ReadChar();
            // WriteChar() is supposed to be called 4 times because of the \n
            Mockito.verify(mockDestination, times(4)).WriteChar(anyChar()); // Verify any character was written 5 times

        }
    }
}
