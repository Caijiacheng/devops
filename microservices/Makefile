
all: exchange micro1 micro2 webproxy


REGISTRY=devops
REGISTRY_MICRO=devops/micro


.PHONY: images
images:
	@echo "make JDK8 Image"
	@cd images/jdk8 && docker build -t $(REGISTRY)/oraclejdk8 .

.PHONY: exchange
exchange: 
	@echo "protoc install"
	@cd exchange/protoc && mvn install
	

.PHONY: micro1
micro1: exchange images
	@echo "micro1 install"
	@cd micro1 && mvn package -Dmaven.test.skip=true 
	@echo "docker build"
	@cd micro1 && mv target/micro1-0.0.1-SNAPSHOT.jar target/app.jar && cp Dockerfile target
	@cd micro1/target && docker build -t $(REGISTRY_MICRO)/micro1 .
	

.PHONY: micro2
micro2: exchange images
	@echo "micro2 install"
	@cd micro2 && mvn package -Dmaven.test.skip=true 
	@echo "docker build"
	@cd micro2 && mv target/micro2-0.0.1-SNAPSHOT.jar target/app.jar && cp Dockerfile target
	@cd micro2/target && docker build -t $(REGISTRY_MICRO)/micro2 .

.PHONY: webproxy
webproxy: exchange images
	@echo "webproxy install"
	@cd webproxy && mvn package -Dmaven.test.skip=true 
	@echo "docker build"
	@cd webproxy && mv target/webproxy-0.0.1-SNAPSHOT.jar target/app.jar && cp Dockerfile target
	@cd webproxy/target && docker build -t $(REGISTRY_MICRO)/webproxy .

clean:
	@echo "clean"
	@cd exchange/protoc && mvn clean
	@cd micro1 && mvn clean
	@cd micro2 && mvn clean
	@cd webproxy && mvn clean
