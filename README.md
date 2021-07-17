# soapinaws
This is Producing a SOAP web service using a springboot implementation.
It holds lambda handle to process XML request and send the response as XML format.

**Steps:**
1. Build the project and package it as jar
2. Upload to S3 bucket
3. Create Lambda
4. Configure REST API Gateway
5. Hit the endpoint with below sample request
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gs="http://spring.io/guides/gs-producing-web-service">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:getCountryRequest>
         <gs:name>Poland</gs:name>
      </gs:getCountryRequest>
   </soapenv:Body>
</soapenv:Envelope>

![image](https://user-images.githubusercontent.com/38793410/126020415-23a420f9-457c-423f-861d-00ca1b1c2974.png)

![image](https://user-images.githubusercontent.com/38793410/126020691-8d8e991f-3939-45d9-9496-9cf7be45e2cd.png)
Method Request Settings:
![image](https://user-images.githubusercontent.com/38793410/126020743-712238c9-f031-413a-8029-692394402709.png)


![image](https://user-images.githubusercontent.com/38793410/126020717-8f99e74d-4a6d-49b2-b0fd-17e63dabb61b.png)


![image](https://user-images.githubusercontent.com/38793410/126020656-8e85072b-a7bd-4044-b1be-55811c29ce98.png)

