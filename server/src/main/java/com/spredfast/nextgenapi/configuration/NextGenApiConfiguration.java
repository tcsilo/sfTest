package com.spredfast.nextgenapi.configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spredfast.common.util.DevMode;
import com.spredfast.common.util.types.EnvironmentName;
import com.spredfast.dropwizard.configuration.BaseConfiguration;

public class NextGenApiConfiguration extends BaseConfiguration {
	public static final String COMPONENT_NAME = "Next Gen API";

	@Valid
	@NotNull
	@JsonProperty
	private EnvironmentName environmentName = DevMode.LOCAL_ENV;

	public EnvironmentName getEnvironmentName() {
		return environmentName;
	}

	public void setEnvironmentName(EnvironmentName environmentName) {
		this.environmentName = environmentName;
	}
}
