class Solution {
    void dfs(int image[][],int i,int j,int n,int m,int original,int change){
        if(i < 0 || i >= n || j < 0 || j >= m || image[i][j] != original) return ;

        image[i][j] = change ;
        dfs(image,i - 1,j,n,m,original,change) ;
        dfs(image,i,j + 1,n,m,original,change) ;
        dfs(image,i + 1,j,n,m,original,change) ;
        dfs(image,i,j - 1,n,m,original,change) ;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image ;
        int n = image.length ;
        int m = image[0].length ;
        dfs(image,sr,sc,n,m,image[sr][sc],color) ;

        return image ;
    }
}