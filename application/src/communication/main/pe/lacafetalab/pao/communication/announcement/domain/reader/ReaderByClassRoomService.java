package pe.lacafetalab.pao.communication.announcement.domain.reader;

import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementClassRoomId;
import pe.lacafetalab.pao.communication.announcement.domain.ReaderId;

import java.util.List;

public interface ReaderByClassRoomService {
    List<ReaderId> findByClassRoomId(AnnouncementClassRoomId classRoomId);
}
