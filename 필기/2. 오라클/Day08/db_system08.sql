-- ��������
CREATE USER khlove1
IDENTIFIED BY khlove1;

-- ���� ���� �ο�
GRANT connect TO khlove1;

-- khlove1 ���� kh ������ �ִ�
-- COFFEE ���̺��� �˻�(SELECT) �� �� �ִ�
-- ���� �ο�

GRANT SELECT ON kh.COFFEE TO khlove1;
GRANT INSERT ON kh.COFFEE TO khlove1;
REVOKE SELECT,INSERT ON kh.COFFEE FROM khlove1;