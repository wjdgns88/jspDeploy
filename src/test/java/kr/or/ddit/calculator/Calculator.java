package kr.or.ddit.calculator;

public class Calculator {
	
	public static void main(String[] args){
		Calculator cal = new Calculator();
		int addResult = cal.add(5, 6);
		
		if(addResult == 11){
			System.out.println("덧셈결과가 올바릅니다.");
		}else{
			System.out.println("덧셈결과가 틀렸습니다.");
		}
		
		////////////////////////////////////////////////////
		
		int minusResult = cal.minus(6, 4);
		if(minusResult == 2){
			System.out.println("뺄셈결과가 올바릅니다.");
		}else{
			System.out.println("뺄셈결과가 틀렸습니다.");
		}
		
		////////////////////////////////////////////////////
		
		int mulResult = cal.mul(8, 4);
		if(mulResult == 32){
			System.out.println("곱셈결과가 올바릅니다.");
		}else{
			System.out.println("곱셈결과가 틀렸습니다.");
		}

		////////////////////////////////////////////////////
		
		int divResult = cal.div(8, 4);
		if(divResult == 2){
			System.out.println("나누셈결과가 올바릅니다.");
		}else{
			System.out.println("나누셈결과가 틀렸습니다.");
		}
		
		divResult = cal.div(8, 0);
		if(divResult == 0){
			System.out.println("나누셈결과가 올바릅니다.");
		}else{
			System.out.println("나누셈결과가 틀렸습니다.");
		}

		
		
	}
	
	/**
	* Method : add
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC01
	* 변경이력 :
	* @param param1
	* @param param2
	* @return
	* Method 설명 : 계산기의 덧셈 기능
	*/
	public int add(int param1, int param2){
		return param1+param2;
	}
	
	/**
	* Method : minus
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC01
	* 변경이력 :
	* @param param1
	* @param param2
	* @return
	* Method 설명 : 계산기의 빼기 연산
	*/
	public int minus(int param1, int param2){
		return param1 - param2;
	}
	
	/**
	* Method : mul
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC01
	* 변경이력 :
	* @param param1
	* @param param2
	* @return
	* Method 설명 : 계산기의 곱셈 연산
	*/
	public int mul(int param1, int param2){
		return param1*param2;
	}
	
	/**
	* Method : div
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC01
	* 변경이력 :
	* @param param1
	* @param param2
	* @return
	* Method 설명 : 계산기 나누기 연산
	*/
	public int div(int param1, int param2){
		if(param2 == 0){
			return 0;
		}
		return param1/param2;
	}
	
	
	
	
	
	
	
	
}
