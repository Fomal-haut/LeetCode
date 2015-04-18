import java.util.ArrayList;
import java.util.List;


public class Solution {
	//双指针问题，主要是要理解题意后分析问题的解决思路
	//从List两头往中间进行筛选，选择较短的那条边替换为较长值，并进行面积计算
	//首先往内筛选，只有遇到长边，才有可能面积更大，其次，选择较短的那条边进行替换，是因为该边成为了面积计算的瓶颈
	public int maxResult = 0;
	public int maxArea(List<Integer> height) {
		int x = 0;
		int y = height.size() - 1;
		calcArea(x,y,height);
		
		while (x < y) {
			calcArea(x,y,height);
			if (height.get(x) < height.get(y)) {
				int k = x + 1;
				while ((k < y) && height.get(k) <= height.get(x)) {
					k++;
				}
				x = k;
			} else {
				int k = y - 1;
				while ((k > x) && height.get(k) <= height.get(y)) {
					k--;
				}
				y = k;
			}
		}
		return maxResult;
	}
	
	public void calcArea(int x, int y, List<Integer> height) {
		int temp = (y-x) * getMin(height.get(x), height.get(y));
		if (temp > maxResult) {
			maxResult = temp;
		}
	}
	
	public int getMin(int x, int y) {
		return x <= y ? x : y;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<Integer> tt = new ArrayList<>();
		tt.add(3);
		tt.add(2);
		tt.add(9);
		tt.add(10);
		tt.add(1);
		tt.add(2);
		System.out.println(solution.maxArea(tt));
	}
}
