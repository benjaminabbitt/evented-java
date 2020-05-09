package name.benjaminabbitt.evented.java;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Instant;

import static org.junit.Assert.assertEquals;

public class TimestampTest {
    private Instant now;
    private Instant deserialized;

    @Given("The current time")
    public void cucumberGiven() {
        now = Instant.now();
    }

    @When("I serialize and deserialize a timestamp")
    public void cucumberWhen() {
        com.google.protobuf.Timestamp serialized = TimestampAdapters.fromInstant(now);
        deserialized = TimestampAdapters.fromTimestamp(serialized);
    }

    @Then("The deserialized timestamp should be identical to the not-yet-serialized")
    public void cucumberThen() {
        assertEquals(now, deserialized);
    }
}
