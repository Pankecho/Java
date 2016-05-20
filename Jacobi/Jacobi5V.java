public class Jacobi5V
{
    private Funcion4Var x1, x2, x3, x4, x5;
    private float error, error1, error2, error3, error4, error5;
    private float [] V = new float[10000];
    private float [] W = new float[10000];
    private float [] X = new float[10000];
    private float [] Y = new float[10000];
    private float [] Z = new float[10000];
    private int indice;
    public Jacobi5V(Funcion4Var x1, Funcion4Var x2, Funcion4Var x3, Funcion4Var x4, Funcion4Var x5, float error)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.x5 = x5;
        this.error = error;
        error1 = error2 = error3 = error4 = error5 = 1;
        V[0] = 0;
        W[0] = 0;
        X[0] = 0;
        Y[0] = 0;
        Z[0] = 0;
        //calcula();
    }

    public void calcula(){
        indice = 1;
        while(error1 > error || error2 > error || error3 > error || error4 > error || error5 > error){
            V[indice] = x1.evaluar(W[indice-1], X[indice-1], Y[indice-1], Z[indice-1]);
            W[indice] = x2.evaluar(V[indice-1], X[indice-1], Y[indice-1], Z[indice-1]);
            X[indice] = x3.evaluar(V[indice-1], W[indice-1], Y[indice-1], Z[indice-1]);
            Y[indice] = x4.evaluar(V[indice-1], W[indice-1], X[indice-1], Z[indice-1]);
            Z[indice] = x5.evaluar(V[indice-1], W[indice-1], X[indice-1], Y[indice-1]);
            error1 = Math.abs(V[indice]-V[indice-1]);
            error2 = Math.abs(W[indice]-W[indice-1]);
            error3 = Math.abs(X[indice]-X[indice-1]);
            error4 = Math.abs(Y[indice]-Y[indice-1]); 
            error5 = Math.abs(Z[indice]-Z[indice-1]);
            System.out.println("v = " + V[indice] + "| w = " + W[indice] + " | x = " + X[indice] + " | y = " + Y[indice] + " | z = " + Z[indice]);
            System.out.format("");
            indice ++;
        }
    }
    
    
}
