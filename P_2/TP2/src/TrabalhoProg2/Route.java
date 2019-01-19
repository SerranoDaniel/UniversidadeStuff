package TrabalhoProg2;


import java.util.ArrayList  ;

public class Route implements IRoute{
    public  int x, y, xend, yend;
    public ArrayList<String> routeList = new ArrayList<String>();


    public void endPos(ArrayList<ArrayList<String>> tab, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (tab.get(i).get(j).equals("E")) {
                    this.yend = i;
                    this.xend = j;
                }
            }
        }
    }

    public void startPos(ArrayList<ArrayList<String>> tab, int row, int col){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(tab.get(i).get(j).equals("S")){
                    this.y = i;
                    this.x = j;
                }
            }
        }

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getXend(){
        return xend;
    }

    public int getYend(){
        return yend;
    }



    public void moveRoute(String move) {
        this.routeList.add(move);
    }

    public int getCol(){
        return this.x;
    }

    public int getRow(){
        return this.y;
    }


    public int getCol(int i, Maze maze){
        ArrayList<ArrayList<String>> tab = maze.getMaze();
        return tab.get(0).indexOf(i);
    }

    public int getRow(int i, Maze maze){
        ArrayList<ArrayList<String>> tab = maze.getMaze();
        return tab.get(0).indexOf(i);
    }

    public int getLength(){
        return routeList.size();
    }
}
