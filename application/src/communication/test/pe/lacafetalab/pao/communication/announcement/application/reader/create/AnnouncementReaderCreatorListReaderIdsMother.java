package pe.lacafetalab.pao.communication.announcement.application.reader.create;

import pe.lacafetalab.pao.communication.announcement.domain.ReaderId;
import pe.lacafetalab.pao.sharedtest.domain.UuidMother;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class AnnouncementReaderCreatorListReaderIdsMother {
    public static List<ReaderId> create(List<String> ids) {
        return ids.stream().map(ReaderId::new).collect(Collectors.toList());
    }
    public static List<ReaderId> random() {

        List<String> ids = new ArrayList<String>();
        ids.add(UuidMother.random());
        ids.add(UuidMother.random());
        ids.add(UuidMother.random());
        ids.add(UuidMother.random());
        return create(ids);
    }
}
