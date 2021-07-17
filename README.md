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

![image](https://user-images.githubusercontent.com/38793410/126020495-bc45a9df-c893-4fe4-be69-51d87ab0d0b4.png)

![image](https://user-images.githubusercontent.com/38793410/126020507-fbf7c6d4-6b35-4cfb-ba93-b0ca5ead06c3.png)

![image](https://user-images.githubusercontent.com/38793410/126020518-9130d8f4-5f50-4cfd-b39b-67c7931c578c.png)

![image](https://user-images.githubusercontent.com/38793410/126020547-3fb653b9-6e70-4bd4-8ccd-1aaed00f8fcc.png)

![image](https://user-images.githubusercontent.com/38793410/126020557-af13851d-c7d3-42e4-8ec9-e31c5671e961.png)

![image](https://user-images.githubusercontent.com/38793410/126020569-359ab3b8-4f0b-4309-ad39-d711b78f19b9.png)

![image](https://user-images.githubusercontent.com/38793410/126020656-8e85072b-a7bd-4044-b1be-55811c29ce98.png)

