package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 可以被一步捕获的棋子数
 * @author wan
 * @date 2021.05.18
 ********************************************/
public class LeetCode999 {

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private int attack(Point p, Set<Point> visited, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int x = p.x;
        int y = p.y;
        // left
        char ch = 0;
        int i = y-1;
        int ret = 0;
        while (i >= 0 && (ch = board[x][i]) != 'R' && ch != 'B' && ch != 'p')
            i--;
        if( ch == 'p' ) {
            Point pawn = new Point(x, i);
            if( !visited.contains(pawn)) {
                visited.add(pawn);
                ret++;
            }
        }
        ch = 0;
        // right
        i = y+1;
        while (i < n && (ch = board[x][i]) != 'R' && ch != 'B' && ch != 'p')
            i++;
        if( ch == 'p' ) {
            Point pawn = new Point(x, i);
            if( !visited.contains(pawn)) {
                visited.add(pawn);
                ret++;
            }
        }
        ch = 0;
        // up
        i = x-1;
        while (i >= 0 && (ch = board[i][y]) != 'R' && ch != 'B' && ch != 'p')
            i--;
        if( ch == 'p' ) {
            Point pawn = new Point(i, y);
            if( !visited.contains(pawn)) {
                visited.add(pawn);
                ret++;
            }
        }
        ch = 0;
        // down
        i = x+1;
        while (i < m && (ch = board[i][y]) != 'R' && ch != 'B' && ch != 'p')
            i++;
        if( ch == 'p' ) {
            Point pawn = new Point(i, y);
            if( !visited.contains(pawn)) {
                visited.add(pawn);
                ret++;
            }
        }
        return ret;
    }

    public int numRookCaptures(char[][] board) {
        Set<Point> visited = new HashSet<>();
        List<Point> rooks = new ArrayList<>();
        int m = board.length;
        if( m == 0) return 0;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if( board[i][j] == 'R') {
                    rooks.add(new Point(i, j));
                }
            }
        }
        int ret = 0;
        for (Point rook : rooks) {
            ret += attack(rook, visited, board);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode999 lc = new LeetCode999();
//        char[][] board = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
//        char[][] board = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','p','B','R','p','B','p','.'},{'.','.','.','p','p','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
        char[][] board = {{'R','.','p','.','p','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'p','.','.','.','.','.','.','.'},{'p','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
        int ret = lc.numRookCaptures(board);
        System.out.println(ret);

    }

}
