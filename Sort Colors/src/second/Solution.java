package second;

public class Solution {
	//discussion中看到的算法
	//和1差不多，这里的指针也指向的是1序列的开头和2序列的开头，但是不同的是这里2序列开头的指针运行方向和first Solution相反，后者是从末端开始往前
	public void sortColors(int[] A) {
	    int one = 0; 
	    int two = 0;
	    for(int i=0;i<A.length;i++){
	        if(A[i]==0){
	            A[i] = 2;  //这里需要换两次，目的是为了把0添加进去
	            A[two] = 1;
	            A[one] = 0;
	            one++;
	            two++;
	        }
	        else if(A[i]==1){
	            A[i] = 2;
	            A[two] = 1;
	            two++;
	        }
	    }
	}
}
