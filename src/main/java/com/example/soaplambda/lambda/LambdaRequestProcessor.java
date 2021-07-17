package com.example.soaplambda.lambda;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.example.soapinaws.SoapMessageParser;
import com.example.soapinaws.SoapWrapper;
import com.example.soapinaws.SoapXmlMessage;
import com.google.inject.Inject;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;
import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;

public class LambdaRequestProcessor {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LambdaRequestProcessor.class);
    private final SoapMessageParser soapMessageParser;

    
    @Inject
    LambdaRequestProcessor(SoapMessageParser soapMessageParser) {
        this.soapMessageParser = soapMessageParser;
    }

    SoapWrapper process(SoapWrapper request) {
        LOGGER.info("Received api request: [" + request + "]");
        try {
            SOAPMessage soapMessage = soapMessageParser.parseFrom(request.getBody());
            SOAPMessage response = handle(soapMessage);
            return wrap(response);
        } catch (Exception e) {
            LOGGER.error("Failed to handle API request: [" + request + "]", e);
        }
        return null;
    }

    private SOAPMessage handle(SOAPMessage soapMessage) {
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	Unmarshaller unmarshaller;
    	Marshaller marshallObj;
    	
        try {
            // TODO actually handle the message. For demonstration purposes return example response.
        
        	 
        	  DocumentBuilder builder = factory.newDocumentBuilder();

              // create a new document
              Document doc = builder.newDocument();
			
				unmarshaller = JAXBContext.newInstance(GetCountryRequest.class).createUnmarshaller();
				marshallObj = JAXBContext.newInstance(GetCountryResponse.class).createMarshaller();
				//setting the property to show xml format output
			    marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			    
				GetCountryRequest countryRequest = (GetCountryRequest)unmarshaller.unmarshal(soapMessage.getSOAPBody().extractContentAsDocument());
				LOGGER.info("	countryRequest.getName()@: "+	countryRequest.getName());
				GetCountryResponse response = new GetCountryResponse();
				Country poland = new Country();
				poland.setName("Poland");
				poland.setCapital("Warsaw");
				poland.setCurrency(Currency.PLN);
				poland.setPopulation(38186860);
				
				response.setCountry(poland);
				 
				marshallObj.marshal(response, doc);
				SOAPMessage soapMessage1 = MessageFactory.newInstance().createMessage();
				soapMessage1.getSOAPPart().getEnvelope().addNamespaceDeclaration("gs", "http://spring.io/guides/gs-producing-web-service");
				soapMessage1.getSOAPBody().addDocument(doc);
				/*
				 * marshallObj.marshal(response, doc); String xml = new
				 * XMLOutputFactory().outputString(doc); InputStream inputStream = new
				 * StringBufferInputStream(xml); doc.get
				 * ***
				 */
        	
        	
        	//return ExampleResponse.create();
        	return soapMessage1;
        } catch (SOAPException e) {
            throw new RuntimeException("Failed to create SOAPMessage", e);
        	//return ExampleResponse.create();
        } catch (JAXBException e) {
        	  throw new RuntimeException("Failed to create JAXBException", e);
			//e.printStackTrace();
        	//return ExampleResponse.create();
		} catch (ParserConfigurationException e) {
			  throw new RuntimeException("Failed to create ParserConfigurationException", e);
			//e.printStackTrace();
			//return ExampleResponse.create();
		}
    }

    private SoapWrapper wrap(SOAPMessage soapMessage) {
        String messageAsXml = new SoapXmlMessage(soapMessage).toXml();
        return new SoapWrapper(messageAsXml);
    }
}
