import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;


/**
 * ��8��8��Ĺ��������ϰڷŰ˸��ʺ�ʹ�䲻�ܻ��๥����
 * �����������ʺ󶼲��ܴ���ͬһ�С�ͬһ�л�ͬһб���ϣ����ж����ְڷ���
 * ����ʹ�õݹ鷽�����
 *
 */
public class NqueensAlgorithm {
	private static int N=10;        //ʹ�ó��������壬����֮���N�ʺ�����
    private static int count=0;            //���������
    private static String  result;
    private static int[] test = {1,3,4};
    
    public static void main(String[] args) {
        runTest();
        System.out.println(Arrays.toString(test));
        //select url from website where name = '�ٶ�';
        //insert into website (name.url,country) values ('�ٶ�','www.baidu.com','CN'); 
        //update website set url = 'google.us.com',country = 'USA' where name = '�ٶ�';
        //delete from website where name = '�ٶ�';
        
    }

    public void setN(int n){N = n;}

    public String returnResult(){return result;}

    public static void runTest(){
    	
    	HashMap map = new HashMap<Integer,Integer>();
    	
        Date begin =new Date();
        //��ʼ�����̣�ȫ����0
        short chess[][]=new short[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                chess[i][j]=0;
            }
        }
        putQueenAtRow(chess,0);
        Date end =new Date();
        result="��� " +N+ " �ʺ����⣬��ʱ��" +String.valueOf(end.getTime()-begin.getTime())+ "���룬��������"+count;
        System.out.print(result);
    };

    private static void putQueenAtRow(short[][] chess, int row) {
        /**
         * �ݹ���ֹ�жϣ����row==N����˵���Ѿ��ɹ��ڷ���8���ʺ�
         * ����������ֹ�ݹ�
         */
        if(row==N){
            count++;
           System.out.println("�� "+ count +" �ֽ⣺");
           for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
           System.out.print(chess[i][j]+" ");
            }
            System.out.println();
            }
            return;
        }

        short[][] chessTemp=chess.clone();

        /**
         * ����һ�е�ÿһ��λ�ó����ŷŻʺ�
         * Ȼ����״̬�������ȫ�����ִ�еݹ麯���ڷ���һ�лʺ�
         */
        for(int i=0;i<N;i++){
            //�ڷ���һ�еĻʺ�֮ǰҪ���������һ�аڷŵļ�¼����ֹ��Ⱦ����
            for(int j=0;j<N;j++){
                chessTemp[row][j]=0;
                chessTemp[row][i]=1;}

            if( isSafety( chessTemp,row,i ) ){
                putQueenAtRow(chessTemp,row+1);
            }
        }
    }

    private static boolean isSafety(short[][] chess,int row,int col) {
        //�ж����ϡ����ϡ������Ƿ�ȫ
        int step=1;
        while(row-step>=0){
            if(chess[row-step][col]==1)                //����
                return false;
            if(col-step>=0 && chess[row-step][col-step]==1)        //����
                return false;
            if(col+step<N && chess[row-step][col+step]==1)        //����
                return false;

            step++;
        }
        return true;
    }
}