import java.util.Queue;
import java.util.Random;

class Maze {
    public final int dimension  = 100;
    public int start_x = dimension/2;
    public int start_y = dimension/2;

    char[][] theMaze = new char[dimension][dimension];

    public Maze() {
        for(int i=0;i<dimension;i++) {
            for(int j=0;j<dimension;j++) {
                theMaze[i][j]=' ';
            }
        }

        initializeMaze();

    }

    private void initializeMaze() {
        Random myRand=new Random();

        //Put in random walls
        for(int i=0;i<dimension;i++) {
            for(int j=0; j<dimension;j++) {
                if(myRand.nextInt(100)>=65) {
                    theMaze[i][j]='X';
                }
            }
        }

        //Pick a random goal
        int goal_x=myRand.nextInt(dimension - 4) + 2;
        int goal_y=myRand.nextInt(dimension - 4) + 2;
        theMaze[goal_x][goal_y]='C';
        //theMaze[dimension - 3][dimension - 3] = 'C';
      //  goal_x = dimension -3;
      //  goal_y = dimension -3;
        if (theMaze[goal_x + 1][goal_y] == 'X') {
            theMaze[goal_x + 1][goal_y] = ' ';

        }
        if (theMaze[goal_x][goal_y + 1] == 'X') {
            theMaze[goal_x][goal_y + 1] = ' ';

        }
        if (theMaze[goal_x - 1][goal_y] == 'X') {
            theMaze[goal_x - 1][goal_y] = ' ';

        }
        if (theMaze[goal_x][goal_y - 1] == 'X') {
            theMaze[goal_x][goal_y - 1] = ' ';

        }
        if (theMaze[goal_x + 2][goal_y] == 'X') {
            theMaze[goal_x + 2][goal_y] = ' ';

        }
        if (theMaze[goal_x][goal_y + 2] == 'X') {
            theMaze[goal_x][goal_y + 2] = ' ';

        }
        if (theMaze[goal_x - 2][goal_y] == 'X') {
            theMaze[goal_x - 2][goal_y] = ' ';

        }
        if (theMaze[goal_x][goal_y - 2] == 'X') {
            theMaze[goal_x][goal_y - 2] = ' ';

        }

        //Place the starting position
        theMaze[start_x][start_y]='M';
        if (theMaze[start_x + 1][start_y] == 'X') {
            theMaze[start_x + 1][start_y]= ' ';

        }
        if (theMaze[start_x][start_y + 1] == 'X') {
            theMaze[start_x][start_y + 1] = ' ';

        }
        if (theMaze[start_x - 1][start_y] == 'X') {
            theMaze[start_x - 1][start_y] = ' ';

        }
        if (theMaze[start_x ][start_y - 1] == 'X') {
            theMaze[start_x][start_y - 1] = ' ';

        }
    }

    @Override
    public String toString() {
        String final_return_string="";

        for(int i=0;i<dimension;i++) {

            final_return_string+="\n|";
            for(int j=0;j<dimension;j++) {
                final_return_string+=theMaze[i][j]+"|";
            }

        }

        final_return_string+="\n\n";

        return final_return_string;
    }

}