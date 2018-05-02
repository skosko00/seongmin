-- ����� �Է� �޾� �ش� ������ �̸��� �����ϴ� �Լ��� ����

CREATE FUNCTION R_NAME(ID EMP.EMP_ID%TYPE)
RETURN EMP.EMP_NAME%TYPE
IS
    NAME EMP.EMP_NAME%TYPE;
BEGIN
    SELECT EMP_NAME
    INTO NAME
    FROM EMP
    WHERE EMP_ID = ID;
    RETURN NAME;
END;
/

SELECT R_NAME('220') FROM DUAL;

DECLARE
    ID EMP.EMP_ID%TYPE;
BEGIN
    ID := &���;
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || R_NAME(ID));
END;
/

-- ���� ã�� ��
SELECT * FROM ALL_ERRORS;


-- �ǽ����� 1
-- ����� �Է� �޾� �ش� ����� ������ ����Ͽ� �����ϴ� �����Լ��� ����� ����Ͻÿ�
-- PL/SQL ���� BONUS_CALC('&���'); ó���� ������ �����Ͽ� ����� �� �ֵ���
-- ������.

CREATE FUNCTION BONUS_CALC(ID EMP.EMP_ID%TYPE)
RETURN EMP.SALARY%TYPE
IS
    E_SALARY EMP.SALARY%TYPE;
BEGIN
    SELECT SALARY*12
    INTO E_SALARY
    FROM EMP
    WHERE EMP_ID=ID;
    RETURN E_SALARY;
END;
/

DECLARE
    ID EMP.EMP_ID%TYPE;
    NAME EMP.EMP_NAME%TYPE;
BEGIN
    ID := '&���';
    SELECT EMP_NAME
    INTO NAME
    FROM EMP
    WHERE EMP_ID = ID;
    DBMS_OUTPUT.PUT_LINE('��� : ' || ID || ' /�̸� : ' || NAME || ' /���� : ' || BONUS_CALC(ID));
END;
/

BEGIN
DBMS_OUTPUT.PUT_LINE('���� : ' || BONUS_CALC('&���'));
END;
/

-- �ǽ����� 2
-- ����� ���޹޾� ������� Ư�����ʽ��� �����Ϸ��� ��
-- SALARY_BONUS('&���','&Ư�����ʽ���');
-- ���ʽ����� % ������ �Է��Ͽ� ó�� �� �� �ֵ��� ������ (ex. 30% �Է½� -> 0.3)
-- PL/SQL���� SALARY_BONUS �Լ��� ȣ���Ͽ� ���� �ѱ�� �Ǹ�
-- ���޵Ǵ� ���ʽ� ���� ������ ��µǵ��� �Ͻÿ� (�޿� x ���ʽ���)

CREATE FUNCTION SALARY_BONUS(ID EMP.EMP_ID%TYPE, SB EMP.BONUS%TYPE)
RETURN EMP.BONUS%TYPE
IS
    BONUS EMP.BONUS%TYPE;
BEGIN
    SELECT SALARY*(SB*0.01)
    INTO BONUS
    FROM EMP
    WHERE EMP_ID=ID;
    RETURN BONUS;
END;
/

DECLARE
    NAME EMP.EMP_NAME%TYPE;
    ID EMP.EMP_ID%TYPE;
    SB EMP.BONUS%TYPE;
BEGIN
    ID := '&���';
    SB := '&���ʽ���';
    SELECT EMP_ID
    INTO NAME
    FROM EMP
    WHERE EMP_ID=ID;
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || NAME || ' /��� : ' || ID || '���ʽ��� : ' || SALARY_BONUS(ID,SB));
END;
/
BEGIN
DBMS_OUTPUT.PUT_LINE('���ʽ��� : ' || SALARY_BONUS('&���','&���ʽ���'));
END;
/
