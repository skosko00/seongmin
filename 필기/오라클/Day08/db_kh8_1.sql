
CREATE TABLE COFFEE
(
    PRODUCT_NAME VARCHAR2(20) PRIMARY KEY,
    PRICE NUMBER NOT NULL,
    COMPANY VARCHAR2(20) NOT NULL
);

INSERT INTO COFFEE VALUES('맥심커피', 30000,'MAXIM');
INSERT INTO COFFEE VALUES('카누커피', 50000,'MAXIM');
INSERT INTO COFFEE VALUES('네스카페커피', 40000,'NESCAFE');
COMMIT;

SELECT * FROM COFFEE;