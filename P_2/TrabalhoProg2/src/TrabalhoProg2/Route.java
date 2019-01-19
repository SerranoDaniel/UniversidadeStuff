package TrabalhoProg2;


import java.util.ArrayList  ;

public class Route{
    public  int x, y;
    public ArrayList<String> routeList = new ArrayList<String>();

    public void startPos(ArrayList<ArrayList<String>> tab, int row, int col){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(tab.get(i).get(j).equals("S")){
                    this.y = tab.indexOf(tab.get(i));
                    this.x = tab.indexOf(tab.get(j));
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



    void moveRoute(String move) {
        this.routeList.add(move);
    }

    int getCol(){
        return this.x;
    }

    int getRow(){
        return this.y;
    }

    ///////////perguntar ao kebab o q e supost devolver
    String getCol(int i, Maze maze){
        ArrayList<ArrayList<String>> tab = maze.getMaze();
        return tab.get(0).get(i);
    }

    //int getRow(int i, Maze maze){}

    int getLength(){
        return routeList.size();
    }
}
