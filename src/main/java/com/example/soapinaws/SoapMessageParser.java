package com.example.soapinaws;

import com.google.inject.Inject;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPMessage;


public class SoapMessageParser {
	 private final MessageFactory messageFactory;

	    @Inject
	    SoapMessageParser(MessageFactory messageFactory) {
	        this.messageFactory = messageFactory;
	    }

	    public SOAPMessage parseFrom(String messageXml) {
	        if (messageXml != null && messageXml.length() > 0) {
	            return parse(messageXml);
	        } else {
	            throw new IllegalArgumentException("Failed to parse, messageXml is empty");
	        }
	    }

	    private SOAPMessage parse(String messageXml) {
	        try (ByteArrayInputStream in = new ByteArrayInputStream(messageXml.getBytes(StandardCharsets.UTF_8))) {
	            return messageFactory.createMessage(new MimeHeaders(), in);
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to create SOAPMessage from [" + messageXml + "]");
	        }
	    }
}
