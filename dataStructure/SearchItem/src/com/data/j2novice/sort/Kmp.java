package com.data.j2novice.sort;

 
//KMP���ַ��������㷨

class KMP_T{
    private String pat;
    private int[][] dfa;
    public  KMP_T(String pat){//��ģʽ�ַ�����dfa
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[M][R];
        dfa[0][pat.charAt(0)] = 1;//������Ĭ��Ϊ0
        //�ƹ�һ������״̬�Զ������������һ��״̬������j+1���ѣ�����������һ��״̬Ӧ����dfa[X][pat.charAt(j)]
        for(int X=0,j=1;j<M;j++){
            System.out.println(X);
            for(int c=0;c<R;c++)
                dfa[j][c] = dfa[X][c];
            dfa[j][pat.charAt(j)] = j+1;
            X = dfa[X][pat.charAt(j)];//Ҫ�ú�������仰��

        }   
    }
    public int search(String txt){
        int i,j=0,N = txt.length(),M=pat.length();
        for(i=0;i<N&&j<M;i++)
            j = dfa[j][txt.charAt(i)];
        if(j == M)
            return i-M;
        else
            return N;

    }
}

public class Kmp {
    public static void main(String[] args) {
        //String pat = "abacab";//0 0 1 0 1
        String pat = "ababac";//0 0 1 2 3
        KMP_T kmp = new KMP_T(pat);
        System.out.println(kmp.search("abababababababacabac"));
    }

}