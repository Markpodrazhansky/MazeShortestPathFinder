public class MazePrinter extends Thread {
    Maze currentMaze;
    MazePrinter(Maze newMaze) {
        currentMaze = newMaze;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(currentMaze);
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
            }
        }
    }
}
