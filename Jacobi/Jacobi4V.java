public class Jacobi4V
{
    private Funcion3Var x1, x2, x3, x4;
    private float error, error1, error2, error3, error4;
    private float [] W = new float[10000];
    private float [] X = new float[10000];
    private float [] Y = new float[10000];
    private float [] Z = new float[10000];
    private int indice;
    public Jacobi4V(Funcion3Var x1, Funcion3Var x2, Funcion3Var x3, Funcion3Var x4, float error)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.error = error;
        error1 = error2 = error3 = error4 = 1;
        W[0] = 0;
        X[0] = 0;
        Y[0] = 0;
        Z[0] = 0;
        //calcula();
    }

    public void calcula(){
        indice = 1;
        while(error1 > error || error2 > error || error3 > error || error4 > error){
            W[indice] = x1.evaluar(X[indice-1], Y[indice-1], Z[indice-1]);
            X[indice] = x2.evaluar(W[indice-1], Y[indice-1], Z[indice-1]);
            Y[indice] = x3.evaluar(W[indice-1], X[indice-1], Z[indice-1]);
            Z[indice] = x4.evaluar(W[indice-1], X[indice-1], Y[indice-1]);
            error1 = Math.abs(W[indice]-W[indice-1]);
            error2 = Math.abs(X[indice]-X[indice-1]);
            error3 = Math.abs(Y[indice]-Y[indice-1]); 
            error4 = Math.abs(Z[indice]-Z[indice-1]);
            System.out.println("w = " + W[indice] + " | x = " + X[indice] + " | y = " + Y[indice] + " | z = " + Z[indice]);
            System.out.format("");
            indice ++;
        }
    }
    
    
}
