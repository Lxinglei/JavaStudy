import java.util.List;

/**
 * Created by metror on 15/5/15.
 */
public class TestFindWay {
    public static void main(String[] args){
        Point originPoint = new Point(1, 1, 0); //初始化起点坐标
        Point endPoint = new Point(8, 8, 0); //初始化终点坐标

        FindWay findWay = new FindWay(originPoint, endPoint);   //创建FindWay实例,也可以换成FindWay findWay = new FindWay(1,1,0,8,8,0);

        findWay.setMapFile("/Users/metror/Desktop/data.map", 10); //设置矩阵文件和矩阵行数,必须设置这一步，否则会抛出异常

        List<Point> lists = findWay.getPoints();    //获取查找到的点，存放在lists里面

        for (int i=0; i<lists.size(); i++){
            System.out.println("第" + i + "个点: (" + lists.get(i).getX() + "," + lists.get(i).getY() + "," + lists.get(i).getZ() + ")");
        }
        //若只是为了调试可以直接输出lists,toString已经重载完成，输出的格式比较简单
        System.out.println("获取到的列表: " + lists);
    }
}
