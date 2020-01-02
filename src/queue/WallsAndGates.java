package queue;

import java.util.*;

public class WallsAndGates {

    private static final int INF = 2147483647;

    class Node {
        private int row;
        private int col;

        public Node(int row, int y) {
            this.row = row;
            this.col = y;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return row == node.row &&
                    col == node.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public void wallsAndGates(int[][] rooms) {
        Queue<Node> queue = new LinkedList<>();

        // find the start room
        int rows = rooms.length;
        if (rows == 0) return;
        int cols = rooms[0].length;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Node(i, j));
                }
            }
        }

        int step = 0;
        Set<Node> processed = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                if (processed.contains(curNode)) continue;
                rooms[curNode.getRow()][curNode.getCol()] = step;
                if (curNode.getRow() - 1 >= 0 && rooms[curNode.getRow() - 1][curNode.getCol()] == INF) {
                    queue.offer(new Node(curNode.getRow() - 1, curNode.getCol()));
                }
                if (curNode.getRow() + 1 < rows && rooms[curNode.getRow() + 1][curNode.getCol()] == INF) {
                    queue.offer(new Node(curNode.getRow() + 1, curNode.getCol()));
                }
                if (curNode.getCol() - 1 >= 0 && rooms[curNode.getRow()][curNode.getCol()-1] == INF) {
                    queue.offer(new Node(curNode.getRow(), curNode.getCol() - 1));
                }
                if (curNode.getCol() + 1 < cols && rooms[curNode.getRow()][curNode.getCol()+1] == INF) {
                    queue.offer(new Node(curNode.getRow(), curNode.getCol() + 1));
                }
                processed.add(curNode);
            }
            step += 1;
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
