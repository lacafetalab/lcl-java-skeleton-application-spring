package pe.lacafetalab.pao.shared.domain.types.implement;

import pe.lacafetalab.pao.shared.domain.libraries.UUID5;
import pe.lacafetalab.pao.shared.domain.types.TypeUUID;

import java.util.UUID;

public class TypeUUIDImp extends TypeUUID {
    public TypeUUIDImp(String uuid) {
        super(uuid);
    }

    public static TypeUUIDImp create(String value) {
        return new TypeUUIDImp(value);
    }

    public static TypeUUIDImp randon() {
        return new TypeUUIDImp(UUID.randomUUID().toString());
    }

    public static TypeUUID fromString(String value) {
        return new TypeUUIDImp(UUID5.fromUTF8(UUID5.POLYGENEA_NAMESPACE, value).toString());
    }

    public static TypeUUID fromClass(Class<?> clazz) {
        return new TypeUUIDImp(UUID5.fromUTF8(UUID5.POLYGENEA_NAMESPACE, clazz.getName()).toString());
    }

}


