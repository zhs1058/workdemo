package algo;

import java.util.ArrayList;
import java.util.List;

public class kuohaoshengcheng {

	static List<String> res = new ArrayList<>();
	public static void main(String[] args) {
		List<String> l = generateParenthesis(3);
		System.out.print(l.toString());
	}
	
    
    public static List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private static void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // �������Ŷ���ʣ���ˣ��ݹ���ֹ
            res.add(curStr);
            System.out.print(curStr);
            return;
        }

        if (left > 0) { // ��������Ż�ʣ��Ļ�������ƴ��������
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) { // ���������ʣ�����������ʣ��Ļ�������ƴ��������
            dfs(left, right - 1, curStr + ")");
        }
    }


}
