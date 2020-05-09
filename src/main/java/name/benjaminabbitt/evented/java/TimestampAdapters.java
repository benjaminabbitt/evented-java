package name.benjaminabbitt.evented.java;

import java.time.Instant;

public class TimestampAdapters {

    public static com.google.protobuf.Timestamp now() {
        return fromInstant(Instant.now());
    }

    public static com.google.protobuf.Timestamp fromInstant(Instant inst) {
        return com.google.protobuf.Timestamp.newBuilder()
                .setSeconds(inst.getEpochSecond())
                .setNanos(inst.getNano())
                .build();
    }

    public static Instant fromTimestamp(com.google.protobuf.Timestamp ts) {
        return Instant.ofEpochSecond(ts.getSeconds(), ts.getNanos());
    }
}
