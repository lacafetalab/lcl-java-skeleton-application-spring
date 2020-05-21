package pe.lacafetalab.pao.communication;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import pe.lacafetalab.pao.main.PaoApplication;
import pe.lacafetalab.pao.sharedtest.infrastructure.InfrastructureTestCase;

@ContextConfiguration(classes = PaoApplication.class)
@SpringBootTest
public abstract class ComunicationContextInfrastructureTestCase extends InfrastructureTestCase {
}