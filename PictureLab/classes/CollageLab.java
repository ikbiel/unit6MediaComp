

/**
 * Creates a collage of multiple variations of a picture of New York City: cropping, mirroring changing color.
 * 
 * @author (ikbiel) 
 * @version (a version number or a date)
 */
public class CollageLab extends Picture
{
    /** description of instance variable x (add comment for each instance variable) */


    /**
     * Default constructor for objects of class Collage
     */
    public CollageLab()
    {
        // initialise instance variables

    }
    
    public void mirrorRight(int startRow, int endRow, int startCol, int mirrorPoint)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
      for(int row = startRow; row < endRow; row++)
      {
          for(int col = startCol; col < mirrorPoint; col++)
          {
              leftPixel = pixels[row][col];
              rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
              rightPixel.setColor(leftPixel.getColor());
          }
      }
        
    }
    
    public void filter(int startRow, int endRow, int startCol, int endCol)
    {
        Pixel[][] pixels = this.getPixels2D();
        for(Pixel[] rowArray : pixels)
        {
          for(Pixel pixelObj : rowArray)
          {
              pixelObj.setGreen(175);
              pixelObj.setRed(100);
              pixelObj.setBlue(80);
          }
        }
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
        Picture canvas = new Picture("nycbw.jpg");
        Picture picVar1 = new Picture("nycbw.jpg");
        canvas.filter(picVar1, 764, 997, 876, 1169, 764, 876); 
        canvas.filter(picVar1, 312, 657, 493, 869, 312, 493);
        canvas.cropAndCopy(picVar1, 402, 632, 1058, 1598, 130, 1058);
        canvas.mirrorRight(picVar1, 812, 997, 1040, 1522);

    }

}
