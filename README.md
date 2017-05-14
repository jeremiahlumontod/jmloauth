Authentication module


pre-requisite:
1) java version 1.8 installed
2) maven 3.0.3 (tested on my machine)
3) internet connection since this will download maven dependency on the net
4) go to root of the project where pom.xml is located then execute:

   mvn jetty:run


1st step, create access_token and refresh_token.
----------------------------

http://localhost:8888/oauth2/oauth/token?grant_type=password&client_id=jml-client-id&client_secret=12345&username=jml&password=123456


{
	"access_token": "d89d6df4-ef58-4f6e-9cd9-24e25da57ad7",
	"token_type": "bearer",
	"refresh_token": "56414046-1a04-4fb7-8f0c-12002cde8b81",
	"expires_in": 28,
	"scope": "read trust write"
}


access the secured resource using the access token in step 1

Protected Resource
------------------
http://localhost:8888/oauth2/test/dataparam?access_token=d89d6df4-ef58-4f6e-9cd9-24e25da57ad7

http://localhost:8888/oauth2/test is the context, dataparam is the GET request parameter
that will be captured in JSONController


2nd step, create new access_token using the 1st step refresh_token when access_token expired
---------------------------

http://localhost:8888/oauth2/oauth/token?grant_type=refresh_token&client_id=jml-client-id&refresh_token=56414046-1a04-4fb7-8f0c-12002cde8b81&client_secret=12345

{
	"access_token": "1918b2ad-2427-490a-bbcf-53ea8522fe09",
	"token_type": "bearer",
	"refresh_token": "56414046-1a04-4fb7-8f0c-12002cde8b81",
	"expires_in": 28,
	"scope": "read trust write"
}

use the new generated access_token for accessing web resource. use the new generated refresh_token to generate new access_token when access_token
expired. repeat the process for succedding access_token generation


database setup:
------------------

1) create oauth database in mysql
2) run src/main/resources/import.sql 
   againts oauth database

