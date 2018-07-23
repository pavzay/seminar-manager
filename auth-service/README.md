# Auth Service

Get access token:

`curl -X POST --user 'ui:ui' -d 'scope=ui&grant_type=password&username=<username>&password=<password>' http://localhost:5000/oauth/token`

or

`curl -X POST -H "Authorization: Basic dWk6dWk=" -d 'scope=ui&grant_type=password&username=<username>&password=<password>' http://localhost:5000/oauth/token`

Check access token:

`curl -X GET -H "Accept: application/json" -H "Authorization: Bearer <access_token>" http://localhost:5000/users/current`



