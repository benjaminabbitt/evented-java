Feature: Timestamp Serialization/Deserialization
  We should be able to serialize and deserialize timestamps without data loss
  Scenario: Attempt Ser/Deser
    Given The current time
    When I serialize and deserialize a timestamp
    Then The deserialized timestamp should be identical to the not-yet-serialized