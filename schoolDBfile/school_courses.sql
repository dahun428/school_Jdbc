--------------------------------------------------------
--  ������ ������ - ȭ����-5��-05-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table SCHOOL_COURSES
--------------------------------------------------------

  CREATE TABLE "HR"."SCHOOL_COURSES" 
   (	"COURSE_NO" NUMBER(10,0), 
	"COURSE_NAME" VARCHAR2(50 BYTE), 
	"DEPARTMENT_NO" NUMBER(10,0), 
	"SUBJECT_NO" NUMBER(10,0), 
	"PROFESSOR_NO" NUMBER(10,0), 
	"NUMBEROFPEOPLE" NUMBER(38,0), 
	"ISFULLOFCOURSE" CHAR(1 BYTE) DEFAULT 'N', 
	"REGISTRATION_DATE" DATE DEFAULT SYSDATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into HR.SCHOOL_COURSES
SET DEFINE OFF;
Insert into HR.SCHOOL_COURSES (COURSE_NO,COURSE_NAME,DEPARTMENT_NO,SUBJECT_NO,PROFESSOR_NO,NUMBEROFPEOPLE,ISFULLOFCOURSE,REGISTRATION_DATE) values (200026,'�����Ϻ���',1001,100000,1,0,'N',to_date('20/05/05','RR/MM/DD'));
Insert into HR.SCHOOL_COURSES (COURSE_NO,COURSE_NAME,DEPARTMENT_NO,SUBJECT_NO,PROFESSOR_NO,NUMBEROFPEOPLE,ISFULLOFCOURSE,REGISTRATION_DATE) values (200001,'�Ϻ����� ����',1001,100000,1,1,'N',to_date('20/05/02','RR/MM/DD'));
Insert into HR.SCHOOL_COURSES (COURSE_NO,COURSE_NAME,DEPARTMENT_NO,SUBJECT_NO,PROFESSOR_NO,NUMBEROFPEOPLE,ISFULLOFCOURSE,REGISTRATION_DATE) values (200022,'��ǻ�Ͱ����� ����',1000,100020,21,0,'N',to_date('20/05/03','RR/MM/DD'));
Insert into HR.SCHOOL_COURSES (COURSE_NO,COURSE_NAME,DEPARTMENT_NO,SUBJECT_NO,PROFESSOR_NO,NUMBEROFPEOPLE,ISFULLOFCOURSE,REGISTRATION_DATE) values (200023,'����Ʈ������ ����',1000,100020,21,0,'N',to_date('20/05/03','RR/MM/DD'));
Insert into HR.SCHOOL_COURSES (COURSE_NO,COURSE_NAME,DEPARTMENT_NO,SUBJECT_NO,PROFESSOR_NO,NUMBEROFPEOPLE,ISFULLOFCOURSE,REGISTRATION_DATE) values (200027,'�߱��Ϻ���',1001,100000,1,10,'N',to_date('20/05/05','RR/MM/DD'));
--------------------------------------------------------
--  DDL for Index SYS_C007019
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."SYS_C007019" ON "HR"."SCHOOL_COURSES" ("COURSE_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SCHOOL_COURSES_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."SCHOOL_COURSES_UK1" ON "HR"."SCHOOL_COURSES" ("COURSE_NAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table SCHOOL_COURSES
--------------------------------------------------------

  ALTER TABLE "HR"."SCHOOL_COURSES" ADD CONSTRAINT "SCHOOL_COURSES_UK1" UNIQUE ("COURSE_NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "HR"."SCHOOL_COURSES" ADD PRIMARY KEY ("COURSE_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "HR"."SCHOOL_COURSES" ADD CHECK (ISFULLOFCOURSE IN ('Y','N')) ENABLE;
  ALTER TABLE "HR"."SCHOOL_COURSES" MODIFY ("REGISTRATION_DATE" NOT NULL ENABLE);
  ALTER TABLE "HR"."SCHOOL_COURSES" MODIFY ("ISFULLOFCOURSE" NOT NULL ENABLE);
  ALTER TABLE "HR"."SCHOOL_COURSES" MODIFY ("NUMBEROFPEOPLE" NOT NULL ENABLE);
  ALTER TABLE "HR"."SCHOOL_COURSES" MODIFY ("COURSE_NAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table SCHOOL_COURSES
--------------------------------------------------------

  ALTER TABLE "HR"."SCHOOL_COURSES" ADD FOREIGN KEY ("DEPARTMENT_NO")
	  REFERENCES "HR"."SCHOOL_DEPARTMENTS" ("DEPARTMENT_NO") ENABLE;
  ALTER TABLE "HR"."SCHOOL_COURSES" ADD FOREIGN KEY ("SUBJECT_NO")
	  REFERENCES "HR"."SCHOOL_SUBJECTS" ("SUBJECT_NO") ENABLE;
  ALTER TABLE "HR"."SCHOOL_COURSES" ADD FOREIGN KEY ("PROFESSOR_NO")
	  REFERENCES "HR"."SCHOOL_PROFESSORS" ("PROFESSOR_NO") ENABLE;