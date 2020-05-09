package name.benjaminabbitt.evented.java;

import com.google.protobuf.InvalidProtocolBufferException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import name.benjaminabbitt.evented.core.Evented;

import java.time.Instant;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class UUIDAdaptersTest {
    private UUID expected;
    private UUID deserialized;

    @Given("A UUID")
    public void uuidAdaptersNothing() {
        expected = UUID.randomUUID();
    }

    @When("I serialize and deserialize a UUID")
    public void uuidAdaptersWhen() throws InvalidProtocolBufferException {
        Evented.UUID id = UUIDAdapters.uuuidToeuuid(expected);
        deserialized = UUIDAdapters.euuidTouuuid(id);
    }

    @Then("The deserialized UUID should be identical to the not-yet-serialized")
    public void uuidAdaptersThen() {
        assertEquals(expected, deserialized);
    }
}
