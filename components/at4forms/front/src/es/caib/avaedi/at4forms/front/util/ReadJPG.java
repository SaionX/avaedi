/*
 * readImage.java
 *
 * Created on 19 de noviembre de 2001, 9:48
 */

package es.caib.avaedi.at4forms.front.util;

/**
 *
 * @author  finarejos
 * @version 
 */
public class ReadJPG {

    public short image_content[];
    public int k = 0;
    
    public ReadJPG() {
    }
    
    public short readShort(){
        short este = image_content[k];
        k++;
        return este;
    }
    
    public short[] readNShort(int n){
        short[] este = new short[n];
        for (int j=k,h=0;j<k+n;j++,h++){
            este[h] = image_content[j]; 
        }
        k = k+n+1;
        return este;
    }
    
    public void setImageContent(short[] imageJPG){
        image_content = imageJPG;
    }
    
    public int[] getJPGSize (){
        int[] size = new int[3];
        
        //*****INICIO DEL BUCLE DE LECTURA*******//
        int db;
        short c1;
        short c2;
        int h,l,w;
        c1 = readShort();
        c2 = readShort();
        
        if (c1 != 255 || c2!=216){
        }
        
        while (true){
            
            db =0;
            c1 = readShort();
            
            while (c1 != 255){
                db++;
                c1 = readShort();
            }
            
            while (c1 == 255){
                c1 = readShort();
            }
            
            if (db!=0){
                System.out.println("Warning:garbage data the JPG");
            }
            
            if (c1 >= 192 && c1 <= 207){
                //Aqui esta el ancho y el alto de la imagen JPG
                short[] unpack = readNShort(7);
                l = unpack[1]+(unpack[0]<<8);
                h = unpack[4]+(unpack[3]<<8);
                w = unpack[6]+(unpack[5]<<8);
                size[0]=w;
                size[1]=h;
                break;
            }
            
            else if (c1 == 218 || c1 == 217){
                // fin de la cabecera?
                break;
            }
            else{
                //Descartar esta variable
                short[] unpack = readNShort(2);
                l = unpack[1] + (unpack[0]<<8);
                l = l - 2;
                if (l<0){
                    break;
                }
                
                //unpack2 no sirve para nada,tan solo es para descartar los bytes
                readNShort(l-2);
            }
        }//while
        //*****FIN DEL BUCLE DE LECTURA**********//
        return size;
    }
    
}
