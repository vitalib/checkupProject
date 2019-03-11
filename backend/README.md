## To start backend
```bash
docker-compose -f docker-compose.dev.yml up -d
cd backend
mvn clean install exec:java
```