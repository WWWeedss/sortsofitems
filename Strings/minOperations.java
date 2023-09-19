public class minOperations {
    public int min_operations(String[] logs){
        int result=0;
        for(int i=0;i<logs.length;i++){
            result+=judge(logs[i]);
            result= Math.max(result, 0);
        }
        return result;
    }
    public static int judge(String a) {
        if (a.equals("../")) return -1;
        else if(a.equals("./")) return 0;
        else return 1;
    }
}
