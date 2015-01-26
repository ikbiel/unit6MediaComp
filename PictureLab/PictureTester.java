package classes;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testKeepOnlyBlue()
  {
      Picture beach = new Picture("butterfly1.jpg");
      beach.explore();
      beach.keepOnlyBlue();
      beach.explore();
    }
    
  public static void testNegate()
  {
      Picture kitty = new Picture("kitten2.jpg");
      kitty.explore();
      kitty.negate();
      kitty.explore();
    }
    
  public static void testGrayscale()
  {
      Picture wall = new Picture("wall.jpg");
      wall.explore();
      wall.grayscale();
      wall.explore();
    }
    
  public static void testFixUnderWater()
  {
      Picture water = new Picture("water.jpg");
      water.explore();
      water.fixUnderWater();
      water.explore();
    }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  public static void testMirrorArms()
  {
      Picture snowman = new Picture("snowman.jpg");
      snowman.explore();
      snowman.mirrorArms();
      snowman.explore();
    }
    
  public static void testMirrorGull()
  {
      Picture gull = new Picture("seagull.jpg");
      gull.explore();
      gull.mirrorGull();
      gull.explore();
    }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("nycbw.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
 public static void testMirrorVerticalRightToLeft()
 {
     Picture caterpillar = new Picture("swan.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
 }
 
 public static void testMirrorHorizontal()
 {
     Picture caterpillar = new Picture("swan.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
 }
 
 public static void testMirrorHorizontalBottomToTop()
 {
     Picture caterpillar = new Picture("swan.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontalBottomToTop();
    caterpillar.explore();
 }
 
 public static void testCropAndCopy()
 {
     Picture beach = new Picture("beach.jpg");
     Picture snow = new Picture("snowman.jpg");
     beach.explore();
     beach.cropAndCopy(snow, 20, 30, 10, 20, 40, 30);
     beach.explore();
    }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testNegate();
    //testGrayscale();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
   // testFixUnderWater();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
   // testMirrorVerticalRightToLeft();
    //testMirrorHorizontal();
    //testMirrorHorizontalBottomToTop();
    //testCropAndCopy();
    testCollage();
  }
}