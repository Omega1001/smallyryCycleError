package microservice.example.orc;

import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@Path("/hello")
public class HelloService {

	private static final AtomicInteger count = new AtomicInteger(0);

	@Inject
	@Channel("start")
	private Emitter<String> sender;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/test/{name}")
	public String greeting(@PathParam("name") String name) {

		String msg = name + count.incrementAndGet();
		
		sender.send(msg);
		
		return msg;
	}


}
