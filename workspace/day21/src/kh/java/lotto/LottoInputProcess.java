package kh.java.lotto;

public class LottoInputProcess{
	LottoInputProcess() {}
	public void LottoInput1(int n)
	{
		if(!(1<=n && n<=45))
		{
			throw new LottoInputException("1~45������ ���� �ƴմϴ�.");
		}

	}
}
