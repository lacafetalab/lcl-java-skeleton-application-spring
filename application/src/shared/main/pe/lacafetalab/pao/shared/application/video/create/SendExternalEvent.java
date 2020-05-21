package pe.lacafetalab.pao.shared.application.video.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import pe.lacafetalab.pao.shared.application.ApplicationCommand;
import pe.lacafetalab.pao.shared.domain.events.DomainEvent;
import pe.lacafetalab.pao.shared.framework.ApplicationContext;
import pe.lacafetalab.pao.shared.infrastructure.ExternalHttpService;
import pe.lacafetalab.pao.shared.infrastructure.GeneralRequestEventData;

@Service
public class SendExternalEvent implements ApplicationCommand<DomainEvent> {

	private static Logger logger = LoggerFactory.getLogger(SendExternalEvent.class);

	private ExternalHttpService externalHttpService;
	private String paoEventsUrl;

	public SendExternalEvent(ExternalHttpService externalHttpService, @Value("${pao.events.url}") String paoEventsUrl) {
		this.externalHttpService = externalHttpService;
		this.paoEventsUrl = paoEventsUrl;
	}

	@Override
	public void execute(DomainEvent eventData) {
		try {
			GeneralRequestEventData event = GeneralRequestEventData.builder()
					.transactionId(ApplicationContext.getContext().getTransactionId()).attributes(eventData)
					.name(eventData.fullQualifiedEventName()).build();
			logger.info("Sending event:" + new Gson().toJson(event));
			externalHttpService.doRequestAsync(paoEventsUrl, "POST", null, event);
			logger.info("Sent event:" + new Gson().toJson(event));
		} catch (Throwable t) {
			logger.warn("A error has occurred sending a event to pao student", t);
		}

	}

}
