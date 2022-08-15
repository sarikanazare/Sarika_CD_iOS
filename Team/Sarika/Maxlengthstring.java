
public class Maxlengthstring {
	public static void main(String[] args) {
		
		String[] a = {"aaaaaaaaa","hhhh","nnn"};
		int max=a[0].length();
		int maxindex ;
		int i=0;
		for(i=1;i<a.length;i++){
			String s=a[i];
			int n=s.length();
			if(n>max) {
				max=n;
				maxindex=i;
				
			}
			
		}
		System.out.println("max length is"+max);
		System.out.println("word is"+a[i]);
	}

}
