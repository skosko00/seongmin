package Calculator;

import java.util.StringTokenizer;

public class StringClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "J a v a P r o g r a m ";
		StringTokenizer str1 = new StringTokenizer(str, " ");
		StringBuffer str2 = new StringBuffer();
		char ch [] = new char[str1.countTokens()];
		
		for(int i=0;i<ch.length;i++)
		{
			ch[i]=str1.nextToken().charAt(0);
			if('a'<=ch[i]&&ch[i]<='z')
			{
				ch[i] -= 32;
			}
			str2.append(ch[i]);
		}
		System.out.println(str2);
	}

}
