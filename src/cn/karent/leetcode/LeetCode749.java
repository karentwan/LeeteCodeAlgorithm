package cn.karent.leetcode;

import java.util.*;

/**
 * 隔离病毒
 */
public class LeetCode749 {

    private List<Set<Integer>> infection = null;    // 已经感染的地方
    private List<Set<Integer>> dangerRegion = null; // 将要被感染的危险区
    private List<Integer> firewall = null;          // 防火墙区
    private int[] rd = {-1, 1, 0, 0};
    private int[] cd = {0, 0, -1, 1};
    private int row = 0, column = 0;
    private boolean[][] visited = null;

    public int containVirus(int[][] grid) {
        int ret = 0;
        row = grid.length;
        if( row == 0) {
            return 0;
        }
        column = grid[0].length;
        while( true ) {
            infection = new ArrayList<>();
            dangerRegion = new ArrayList<>();
            firewall = new ArrayList<>();
            visited = new boolean[row][column];
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < column; j++) {
                    if( grid[i][j] == 1 && !visited[i][j]) {
                        infection.add(new HashSet<>());
                        dangerRegion.add(new HashSet<>());
                        firewall.add(0);
                        dfs(grid, i, j);
                    }
                }
            }
            if( infection.isEmpty() ) {
                break;
            }
            // 找出最大的感染区域
            int maxInfIdx = 0;
            for(int i = 0; i < dangerRegion.size(); i++) {
                if( dangerRegion.get(i).size() > dangerRegion.get(maxInfIdx).size()) {
                    maxInfIdx = i;
                }
            }
            ret += firewall.get(maxInfIdx);
            // 开始感染
            for(int i = 0; i < infection.size(); i++) {
                if( i == maxInfIdx) {
                    for(int idx : infection.get(i)) {
                        grid[idx / column][idx % column] = -1;
                    }
                } else {
                    for(int idx : dangerRegion.get(i)) {
                        grid[idx / column][idx % column] = 1;
                    }
                }
            }
        }
        return ret;
    }

    private void dfs(int[][] grid, int x, int y) {
        if( !visited[x][y] ) {
            int val = x * column + y;
            int idx = infection.size()-1;
            infection.get(idx).add(val);
            visited[x][y] = true;
            for(int i = 0; i < 4; i++) {
                int nx = x + rd[i];
                int ny = y + cd[i];
                if( nx >= 0 && nx < row && ny >= 0 && ny < column) {
                    if( grid[nx][ny] == 1) {
                        dfs(grid, nx, ny);
                    } else if( grid[nx][ny] == 0) {  // 危险区
                        val = nx * column + ny;
                        dangerRegion.get(idx).add(val);
                        firewall.set(idx, firewall.get(idx)+1);
                    }
                }
            }
        }
    }

}
