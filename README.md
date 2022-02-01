# Fyber homework


Docker based (local):
1. Build a consul client with get/post options
2. Add Jenkins with:
   1. CI build consul service from #1
   2. CD - Start Consul and service
3. Register service to consul and get/post keys

Swagger UI is available on http://localhost:8081/swagger-ui/index.html#

---
## Service
Based on Java/Spring for using Actuator, Consul discovery functionalities 
Assumes consul is available on startup

Uses swagger for tests
http://localhost:8081/swagger-ui/index.html
### Set key:
```
curl -X 'POST' \
  'http://localhost:8081/setKey/?keyName=test&value=me' \
  -H 'accept: */*' \
  -d ''
  ```

### get key
```
url -X 'GET' \
  'http://localhost:8081/getKey/test' \
  -H 'accept: */*'
```


---
### Docker build
```
docker build -t ittiel/fyber-consul-service:1.0.0 . 
```
 ### Docker run
```
docker run    -p 8081:8081 --link consul:consul ittiel/fyber-consul-service:1.0.0```