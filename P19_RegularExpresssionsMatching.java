package CodingInterviews;

public class P19_RegularExpresssionsMatching {

    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;

        return matchCore(str, 0, pattern, 0);
    }

    public static boolean matchCore(char[] str, int s, char[] pattern, int p) {
        if (str.length <= s && pattern.length <= p)
            return true;//��ƥ������
        if (str.length > s && pattern.length <= p)
            return false;//ģʽ���ˣ��ַ�������
        //ģʽ��a*aû������ƥ�䴮�ɽ����ɲ�����

        if (p + 1 < pattern.length && pattern[p + 1] == '*') {//��ǰpattern����һ����*��ʱ

            //�ַ�������
            if (s >= str.length) return matchCore(str, s, pattern, p + 2);
            else {
                if (pattern[p] == str[s] || pattern[p] == '.') {
                    //��ǰλ��ƥ����ɣ��ƶ�����һ��ģʽ��
                    return matchCore(str, s + 1, pattern, p + 2)//pattern1= {'c','*','a'} str1={'c','a'}
                            || matchCore(str, s + 1, pattern, p);//pattern2= {'c','*','a'};str2={'c','c','c','a'}

                }

            }
        }
        //��ǰpattern����һ������*ʱ��
        if (s >= str.length)
            return false;
        else {
            if (str[s] == pattern[p] || pattern[p] == '.')
                return matchCore(str, s + 1, pattern, p + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        char [] pattern= {'a','.','a'};
        char [] str={'a','a','a'};
        System.out.println(match(str,pattern));

        char [] pattern1= {'c','*','a'};char [] str1={'c','a'};
        System.out.println(match(str1,pattern1));

        char [] pattern2= {'c','*','a'};
        char [] str2={'c','c','c','a'};
        System.out.println(match(str2,pattern2));
    }

}
