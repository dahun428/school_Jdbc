--------------------------------------------------------
--  파일이 생성됨 - 화요일-5월-05-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table SCHOOL_REGISTRATIONOFCOURSE
--------------------------------------------------------

  CREATE TABLE "HR"."SCHOOL_REGISTRATIONOFCOURSE" 
   (	"REGISTRATION_NO" NUMBER(10,0), 
	"COURSE_NO" NUMBER(10,0), 
	"STUDENT_NO" NUMBER(10,0), 
	"ISCANCLED" CHAR(1 BYTE) DEFAULT 'n', 
	"ISCOMPLETED" CHAR(1 BYTE) DEFAULT 'n', 
	"SCORE" NUMBER(20,0) DEFAULT 0, 
	"REGISTRATIONDATE" DATE DEFAULT sysdate
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into HR.SCHOOL_REGISTRATIONOFCOURSE
SET DEFINE OFF;
Insert into HR.SCHOOL_REGISTRATIONOFCOURSE (REGISTRATION_NO,COURSE_NO,STUDENT_NO,ISCANCLED,ISCOMPLETED,SCORE,REGISTRATIONDATE) values (1000012,200027,10000,'y','n',0,to_date('20/05/05','RR/MM/DD'));
Insert into HR.SCHOOL_REGISTRATIONOFCOURSE (REGISTRATION_NO,COURSE_NO,STUDENT_NO,ISCANCLED,ISCOMPLETED,SCORE,REGISTRATIONDATE) values (1000010,200027,10022,'n','n',0,to_date('20/05/05','RR/MM/DD'));
Insert into HR.SCHOOL_REGISTRATIONOFCOURSE (REGISTRATION_NO,COURSE_NO,STUDENT_NO,ISCANCLED,ISCOMPLETED,SCORE,REGISTRATIONDATE) values (1000011,200027,10022,'n','n',0,to_date('20/05/05','RR/MM/DD'));
Insert into HR.SCHOOL_REGISTRATIONOFCOURSE (REGISTRATION_NO,COURSE_NO,STUDENT_NO,ISCANCLED,ISCOMPLETED,SCORE,REGISTRATIONDATE) values (1000000,200001,10000,'n','n',50,to_date('20/05/03','RR/MM/DD'));
Insert into HR.SCHOOL_REGISTRATIONOFCOURSE (REGISTRATION_NO,COURSE_NO,STUDENT_NO,ISCANCLED,ISCOMPLETED,SCORE,REGISTRATIONDATE) values (1000001,200022,10000,'n','n',60,to_date('20/05/03','RR/MM/DD'));
Insert into HR.SCHOOL_REGISTRATIONOFCOURSE (REGISTRATION_NO,COURSE_NO,STUDENT_NO,ISCANCLED,ISCOMPLETED,SCORE,REGISTRATIONDATE) values (1000003,200023,10021,'y','y',80,to_date('20/05/03','RR/MM/DD'));
--------------------------------------------------------
--  DDL for Index SYS_C007031
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."SYS_C007031" ON "HR"."SCHOOL_REGISTRATIONOFCOURSE" ("REGISTRATION_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table SCHOOL_REGISTRATIONOFCOURSE
--------------------------------------------------------

  ALTER TABLE "HR"."SCHOOL_REGISTRATIONOFCOURSE" ADD PRIMARY KEY ("REGISTRATION_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "HR"."SCHOOL_REGISTRATIONOFCOURSE" ADD CHECK (isCompleted in('y','n')) ENABLE;
  ALTER TABLE "HR"."SCHOOL_REGISTRATIONOFCOURSE" ADD CHECK (isCancled in ('y','n')) ENABLE;
  ALTER TABLE "HR"."SCHOOL_REGISTRATIONOFCOURSE" MODIFY ("REGISTRATIONDATE" NOT NULL ENABLE);
  ALTER TABLE "HR"."SCHOOL_REGISTRATIONOFCOURSE" MODIFY ("SCORE" NOT NULL ENABLE);
  ALTER TABLE "HR"."SCHOOL_REGISTRATIONOFCOURSE" MODIFY ("ISCOMPLETED" NOT NULL ENABLE);
  ALTER TABLE "HR"."SCHOOL_REGISTRATIONOFCOURSE" MODIFY ("ISCANCLED" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table SCHOOL_REGISTRATIONOFCOURSE
--------------------------------------------------------

  ALTER TABLE "HR"."SCHOOL_REGISTRATIONOFCOURSE" ADD FOREIGN KEY ("COURSE_NO")
	  REFERENCES "HR"."SCHOOL_COURSES" ("COURSE_NO") ENABLE;
  ALTER TABLE "HR"."SCHOOL_REGISTRATIONOFCOURSE" ADD FOREIGN KEY ("STUDENT_NO")
	  REFERENCES "HR"."SCHOOL_STUDENTS" ("STUDENT_NO") ENABLE;
