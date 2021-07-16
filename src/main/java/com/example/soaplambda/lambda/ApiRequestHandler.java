package com.example.soaplambda.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.soapinaws.ApiWrapperLambdaModule;
import com.example.soapinaws.SoapWrapper;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class ApiRequestHandler implements RequestHandler<SoapWrapper, SoapWrapper>{

	private static final Injector INJECTOR = Guice.createInjector(new ApiWrapperLambdaModule());

    private final LambdaRequestProcessor lambdaRequestProcessor = INJECTOR.getInstance(LambdaRequestProcessor.class);

    
	@Override
	public SoapWrapper handleRequest(SoapWrapper request, Context context) {
		// TODO Auto-generated method stub
		 return lambdaRequestProcessor.process(request);
	}

}
