import static org.junit.jupiter.api.Assertions.*;

import com.es2.singleton.End;
import com.es2.singleton.Registry;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestSingleton {

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    @DisplayName("Test Path variable")
    void testPath() {
        Registry.getInstance().setPath("/user/abc");
        assertEquals("/user/abc", Registry.getInstance().getPath());
    }

    @Test
    @DisplayName("Test ConnectionString for Null")
    void testConnectionString_null() {
        Registry.getInstance().setConnectionString(null);
        assertNull(Registry.getInstance().getConnectionString());
    }

    @Test
    @DisplayName("Test Path variable")
    void testPath_null(){
        Registry.getInstance().setPath(null);
        assertNull(Registry.getInstance().getPath()); //
    }

    @Test
    @DisplayName("Test ConnectionString for Null")
    void testConnectionString() {
        Registry.getInstance().setConnectionString("jdbc://sql");
        assertEquals("jdbc://sql", Registry.getInstance().getConnectionString());
    }

    @AfterAll
    static void testEnd() {
        End e = new End();
    }

}