# BANK-IFSC-API


#cURL request to register first

curl -X POST "https://still-lowlands-16478.herokuapp.com/register" -H 'Content-Type: application/json' -H 'cache-control: no-cache' -d '{"username": "abc","password": "1234"}'

#cURL request to get bearer token

curl -X POST "https://still-lowlands-16478.herokuapp.com/authenticate" -H 'Content-Type: application/json' -H 'cache-control: no-cache' -d '{"username": "abc","password": "1234"}'

#cURL request to fetch details of all bank of a specific bank in a city

curl -X GET "https://still-lowlands-16478.herokuapp.com/api/branches/{bank name}/{city}?limit=10&offset=10" -H 'Content-Type: application/json' -H 'Authorization: Bearer 'bearer token'

#cURL request to fetch details of specific IFSC Code

curl -X GET "https://still-lowlands-16478.herokuapp.com/api/bankdetail/{ifsc code}" -H 'Content-Type: application/json' -H 'Authorization: Bearer 'bearer token'


