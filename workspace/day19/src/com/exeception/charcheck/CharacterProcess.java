package com.exeception.charcheck;

public class CharacterProcess {

	public CharacterProcess() {}
	
	public int countAlpha(String s) throws CharCheckException
	{
		int count=0;
		for(int i =0; i<s.length(); i++)
		{
			if(s.charAt(i)== ' ')
			{
				throw new CharCheckException("üũ�� ���ڿ� �ȿ� ���� ���� �� �� �����ϴ�.");
			}
			else if('a'<=s.charAt(i) && s.charAt(i)<='z' || 'A'<=s.charAt(i) && s.charAt(i)<='Z')
			{
				count++;
			}
		}
		return count;
	}
}
