import java.awt.*;
import javax.swing.*;
public class Koch extends JApplet
{
    double xUno = 490;
    double yUno = 300;
    double xDos = 10;
    double yDos = 300;
    double seno60 = Math.sin(Math.toRadians(60));
    int total;
    public void init()
    {
        JRootPane rootPane = this.getRootPane();    
        rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);
    }

    public void start()
    {
        // provide any code requred to run each time 
        // web page is visited
    }

    public void stop()
    {
        // provide any code that needs to be run when page
        // is replaced by another page or before JApplet is destroyed 
    }

    public void paint(Graphics g)
    {
        total = Integer.parseInt(JOptionPane.showInputDialog("Dame nivel de recursividad",null));
        koch(g,xUno,yUno,xDos,yDos,total);
    }
    
    public void koch(Graphics g, double x1, double y1, double x2, double y2,int veces){
        double tamañoX = (x2-x1)/3.;
        double tamañoY = (y2-y1)/3.;
        double movX = x1 + 3 * tamañoX / 2. - tamañoY * seno60;
        double movY = y1 + 3 * tamañoY / 2. + tamañoX * seno60;
        if(veces == 0){
            g.drawLine((int)x1,(int) y1,(int)x2,(int)y2);
        }else{
            koch(g,x1,y1,x1+tamañoX,y1+tamañoY, veces-1);
            koch(g,x1+tamañoX,y1+tamañoY,movX,movY, veces-1);
            koch(g,movX,movY,x2-tamañoX,y2-tamañoY, veces-1);
            koch(g,x2-tamañoX,y2-tamañoY,x2,y2, veces-1);
        }
        
    }
    
    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * is being reclaimed and that it should destroy any resources that it
     * has allocated. The stop method will always be called before destroy. 
     */
    public void destroy()
    {
        // provide code to be run when JApplet is about to be destroyed.
    }


    /**
     * Returns information about this applet. 
     * An applet should override this method to return a String containing 
     * information about the author, version, and copyright of the JApplet.
     *
     * @return a String representation of information about this JApplet
     */
    public String getAppletInfo()
    {
        // provide information about the applet
        return "Title:   \nAuthor:   \nA simple applet example description. ";
    }


    /**
     * Returns parameter information about this JApplet. 
     * Returns information about the parameters than are understood by this JApplet.
     * An applet should override this method to return an array of Strings 
     * describing these parameters. 
     * Each element of the array should be a set of three Strings containing 
     * the name, the type, and a description.
     *
     * @return a String[] representation of parameter information about this JApplet
     */
    public String[][] getParameterInfo()
    {
        // provide parameter information about the applet
        String paramInfo[][] = {
                 {"firstParameter",    "1-10",    "description of first parameter"},
                 {"status", "boolean", "description of second parameter"},
                 {"images",   "url",     "description of third parameter"}
        };
        return paramInfo;
    }
}
