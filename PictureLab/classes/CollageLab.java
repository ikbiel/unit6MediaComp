

/**
 * Write a description of class Collage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CollageLab
{
    /** description of instance variable x (add comment for each instance variable) */
    private Picture sourcePic;
    private Picture cropPic;

    /**
     * Default constructor for objects of class Collage
     */
    public CollageLab()
    {
        // initialise instance variables
        sourcePic = new Picture("nyc.jpg");
        cropPic = new Picture("moon.jpg");
    }
    
    public void mirrorTopToBottom()
    {
        
    }
    
    public void filter()
    {
        
    }
    
    public void cropAndCopy( Picture sourcePicture, int startSourceRow, int endSourceRow, 
    int startSourceCol, int endSourceCol, int startDestRow, int startDestCol )
    {
        Pixel[][] sourcePixels = sourcePicture.getPixels2D();
        Pixel[][] destPic = this.getPixels2D();
        
        int valRow = endSourceRow - startSourceRow;
        int valCol = endSourceCol - startSourceCol;
     
        for(int row = 0; row < valRow; row++)
        {
            for(int col = 0; col < valCol; col++)
            {
                Pixel pixel = sourcePixels[startSourceRow+row][startSourceCol+col]; 
                destPic[startDestRow + row][startDestCol + col].setColor(pixel.getColor());
             
            }
        }
    }

    public static void main(String[] args)
    {
        Picture canvas = new Picture(4000, 4000);
        Picture pic1 = new Picture("nycbw.jpg");
        canvas.cropAndCopy(canvas, 0, 1600, 0, 1000, 0, 0); 


        
    }

}
