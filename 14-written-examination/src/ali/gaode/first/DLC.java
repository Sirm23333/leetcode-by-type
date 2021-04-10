package ali.gaode.first;

public class DLC {
    private static volatile DLC dlc ;

    private DLC(){

    }
    public static DLC getInstance(){
        if(dlc == null){
            synchronized (DLC.class){
                if(dlc == null){
                    dlc = new DLC();
                }
            }
        }
        return dlc;
    }

    public static void main(String[] args) {
        DLC dlc = DLC.getInstance();
        System.out.println(dlc);
    }
}
