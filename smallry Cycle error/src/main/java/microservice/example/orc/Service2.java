package microservice.example.orc;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@ApplicationScoped
public class Service2 {

	@Incoming("fork")
	@Outgoing("join")
	public String service2(String src) {
		return "service 2 "+ src;
	}
	
}
