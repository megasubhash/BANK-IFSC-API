# BANK-IFSC-API


cURL request to register first
curl -d '{"username":"user","password":"password"}' -H "Content-Type: application/json" -X POST https://still-lowlands-16478.herokuapp.com/register

cURL request to get bearer token
curl -d '{"username":"user","password":"password"}' -H "Content-Type: application/json" -X POST https://still-lowlands-16478.herokuapp.com/authenticate

cURL request to fetch details of all bank of a specific bank in a city
curl -X GET https://still-lowlands-16478.herokuapp.com/api/branches/{bank name}/{city}?limit=10&offset=10 -H 'Content-Type: application/json' -H 'Authorization: Bearer 'bearer token'

cURL request to fetch details of specific IFSC Code
curl -X GET https://still-lowlands-16478.herokuapp.com/api/bankdetail/{ifsc code} -H 'Content-Type: application/json' -H 'Authorization: Bearer 'bearer token'


