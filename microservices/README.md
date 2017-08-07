# Microservices 

# 1. Services

1.1 GRPC: Micro1 -> Micro2

1.2 GRPC: Micro2 -> Micro1

1.3 GRPC: WebProxy -> Micro1 , WebProxy -> Micro2

# 2. [GRPC LoadBalance](https://github.com/grpc/grpc/blob/master/doc/load-balancing.md)


# 3. How to test at localhost
```shell
    $ make all
    $ cd deploy && docker-compose up -d
    $ curl -i localhost:8080/health # webproxy
    $ curl -i localhost:18080/health # webproxy-1
    $ curl -i localhost:9090/health # micro1
    $ curl -i localhost:19090/health # micro1-1
    $ curl -i localhost:9091/health # micro2
    $ curl -i localhost:19091/health # micro2-1
```
