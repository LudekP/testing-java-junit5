package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;


class OwnerTest implements ModelTests {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1L, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1212313123");

        assertAll("Properties Test",
                () -> assertAll("Person properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "First name did not match"),
                        () -> assertEquals("Buck", owner.getLastName())),
                () -> assertAll("Owner properties",
                        () -> assertEquals("Key West", owner.getCity(), "City did not match"),
                        () -> assertEquals("1212313123", owner.getTelephone()))
                );

        assertThat(owner.getCity(), is("Key West"));
    }

    @DisplayName("Value Source Test - ")
    @ParameterizedTest(name = "{displayName} [{index}] {argumentsWithNames}")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String value) {
        System.out.println(value);
    }

    @DisplayName("Enum Source Test - ")
    @ParameterizedTest(name = "{displayName} [{index}] {argumentsWithNames}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    @DisplayName("CSV Input Test - ")
    @ParameterizedTest(name = "{displayName} [{index}] {argumentsWithNames}")
    @CsvSource({
            "FL,1,1",
            "OH,2,2",
            "MI,3,2"
    })
    void csvInputTest(String state_name, int val1, int val2) {
        System.out.println(state_name + " = " + val1 + ":" + val2);
    }
}