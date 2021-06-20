USE master
GO
 --Drop the database if it already exists
IF  EXISTS (

       SELECT name
             FROM sys.databases
             WHERE name = N'SchoolDB '
)

DROP DATABASE SchoolDB
GO
CREATE DATABASE SchoolDB
GO

USE SchoolDB
GO

CREATE TABLE Students
(
       EnrollId                VARCHAR(50) PRIMARY KEY,
       FirstName           NVARCHAR(50),
       LastName           NVARCHAR(50),
       Age                      INT
)

INSERT Students VALUES ('GC00123',N'Huy',N'Nguyễn Xuân',19)

INSERT Students VALUES ('GC00125',N'Thảo',N'Hoàng Thu',18)