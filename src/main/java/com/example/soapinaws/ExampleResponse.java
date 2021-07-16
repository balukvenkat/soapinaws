package com.example.soapinaws;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.springframework.beans.factory.annotation.Autowired;

import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;

public class ExampleResponse {
	
	
	
	
	 public static SOAPMessage create() throws SOAPException {
	        MessageFactory messageFactory = MessageFactory.newInstance();
	        SOAPMessage message = messageFactory.createMessage();
	        SOAPPart soapPart = message.getSOAPPart();

	        SOAPEnvelope envelope = soapPart.getEnvelope();
	        envelope.addNamespaceDeclaration("codecentric", "https://www.codecentric.de");

	        SOAPBody envelopeBody = envelope.getBody();
	        SOAPElement soapBodyElem = envelopeBody.addChildElement("location", "codecentric");

	        SOAPElement place = soapBodyElem.addChildElement("place", "codecentric");
	        place.addTextNode("Berlin");

	        SOAPElement position = soapBodyElem.addChildElement("position", "codecentric");

	        SOAPElement latitude = position.addChildElement("latitude", "codecentric");
	        latitude.addTextNode("52.510818");
	        SOAPElement longitude = position.addChildElement("longitude", "codecentric");
	        longitude.addTextNode("13.372008");

	        MimeHeaders headers = message.getMimeHeaders();
	        headers.addHeader("SOAPAction", "https://www.codecentric.de/receive");

	        message.saveChanges();
	        return message;
	    }
	 
	 public static SOAPMessage create(GetCountryRequest soapMessage) throws SOAPException {
			/*
			 * MessageFactory messageFactory = MessageFactory.newInstance(); SOAPMessage
			 * message = messageFactory.createMessage();
			 * 
			 * GetCountryResponse response = new GetCountryResponse(); CountryRepository
			 * countryRepository = new CountryRepository(); GetCountryRequest request =
			 * soapMessage;
			 * response.setCountry(countryRepository.findCountry(soapMessage.getName()));
			 * 
			 * return response;
			 */
			
		   return null;
	 }
}
