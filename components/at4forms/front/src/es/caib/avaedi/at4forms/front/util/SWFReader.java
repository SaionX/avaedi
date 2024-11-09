package es.caib.avaedi.at4forms.front.util;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/**
 */
public class SWFReader
{
   
   private int          width = 0;
   private int          height = 0;

   /**
    * 
    */
   public SWFReader( byte image_content[] )
   {
      byte[] swf            = null;
      
  	try {
     if ( isCompressed( image_content[0] ) )
     {
    		swf = decompress( image_content );
     }
     else
     {
        swf = image_content;
     }
     
     parseHeader( swf );

  	} catch (DataFormatException dfe) {
		
	}
     
   }
   
   private void parseHeader( byte[] swf )
   {
      //Stage dimensions are stored in a rect

      int nbits = ( ( swf[8] & 0xff ) >> 3 );

      PackedBitObj pbo = readPackedBits( swf, 8, 5, nbits );

      PackedBitObj pbo2 = readPackedBits( swf, pbo.nextByteIndex, pbo.nextBitIndex, nbits );

      PackedBitObj pbo3 = readPackedBits( swf, pbo2.nextByteIndex, pbo2.nextBitIndex, nbits );

      PackedBitObj pbo4 = readPackedBits( swf, pbo3.nextByteIndex, pbo3.nextBitIndex, nbits );

      width = convertTwipsToPixels( pbo2.value );
      height = convertTwipsToPixels( pbo4.value );
      
   }

   private int reverseBytes(int val)
   {
	   return (  ((val >> 24) & 0xff)
			   | ((val >> 8) & 0xff00)
			   | ((val << 8) & 0xff0000)
			   | ((val << 24) & 0xff000000));
   }   

   private int readSize( byte[] swf )
   {
      int size = 0;
      for ( int i = 0; i < 4; i++ )
      {
         size = ( size << 8 ) + swf[i + 4];
      }
      
      size = reverseBytes( size );

      return size;
   }
   
   private PackedBitObj readPackedBits( byte[] bytes, int byteMarker, int bitMarker, int length )
   {
      int total = 0;
      int mask = 7 - bitMarker;
      int counter = 0;
      int bitIndex = bitMarker;
      int byteIndex = byteMarker;

      while ( counter < length )
      {

         for ( int i = bitMarker; i < 8; i++ )
         {
            int bit = ( ( bytes[byteMarker] & 0xff ) >> mask ) & 1;
            total = ( total << 1 ) + bit;
            bitIndex = i;
            mask--;
            counter++;
            if ( counter == length )
            {
               break;
            }
         }
         byteIndex = byteMarker;
         byteMarker++;
         bitMarker = 0;
         mask = 7;
      }
      return new PackedBitObj( bitIndex, byteIndex, total );
   }

   private int convertTwipsToPixels( int twips )
   {
      return twips / 20;
   }

   private boolean isCompressed( int firstByte )
   {
      if ( firstByte == 67 )
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   private byte[] decompress( byte[] bytes ) throws DataFormatException
   {
      int size = readSize( bytes );
      
      byte[] uncompressed = new byte[size];
      
      for ( int i = 0; i < 8; i++)
      {
         uncompressed[i] = bytes[i];
      }
      
      Inflater inflater = new Inflater();
      inflater.setInput( bytes, 8, bytes.length - 8 );
      inflater.inflate( uncompressed, 8, size - 8 );
      inflater.finished();
      
      //the first byte of the swf indicates the swf is uncompressed
      uncompressed[0] = 70;
      
      return uncompressed;
   }
   
   /**
    * @return the height
    */
   public int getHeight()
   {
      return height;
   }

   /**
    * @return the width
    */
   public int getWidth()
   {
      return width;
   }

   
   protected class PackedBitObj
   {

      public int    bitIndex         = 0;

      public int    byteIndex        = 0;

      public int    value            = 0;

      public int    nextBitIndex     = 0;

      public int    nextByteIndex    = 0;

      public int    nextByteBoundary = 0;

      /**
       * @param bitIndex
       *           The index of the last bit read
       * @param byteMarker
       *           The index of the last byte read
       * @param decimalValue
       *           The decimal value of the packed bit sequence
       * @param binaryString
       *           A binary string
       */
      public PackedBitObj( int bitMarker, int byteMarker, int decimalValue )
      {
         bitIndex = bitMarker;
         byteIndex = byteMarker;
         value = decimalValue;
         nextBitIndex = bitMarker;

         if ( bitMarker < 7 )
         {
            nextBitIndex++;
            nextByteIndex = byteMarker;
            nextByteBoundary = byteMarker++;
         }
         else
         {
            nextBitIndex = 0;
            nextByteIndex++;
            nextByteBoundary = nextByteIndex;
         }
      }

   }   
}


