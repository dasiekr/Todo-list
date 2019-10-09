DROP TABLE IF EXISTS auth_user_role;
DROP TABLE IF EXISTS auth_role;
DROP TABLE IF EXISTS auth_user;

CREATE TABLE auth_role (
    auth_role_id int(11) NOT NULL AUTO_INCREMENT,
    role_name varchar(255) DEFAULT NULL,
    role_desc varchar(255) DEFAULT NULL,
    PRIMARY KEY (auth_role_id)
);

INSERT INTO auth_role VALUES (1, "SUPER_USER", "This user has ultimate rights for everything");
INSERT INTO auth_role VALUES (2, "ADMIN_USER", "This user has admin right for administrative work");
INSERT INTO auth_role VALUES (3, "SITE_USER", "This user has access to site, after login - normal user");

CREATE TABLE auth_user (
    auth_user_id int(11) NOT NULL AUTO_INCREMENT,
    user_name varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    PRIMARY KEY (auth_user_id)
);

CREATE TABLE auth_user_role (
    auth_user_id int(11) NOT NULL,
    auth_role_id int(11) NOT NULL,
    PRIMARY KEY (auth_user_id, auth_role_id),
    KEY FK_user_role (auth_role_id),
    CONSTRAINT FK_auth_user FOREIGN KEY (auth_user_id) REFERENCES auth_user (auth_user_id),
    CONSTRAINT FK_auth_user_role FOREIGN KEY (auth_role_id) REFERENCES auth_role (auth_role_id)
);

INSERT INTO auth_user(auth_user_id, user_name, password) VALUES (1, "adamek97", "pass");

INSERT INTO auth_user_role(auth_user_id, auth_role_id) VALUES ("1", "1");

INSERT INTO auth_user_role(auth_user_id, auth_role_id) VALUES ("1", "2");

INSERT INTO auth_user_role(auth_user_id, auth_role_id) VALUES ("1", "3");