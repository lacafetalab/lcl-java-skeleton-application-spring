package pe.lacafetalab.pao.communication.announcement;

import org.springframework.beans.factory.annotation.Autowired;
import pe.lacafetalab.pao.communication.ComunicationContextInfrastructureTestCase;
import pe.lacafetalab.pao.communication.announcement.domain.AnnouncementRepository;
import pe.lacafetalab.pao.communication.announcement.domain.reader.AnnouncementReaderRepository;

public abstract class AnnouncementModuleInfrastructureTestCase extends ComunicationContextInfrastructureTestCase {
    @Autowired
    protected AnnouncementRepository sqlAnnouncementRepository;

    @Autowired
    protected AnnouncementReaderRepository sqlAnnouncementReaderRepository;
}
