import java.util.LinkedList;
import java.util.Queue;

public class MazeSolver {
    static Node last;
    private static Node[][] nodeMaze;


    public static void BFS(Maze my_maze) {

        System.out.println(my_maze);
        System.out.println("Start solving");


//        Runnable printer = new Runnable() {
//            public void run() {
//                System.out.println(my_maze);
//            }
//        };
//        ScheduledExecutorService executer = Executors.newScheduledThreadPool(1);
//        executer.scheduleAtFixedRate(printer,0, 5, TimeUnit.SECONDS);
//
//        printer.run();

        if(find_path(my_maze)) {
           // executer.shutdown();
            System.out.println(my_maze);
            fixIt(my_maze);
            System.out.println(my_maze);
            System.out.println("Solved");
            System.out.println(finalPrint(my_maze));

        }
        else {
        //    executer.shutdown();
            System.out.println(my_maze);
            System.out.println("Impossible Maze");
        }

    }


    public static boolean find_path(Maze my_maze) {
        Queue<Node> q = new LinkedList<>();
        nodeMaze = new Node[my_maze.dimension][my_maze.dimension];
        Node previous = new Node(my_maze.start_x, my_maze.start_y);
        nodeMaze[my_maze.start_x][my_maze.start_y] = previous;
        Node inQueue;
        q.add(previous);
        int x;
        int y;


        while(q.size() != 0) {

            previous = q.poll();

            x = previous.getX();
            y = previous.getY();


            if(my_maze.theMaze[x][y] == 'C') {
                last = previous;
                return true;

            }


            if (my_maze.theMaze[x][y] == ' ') {
                my_maze.theMaze[x][y] = '+' ;
            }

            if (x + 1 < my_maze.dimension && nodeMaze[x + 1][y] == null &&  my_maze.theMaze[x + 1][y] != 'X') {
                inQueue  = new Node(x + 1, y, previous);
                q.add(inQueue);
                nodeMaze[x+1][y] = inQueue;
            }

            if (x - 1 >= 0 && nodeMaze[x - 1][y] == null &&  my_maze.theMaze[x - 1][y] != 'X' ) {
                inQueue = new Node(x - 1, y, previous);
                q.add(inQueue);
                nodeMaze[x-1][y] = inQueue;
            }

            if (y - 1 >= 0 && nodeMaze[x][y - 1] == null  && my_maze.theMaze[x][y - 1] != 'X') {
                inQueue = new Node(x, y - 1, previous);
                q.add(inQueue);
                nodeMaze[x][y-1] = inQueue;
            }
            if (y + 1 < my_maze.dimension && nodeMaze[x][y + 1] == null && my_maze.theMaze[x][y + 1] != 'X' ) {
                inQueue = new Node(x, y + 1, previous);
                q.add(inQueue);
                nodeMaze[x][y+1] = inQueue;
            }




        }




        return false;

    }

    public static void fixIt(Maze my_maze) {
        for (int row = 0; row < my_maze.theMaze.length; row++) {
            for (int col = 0; col < my_maze.theMaze[row].length; col++) {
                if (my_maze.theMaze[row][col] == '+') {
                    my_maze.theMaze[row][col] = ' ';
                }
            }
        }
        Node current = last.previous;
        while (current.previous != null) {
            my_maze.theMaze[current.getX()][current.getY()] = '+';
            current = current.previous;
        }
    }

    public static String finalPrint(Maze my_maze) {
            String final_return_string="";

            for(int i=0;i<my_maze.dimension;i++) {

                final_return_string+="\n|";
                for(int j=0;j<my_maze.dimension;j++) {
                    if (my_maze.theMaze[i][j] == '+') {
                        final_return_string += "\u001B[31m" + my_maze.theMaze[i][j]+ "\u001B[0m" + "|";
                    }
                    else {
                        final_return_string += my_maze.theMaze[i][j] + "|";
                    }
                }

            }

            final_return_string+="\n\n";

            return final_return_string;



    }
}
