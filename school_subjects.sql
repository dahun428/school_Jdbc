--------------------------------------------------------
--  파일이 생성됨 - 화요일-5월-05-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table SCHOOL_SUBJECTS
--------------------------------------------------------

  CREATE TABLE "HR"."SCHOOL_SUBJECTS" 
   (	"SUBJECT_NO" NUMBER(10,0), 
	"SUBJECT_NAME" VARCHAR2(50 BYTE), 
	"DEPARTMENT_NO" NUMBER(10,0), 
	"REGISTRATION_DATE" DATE DEFAULT SYSDATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into HR.SCHOOL_SUBJECTS
SET DEFINE OFF;
Insert into HR.SCHOOL_SUBJECTS (SUBJECT_NO,SUBJECT_NAME,DEPARTMENT_NO,REGISTRATION_DATE) values (100000,'일본어',1001,to_date('20/05/02','RR/MM/DD'));
Insert into HR.SCHOOL_SUBJECTS (SUBJECT_NO,SUBJECT_NAME,DEPARTMENT_NO,REGISTRATION_DATE) values (100020,'컴퓨터',1000,to_date('20/05/03','RR/MM/DD'));
Insert into HR.SCHOOL_SUBJECTS (SUBJECT_NO,SUBJECT_NAME,DEPARTMENT_NO,REGISTRATION_DATE) values (100021,'소프트웨어',1000,to_date('20/05/05','RR/MM/DD'));
--------------------------------------------------------
--  DDL for Index SYS_C007012
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."SYS_C007012" ON "HR"."SCHOOL_SUBJECTS" ("SUBJECT_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SCHOOL_SUBJECTS_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."SCHOOL_SUBJECTS_UK1" ON "HR"."SCHOOL_SUBJECTS" ("SUBJECT_NAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table SCHOOL_SUBJECTS
--------------------------------------------------------

  ALTER TABLE "HR"."SCHOOL_SUBJECTS" ADD CONSTRAINT "SCHOOL_SUBJECTS_UK1" UNIQUE ("SUBJECT_NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "HR"."SCHOOL_SUBJECTS" ADD PRIMARY KEY ("SUBJECT_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "HR"."SCHOOL_SUBJECTS" MODIFY ("REGISTRATION_DATE" NOT NULL ENABLE);
  ALTER TABLE "HR"."SCHOOL_SUBJECTS" MODIFY ("SUBJECT_NAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table SCHOOL_SUBJECTS
--------------------------------------------------------

  ALTER TABLE "HR"."SCHOOL_SUBJECTS" ADD FOREIGN KEY ("DEPARTMENT_NO")
	  REFERENCES "HR"."SCHOOL_DEPARTMENTS" ("DEPARTMENT_NO") ENABLE;
