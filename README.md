# VBank

## Setup
Create db for each envinronmenr (dev, test and prod)

```bash
mysql -u root -p <  db/setup_schema.sql
```

2. Run test
Run test using test db.
```bash
gradle test
```

3. Start app (env: dev)
Run app using dev db.
```bash
gradle bootRun
```

3. Generate production war
```bash
gradle war -Penv=prod
```
**Note:** If use tomcat, run the server with this command:
```bash
SPRING_PROFILES_ACTIVE=prod catalina.sh start
```
