-- 계정생성
CREATE USER khlove1
IDENTIFIED BY khlove1;

-- 접속 권한 부여
GRANT connect TO khlove1;

-- khlove1 에게 kh 계정에 있는
-- COFFEE 테이블을 검색(SELECT) 할 수 있는
-- 권한 부여

GRANT SELECT ON kh.COFFEE TO khlove1;
GRANT INSERT ON kh.COFFEE TO khlove1;
REVOKE SELECT,INSERT ON kh.COFFEE FROM khlove1;