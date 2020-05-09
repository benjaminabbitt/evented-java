Feature: UUID Serialization/Deserialization
  We should be able to serialize and deserialize UUID without data loss

  Scenario: Attempt Ser/Deser
    Given A UUID
    When I serialize and deserialize a UUID
    Then The deserialized UUID should be identical to the not-yet-serialized