package microservice.example.orc;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import io.smallrye.reactive.messaging.annotations.Merge;



@ApplicationScoped
public class Join {
	
	@Incoming("join")
	@Merge
	public void join(String s) {
		System.out.println(s);
	}
}
