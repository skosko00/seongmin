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
				throw new CharCheckException("체크할 문자열 안에 공백 포함 할 수 없습니다.");
			}
			else if('a'<=s.charAt(i) && s.charAt(i)<='z' || 'A'<=s.charAt(i) && s.charAt(i)<='Z')
			{
				count++;
			}
		}
		return count;
	}
}
