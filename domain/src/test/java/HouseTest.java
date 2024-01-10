import com.cleanarchitecture.House;
import com.cleanarchitecture.exception.DomainException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class HouseTest {

    @Test
    void testConstructorWithValidValues() {
        House house = new House("123 Main St", "Cityville", 500000);

        assertNotNull(house.getId());
        assertEquals("123 Main St", house.getAddress());
        assertEquals("Cityville", house.getCity());
        assertEquals(500000, house.getPrice());
    }

    @Test
    void testConstructorWithNullAddress() {
        assertThrows(DomainException.class, () -> new House(null, "Cityville", 500000));
    }

    @Test
    void testConstructorWithBlankAddress() {
        assertThrows(DomainException.class, () -> new House("  ", "Cityville", 500000));
    }

    @Test
    void testConstructorWithNullCity() {
        assertThrows(DomainException.class, () -> new House("123 Main St", null, 500000));
    }

    @Test
    void testConstructorWithBlankCity() {
        assertThrows(DomainException.class, () -> new House("123 Main St", "  ", 500000));
    }

    @Test
    void testConstructorWithNullPrice() {
        assertThrows(DomainException.class, () -> new House("123 Main St", "Cityville", null));
    }

    @Test
    void testConstructorWithInvalidPrice() {
        assertThrows(DomainException.class, () -> new House("123 Main St", "Cityville", 123));
    }

    @Test
    void testSettersAndGetters() {
        House house = new House("123 Main St", "Cityville", 500000);

        UUID newId = UUID.randomUUID();
        house.setId(newId);
        assertEquals(newId, house.getId());

        house.setAddress("456 Elm St");
        assertEquals("456 Elm St", house.getAddress());

        house.setCity("Townsville");
        assertEquals("Townsville", house.getCity());

        house.setPrice(600000);
        assertEquals(600000, house.getPrice());
    }
}
