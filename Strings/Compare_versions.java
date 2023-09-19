import java.util.Arrays;
import java.util.List;

public class Compare_versions {
    public int CompareVersions(String version1,String version2){
        String[] store_version1=version1.split("\\.");
        String[] store_version2=version2.split("\\.");
        int head_1=0,head_2=0;
        while(head_1<store_version1.length&&head_2<store_version2.length){
            int temp_value1=vary_str(store_version1[head_1]);
            int temp_value2=vary_str(store_version2[head_2]);
            if(temp_value1<temp_value2)return -1;
            else if(temp_value1>temp_value2)return 1;
            else{
                head_1++;
                head_2++;
            }
        }
        if(head_1==store_version1.length){
            for(int i=head_2;i<store_version2.length;i++){
                if(vary_str(store_version2[i])>0)return -1;
            }
        }
        for(int i=head_1;i<store_version1.length;i++){
            if(vary_str(store_version1[i])>0)return 1;
        }
        return 0;//这一段让我想起了merge
    }
    public static int vary_str(String numbers){
        int first_index=-1;
        for(int i=0;i<numbers.length();i++){
            if(numbers.charAt(i)!='0'){
                first_index=i;
                break;
            }
        }
        if(first_index==-1){
            return 0;
        }
        else{
            return Integer.parseInt(numbers.substring(first_index));
        }
    }//忽略前导0，直接返回后面的数字的int形式
    public static void main(String[] args){
        System.out.println(vary_str("2"));
    }
}
