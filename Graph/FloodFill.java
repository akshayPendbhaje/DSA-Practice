class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null || sr>image.length || sc > image[0].length)
            return image;

        fillColor(image,image[sr][sc],sr,sc,color);
        return image;
    }

    void fillColor(int[][] image , int srcColor,int sr,int sc,int destColor )
    {
        if(sr<0 || sr >= image.length || sc<0 || sc>= image[0].length || image[sr][sc]!= srcColor || image[sr][sc]==destColor)
        {
            return;
        }

        image[sr][sc]=destColor;

        fillColor(image,srcColor,sr+1,sc,destColor);
        fillColor(image,srcColor,sr-1,sc,destColor);
        fillColor(image,srcColor,sr,sc+1,destColor);
        fillColor(image,srcColor,sr,sc-1,destColor);
    }
}