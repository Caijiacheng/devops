# Microservices 

# 1. Services

1.1 GRPC: Micro1 -> Micro2

1.2 GRPC: Micro2 -> Micro1

1.3 GRPC: WebProxy -> Micro1 , WebProxy -> Micro2

1.4 React: Browser -> Nginx(react-app) -> WebProxy

# 2. [GRPC LoadBalance](https://github.com/grpc/grpc/blob/master/doc/load-balancing.md)


# 3. How to test at localhost
```shell
    
    $ make all
    $ cd deploy && docker-compose up -d
    
    $ # browser http://localhost. and Click Button[Request Message]
    $ open http://localhost

    $ # test grpc service ok
    $ curl -i localhost:8080/health # webproxy
    $ curl -i localhost:18080/health # webproxy-1
    $ curl -i localhost:9090/health # micro1
    $ curl -i localhost:19090/health # micro1-1
    $ curl -i localhost:9091/health # micro2
    $ curl -i localhost:19091/health # micro2-1

    $ # test dns ok
    $ docker exec -it deploy_webproxy_1 nslookup micro1.micro.devops.dk.cc
    $ docker exec -it deploy_webproxy_1 nslookup micro2.micro.devops.dk.cc

```

