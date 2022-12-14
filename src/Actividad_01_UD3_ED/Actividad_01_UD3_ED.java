/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ana
 */
public class Actividad_01_UD3_ED 
{
    private static byte[] bufer = new byte[1000];
    private static String nombreArchivo = "fichero.dat";
    private static FileInputStream flujoEntrada = null;
    private static BufferedInputStream buferEntrada = null;

    public static void inicializarArchivos() throws FileNotFoundException
    {
        setFlujoEntrada(new FileInputStream(getNombreArchivo()));
        setBuferEntrada(new BufferedInputStream(getFlujoEntrada()));
    }
    
    public static int mostrarTextoArhivo() throws IOException
    {
        int total = 0;
        int nRead = 0;
        while((nRead = getFlujoEntrada().read(getBufer())) != -1)
        {
            System.out.println(new String(getBufer()));
            total += nRead;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializarArchivos();
            
            int total = mostrarTextoArhivo();

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( getBuferEntrada() != null && getFlujoEntrada() != null )
                {
                    getFlujoEntrada().close();
                    getBuferEntrada().close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }

    public static byte[] getBufer() {
        return bufer;
    }

    public static void setBufer(byte[] bufer) {
        Actividad_01_UD3_ED.bufer = bufer;
    }

    public static String getNombreArchivo() {
        return nombreArchivo;
    }

    public static void setNombreArchivo(String nombreArchivo) {
        Actividad_01_UD3_ED.nombreArchivo = nombreArchivo;
    }

    public static FileInputStream getFlujoEntrada() {
        return flujoEntrada;
    }

    public static void setFlujoEntrada(FileInputStream flujoEntrada) {
        Actividad_01_UD3_ED.flujoEntrada = flujoEntrada;
    }

    public static BufferedInputStream getBuferEntrada() {
        return buferEntrada;
    }

    public static void setBuferEntrada(BufferedInputStream buferEntrada) {
        Actividad_01_UD3_ED.buferEntrada = buferEntrada;
    }
}
