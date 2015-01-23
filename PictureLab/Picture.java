import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void keepOnlyBlue()
  {
      Pixel[][] pixels = this.getPixels2D();
      for(Pixel[] rowArray : pixels)
      {
          for(Pixel pixelObj : rowArray)
          {
              pixelObj.setGreen(0);
              pixelObj.setRed(0);
            }
        }
    }
    
  public void negate()
  {
      Pixel[][] pixels = this.getPixels2D();
      for(Pixel[] rowArray : pixels)
      {
          for(Pixel pixelObj : rowArray)
          {
              pixelObj.setRed(255 - pixelObj.getRed());
              pixelObj.setGreen(255 - pixelObj.getGreen());
              pixelObj.setBlue(255 - pixelObj.getBlue());
            }
        }
    }
    
  public void grayscale()
  {
      Pixel[][] pixels = this.getPixels2D();
      
      for(Pixel[] rowArray : pixels)
      {
          for(Pixel pixelObj : rowArray)
          {
              int average = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue())/3;
              pixelObj.setRed(average);
              pixelObj.setGreen(average);
              pixelObj.setBlue(average);
            }
        }
    }
    
  public void fixUnderWater()
  {
      Pixel[][] pixels = this.getPixels2D();
      int blueVal = 160;
      for(Pixel[] rowArray : pixels)
      {
          for(Pixel pixelObj : rowArray)
          {
              if(pixelObj.getBlue() >= blueVal)
              {
                  pixelObj.setRed(pixelObj.getRed()*3);
                  pixelObj.setGreen(pixelObj.getGreen()/3);
                }
            }
        }
    }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        
        count++;
      }
    }
    System.out.print(count);
  }
  
  
  public void mirrorArms()
  {
      int mirrorPoint = 194;
      Pixel topPixel = null;
      Pixel bottomPixel = null;
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 163; row < mirrorPoint; row++)
      {
          for(int col = 105; col < 294; col++)
          {
              topPixel = pixels[row][col];
              bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
              bottomPixel.setColor(topPixel.getColor());
              
            }
        }
    }
    
  public void mirrorGull()
  {
      int mirrorPoint = 344;
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 236; row < 328; row++)
      {
          for(int col = 238; col < mirrorPoint; col++)
          {
              leftPixel = pixels[row][col];
              rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
              rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
   public void mirrorVerticalRightToLeft()
 {
     Pixel[][] pixels = this.getPixels2D();
     Pixel leftPixel = null;
     Pixel rightPixel = null;
     int width = pixels[0].length;
     for (int row = 0; row < pixels.length; row++)
     {
         for (int col = 0; col < width / 2; col++)
         {
             leftPixel = pixels[row][col];
             rightPixel = pixels[row][width - 1 -
             col];
             leftPixel.setColor(rightPixel.getColor());
            }
     }
 }
 
 public void mirrorHorizontal()
 {
     Pixel[][] pixels = this.getPixels2D();
     Pixel topPixel = null;
     Pixel bottomPixel = null;
     int height = pixels.length;
     for (int row = 0; row < height/2; row++)
     {
         for (int col = 0; col < pixels[0].length; col++)
         {
             topPixel = pixels[row][col];
             bottomPixel = pixels[height - 1 - row][col];
             bottomPixel.setColor(topPixel.getColor());
            }
     }
    }
  
 public void mirrorHorizontalBottomToTop()
 {
     Pixel[][] pixels = this.getPixels2D();
     Pixel topPixel = null;
     Pixel bottomPixel = null;
     int height = pixels.length;
     for (int row = 0; row < height/2; row++)
     {
         for (int col = 0; col < pixels[0].length; col++)
         {
             topPixel = pixels[row][col];
             bottomPixel = pixels[height - 1 - row][col];
             topPixel.setColor(bottomPixel.getColor());
            }
     }
    }
    
 public void cropAndCopy1( Picture sourcePicture, int startSourceRow, 
 int endSourceRow, int startSourceCol, int endSourceCol, int startDestRow, int startDestCol )
 {
     Pixel[][] sourcePic = sourcePicture.getPixels2D();
     Pixel[][] destPic = this.getPixels2D();
     
     int valRow = endSourceRow - startSourceRow;
     int valCol = endSourceCol - startSourceCol;
     
     for(int row = 0; row < valRow; row++)
     {
         for(int col = 0; col < valCol; col++)
         {
             Pixel pixel = sourcePic[startSourceRow+row][startSourceCol+col]; 
             destPic[startDestRow + row][startDestCol + col].setColor(pixel.getColor());
             
             
            }
        }
     
       
    }
    
    // START COLLAGE LAB WORK
    public void mirrorBuilding(int startRow, int endRow, int startCol, int mirrorPoint)
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
        for(int row = 0; row < (endRow - startRow); row++)
        {
          for(int col = 0; col < (endCol - startCol); col++)
          {
              pixels[startRow + row][startCol + col].setGreen(
                pixels[startRow + row][startCol + col].getGreen() * 3);
              pixels[startRow + row][startCol + col].setRed(
                pixels[startRow + row][startCol + col].getRed() * 2);
              pixels[startRow + row][startCol + col].setBlue(
                pixels[startRow + row][startCol + col].getBlue() / 2);
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
    
    public void createRealCollage()
    {
        Picture sourcePic = new Picture("nycbw.jpg");
        //this.cropAndCopy(sourcePic,402, 632, 1058, 1598, 172, 1058);
        this.mirrorBuilding(0, 366, 762, 953);
        this.filter(764, 997, 876, 1169); 
        this.filter(312, 657, 493, 869);
        this.filter(786, 997, 0, 413);
        this.filter(0, 258, 1252, 1599);
        this.write("H:\\GitHub\\unit6MediaComp\\PictureLab\\images\\MyCollage.jpg");
    }

    public static void main(String[] args)
    {
        Picture canvas = new Picture("nycbw.jpg");
        canvas.createRealCollage();
        canvas.explore();

    }
    
 
  
} // this } is the end of class Picture, put all new methods before this