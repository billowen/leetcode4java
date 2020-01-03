package queue;

import java.util.*;

public class WallsAndGates {

    private static final int INF = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] {1, 0},
            new int[] {-1, 0},
            new int[] {0, 1},
            new int[] {0, -1}
    );

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();

        // find the start room
        int rows = rooms.length;
        if (rows == 0) return;

        int cols = rooms[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == GATE) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curNode = queue.poll();
                int row = curNode[0];
                int col = curNode[1];
                for (int[] dir : DIRECTIONS) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r < 0 || c < 0 || r >= rows || c>= cols || rooms[r][c] != INF) {
                        continue;
                    }
                    rooms[r][c] = rooms[row][col] + 1;
                    queue.offer(new int[] {r, c});
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] rooms = new int[][] {
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}};

        WallsAndGates sol = new WallsAndGates();
        sol.wallsAndGates(rooms);
    }
}
