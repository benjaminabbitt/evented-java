package name.benjaminabbitt.evented.java;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import name.benjaminabbitt.evented.core.Evented;

import java.nio.ByteBuffer;

public class UUIDAdapters {
    public static java.util.UUID euuidTouuuid(Evented.UUID euuid) {
        ByteBuffer bytes = ByteBuffer.wrap(euuid.getValue().toByteArray());
        return new java.util.UUID(bytes.getLong(), bytes.getLong());
    }

    private static byte[] uuidToBytes(java.util.UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();

    }

    public static Evented.UUID uuuidToeuuid(java.util.UUID uuuid) {
        byte[] bytes = uuidToBytes(uuuid);
        ByteString bs = ByteString.copyFrom(bytes);
        return Evented.UUID.newBuilder().setValue(bs).build();
    }
}
