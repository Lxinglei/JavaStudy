import java.util.ArrayList;
import java.util.List;

/**
 * Created by metror on 15/5/15.
 */
public class FindWay {
    //起点
    private Point originPoint;
    //终点
    private Point endPoint;
    //存放地图点信息的文件路径
    private String mapFile;
    //地图矩阵行列数
    private int num;
    /**
     *第一种构造方法，传入两个Point类型的数据
     * @param originPoint Point 起点坐标
     * @param endPoint Point 终点坐标
     */
    public FindWay(Point originPoint, Point endPoint) {
        this.originPoint = originPoint;
        this.endPoint = endPoint;
    }


    /**
     *第二种构造方法,传入六个参数，每三个构成一点
     * @param x1 int 起点x坐标
     * @param y1 int 起点y坐标
     * @param z1 int 起点z坐标
     * @param x2 int 终点x坐标
     * @param y2 int 终点y坐标
     * @param z2 int 终点z坐标
     */
    public FindWay(int x1, int y1, int z1, int x2, int y2, int z2) {
        this.originPoint = new Point(x1, y1, z1);
        this.endPoint = new Point(x2, y2, z1);
    }

    public List<Point> getPoints(){
        List<Point> list = new ArrayList<Point>();

        int[][] map= new MyUtil(getMapFile(), getNum()).FileToIntegerArray();
        Astar aStar=new Astar(map, getNum(), getNum());
        int flag=aStar.search(originPoint.getX(), originPoint.getY(),originPoint.getZ(), endPoint.getY(), endPoint.getY(), endPoint.getZ());
        if(flag==-1){
            System.out.println("传输数据有误！");
        }else if(flag==0){
            System.out.println("没找到！");
        }else{
            for(int x=0;x< aStar.getRow();x++){
                for(int y=0;y<aStar.getColumn();y++){
                    if(map[x][y]==1){
                        System.out.print("□");
                    }else if(map[x][y]==0){
                        System.out.print("◆");
                    }else if(map[x][y]==2){
                        System.out.print("※");//输出搜索路径
                        //String zuobiao = "("+x+","+y +")";
                        Point point = new Point(x, y, 0);   //z坐标暂时设置为0,实现三维后再行改写
                        // if (i%2 == 0){
                        list.add(point);
                    }
                }
                System.out.println();

            }
        }
        System.out.println("搜索完毕,ok");


        return list;
    }

    /**
     *获取起点坐标
     * @return Point 终点坐标
     */
    public Point getOriginPoint() {
        return originPoint;
    }

    /**
     * 设置起点坐标
     * @param originPoint
     */
    public void setOriginPoint(Point originPoint) {
        this.originPoint = originPoint;
    }

    /**
     *获取终点坐标
     * @return Point 终点坐标
     */
    public Point getEndPoint() {
        return endPoint;
    }

    /**
     * 设置终点坐标
     * @param endPoint
     */
    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    /**
     * 获取地图点坐标文件的路径
     * @return String mapFile
     */
    public String getMapFile() {
        return mapFile;
    }

    /**
     *设置地图点文件的路径
     * @param mapFile String 包含地图矩阵点的文件的路径
     */
    public void setMapFile(String mapFile, int num) {
        this.num = num;
        this.mapFile = mapFile;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
