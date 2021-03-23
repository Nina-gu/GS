package practice;

import java.util.*;

public class BinaryReversal {
	
	public static void main(String[] args) {
		BinaryReversal test = new BinaryReversal();
		System.out.println(test.binaryReversal("47"));
	}
	
	public int binaryReversal(String s) {
		int num = Integer.valueOf(s);
		String bit = Integer.toBinaryString(num);
		String bitWithPadding = String.format("%8s", bit).replaceAll(" ", "0"); 
		char[] bitChar = bitWithPadding.toCharArray();
		int result = 0;
		for (int i = 0; i < 8; i++) {
			if(bitChar[i] == '1') {
				result +=  (int)Math.pow(2, i);
			}
		}
		return result;
	}

}
