--------------------------------------------------------
--  파일이 생성됨 - 화요일-5월-05-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table SCHOOL_DEPARTMENTS
--------------------------------------------------------

  CREATE TABLE "HR"."SCHOOL_DEPARTMENTS" 
   (	"DEPARTMENT_NO" NUMBER(10,0), 
	"DEPARTMENT_NAME" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into HR.SCHOOL_DEPARTMENTS
SET DEFINE OFF;
Insert into HR.SCHOOL_DEPARTMENTS (DEPARTMENT_NO,DEPARTMENT_NAME) values (1000,'컴퓨터공학과');
Insert into HR.SCHOOL_DEPARTMENTS (DEPARTMENT_NO,DEPARTMENT_NAME) values (1001,'일어일본학과');
Insert into HR.SCHOOL_DEPARTMENTS (DEPARTMENT_NO,DEPARTMENT_NAME) values (1002,'글로벌IT학과');
Insert into HR.SCHOOL_DEPARTMENTS (DEPARTMENT_NO,DEPARTMENT_NAME) values (1003,'소프트웨어공학과');
--------------------------------------------------------
--  DDL for Index SYS_C006998
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."SYS_C006998" ON "HR"."SCHOOL_DEPARTMENTS" ("DEPARTMENT_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table SCHOOL_DEPARTMENTS
--------------------------------------------------------

  ALTER TABLE "HR"."SCHOOL_DEPARTMENTS" ADD PRIMARY KEY ("DEPARTMENT_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "HR"."SCHOOL_DEPARTMENTS" MODIFY ("DEPARTMENT_NAME" NOT NULL ENABLE);
