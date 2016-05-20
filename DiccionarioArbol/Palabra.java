
/**
 * Write a description of class Palabra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Palabra
{
    private String español, zapoteco, mixteco;
    
    public Palabra(String español, String mixteco, String zapoteco){
        this.español = español;
        this.zapoteco = zapoteco;
        this.mixteco = mixteco;
    }
    
    public String getEspañol(){
        return español;
    }
    
    public String getZapoteco(){
        return zapoteco;
    }
    
    public String getMixteco(){
        return mixteco;
    }

    
}
