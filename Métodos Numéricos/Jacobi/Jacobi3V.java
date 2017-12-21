public class Jacobi3V
{
    private Funcion2Var x1, x2, x3;
    private float error, error1, error2, error3;
    private float [] X = new float[10000];
    private float [] Y = new float[10000];
    private float [] Z = new float[10000];
    private int indice;
    public Jacobi3V(Funcion2Var x1, Funcion2Var x2, Funcion2Var x3, float error)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.error = error;
        error1 = error2 = error3 = 1;
        X[0] = 0;
        Y[0] = 0;
        Z[0] = 0;
        //calcula();
    }

    public void calcula(){
        indice = 1;
        while(error1 > error || error2 > error || error3 > error){
            X[indice] = x1.evaluar(Y[indice-1], Z[indice-1]);
            Y[indice] = x2.evaluar(X[indice-1], Z[indice-1]);
            Z[indice] = x3.evaluar(X[indice-1], Y[indice-1]);
            error1 = Math.abs(X[indice]-X[indice-1]);
            error2 = Math.abs(Y[indice]-Y[indice-1]); 
            error3 = Math.abs(Z[indice]-Z[indice-1]);
            System.out.println("x = " + X[indice] + " | y = " + Y[indice] + " | z = " + Z[indice]);
            indice ++;
        }
    }
    
    
}
