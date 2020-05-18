SET SERVEROUTPUT ON;

CREATE TABLE TestUsers 
(
Id varchar2(20) primary key,
Name varchar2(50),
Age number
);

INSERT INTO TestUsers(Id, Name, Age) VALUES ('DY', 'Dmitry Yaniuk', 19);
INSERT INTO TestUsers(Id, Name, Age) VALUES ('IZ', 'Igor Zolotnik', 22);

SELECT * FROM TestUsers;

CREATE OR REPLACE PROCEDURE AddAndReturnTotalUsers
(
user_id TestUsers.Id%type, 
user_name TestUsers.Name%type, 
user_age TestUsers.Age%type,
total_users OUT number
) AS
begin
    INSERT INTO TestUsers(Id, Name, Age) VALUES (user_id, user_name, user_age);
    commit;
    SELECT COUNT(*) INTO total_users FROM TestUsers;
end;

DECLARE counter number;
begin
    AddAndReturnUser('RO', 'Oleg Ryazin', 20, counter);
    DBMS_OUTPUT.PUT_LINE(counter);
end;