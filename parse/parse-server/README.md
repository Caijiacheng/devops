# Parse Server

## Dev: 
```shell
    $ docker-compose up -d # start mongo
    $ yarn install
    $ yarn run start-dev # start parse server in developing 
    $ yarn run dashboard # start dashboard. http://localhost:4040
```


## Docker Deploy (local instance)
```shell
    $ docker-compose -f docker-compose.deploy.yml build
    $ docker-compose up -d
```

## Test 
```shell
    $ curl -X POST   -H "X-Parse-Application-Id: 2NjRq2vT9iTScCj5Oa95ha1CygCnrcityNbaBYMm" http://localhost:1337/parse/functions/hello
    $ curl -X GET -H "X-Parse-Application-Id: 2NjRq2vT9iTScCj5Oa95ha1CygCnrcityNbaBYMm" http://localhost:1337/parse/classes/TestObjects
```

## Dashboard
URL: [http://localhost:4040](http://localhost:4040)
