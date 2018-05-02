-- 사번을 입력 받아 해당 직원의 이름을 리턴하는 함수를 제작

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
    ID := &사번;
    DBMS_OUTPUT.PUT_LINE('이름 : ' || R_NAME(ID));
END;
/

-- 에러 찾을 때
SELECT * FROM ALL_ERRORS;


-- 실습문제 1
-- 사번을 입력 받아 해당 사원의 연봉을 계산하여 리턴하는 저장함수를 만들어 출력하시오
-- PL/SQL 에서 BONUS_CALC('&사번'); 처리시 연봉을 리턴하여 출력할 수 있도록
-- 만들어라.

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
    ID := '&사번';
    SELECT EMP_NAME
    INTO NAME
    FROM EMP
    WHERE EMP_ID = ID;
    DBMS_OUTPUT.PUT_LINE('사번 : ' || ID || ' /이름 : ' || NAME || ' /연봉 : ' || BONUS_CALC(ID));
END;
/

BEGIN
DBMS_OUTPUT.PUT_LINE('연봉 : ' || BONUS_CALC('&사번'));
END;
/

-- 실습문제 2
-- 사번을 전달받아 사원에게 특별보너스를 지급하려고 함
-- SALARY_BONUS('&사번','&특별보너스율');
-- 보너스율은 % 단위로 입력하여 처리 될 수 있도록 만들어라 (ex. 30% 입력시 -> 0.3)
-- PL/SQL에서 SALARY_BONUS 함수를 호출하여 값을 넘기게 되면
-- 지급되는 보너스 값이 얼마인지 출력되도록 하시오 (급여 x 보너스율)

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
    ID := '&사번';
    SB := '&보너스율';
    SELECT EMP_ID
    INTO NAME
    FROM EMP
    WHERE EMP_ID=ID;
    DBMS_OUTPUT.PUT_LINE('이름 : ' || NAME || ' /사번 : ' || ID || '보너스값 : ' || SALARY_BONUS(ID,SB));
END;
/
BEGIN
DBMS_OUTPUT.PUT_LINE('보너스값 : ' || SALARY_BONUS('&사번','&보너스율'));
END;
/
