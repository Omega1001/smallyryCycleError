package microservice.example.orc;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.reactive.messaging.annotations.Broadcast;

@ApplicationScoped
public class Fork {

	@Incoming("start")
	@Outgoing("fork")
	@Broadcast
	public String fork(String str) {
		return "fork "+ str;
	}
	
}
