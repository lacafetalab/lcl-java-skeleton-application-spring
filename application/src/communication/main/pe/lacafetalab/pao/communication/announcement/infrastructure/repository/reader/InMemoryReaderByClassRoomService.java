package pe.lacafetalab.pao.communication.announcement.infrastructure.repository.reader;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementClassRoomId;
import pe.lacafetalab.pao.communication.announcement.domain.ReaderId;
import pe.lacafetalab.pao.communication.announcement.domain.reader.ReaderByClassRoomService;
import pe.lacafetalab.pao.shared.domain.types.implement.TypeUUIDImp;

import java.util.ArrayList;
import java.util.List;

@Service
public final class InMemoryReaderByClassRoomService implements ReaderByClassRoomService {
    @Override
    public List<ReaderId> findByClassRoomId(AnnouncementClassRoomId classRoomId) {
        List<ReaderId> ids = new ArrayList<ReaderId>();
        ids.add(new ReaderId(TypeUUIDImp.fromString("AlumnoDemo").toString()));
        ids.add(new ReaderId(TypeUUIDImp.randon().toString()));
        ids.add(new ReaderId(TypeUUIDImp.randon().toString()));
        ids.add(new ReaderId(TypeUUIDImp.randon().toString()));
        return ids;
    }
}
