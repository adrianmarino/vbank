CREATE DATABASE IF NOT EXISTS vbank_test CHARACTER SET utf8;
CREATE DATABASE IF NOT EXISTS vbank_prod CHARACTER SET utf8;

GRANT ALL ON `vbank_test`.* to 'vbank'@'%' identified by '1234';
GRANT ALL ON `vbank_prod`.* to 'vbank'@'%' identified by '1234';
