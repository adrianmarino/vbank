# VBank

## Setup
Create db for each environment (dev/test/prod)

```bash
mysql -u root -p <  db/setup_schema.sql
```

## Run tests
Run tests using a test db.
```bash
gradle test
```

## Start app (env: dev)
Run app using dev db.
```bash
gradle bootRun
```

## Generate production war
```bash
gradle war -Penv=prod
```
**Note:** If use tomcat, run the server with this command:
```bash
SPRING_PROFILES_ACTIVE=prod catalina.sh start
```
