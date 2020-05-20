# my-stuff-backend

### Create MySQL database and user
```sql
CREATE DATABASE IF NOT EXISTS my_stuff;
CREATE USER IF NOT EXISTS 'my_stuff'@'localhost' IDENTIFIED BY 'my_stuffSEA2020';
GRANT ALL PRIVILEGES ON my_stuff.* TO 'my_stuff'@'localhost';
```
