package com.spredfast.nextgenapi.dropwizard;


import com.spredfast.dropwizard.BaseServer;
import com.spredfast.dropwizard.ContextBuilder;
import com.spredfast.nextgenapi.configuration.NextGenApiConfiguration;
import com.spredfast.nextgenapi.dropwizard.resources.PingResource;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NextGenApiServer extends BaseServer<NextGenApiConfiguration> {
	private static final Logger LOGGER = LoggerFactory.getLogger(NextGenApiServer.class);

	public static void main(String[] args) throws Exception {
		new NextGenApiServer().run(args);
	}

	@Override
	protected AnnotationConfigApplicationContext createApplicationContext(NextGenApiConfiguration configuration,
	                                                                      Environment environment) {
		environment.jersey().register(new PingResource());

		return ContextBuilder.build(configuration, environment);
	}
}
