import javax.swing.*;
public class Main
{
    
    public static void main(String [] args){
        Arbol arbol = new Arbol();
        
        Base b = new Base();
        b.llenarEspañol();
        b.llenarMixteco();
        b.llenarZapoteco();
        
        
        arbol.llenarLista(b);
        arbol.inOrdenArchivoEspañol();
        arbol.inOrdenArchivoMixteco();
        arbol.inOrdenArchivoZapoteco();
        arbol.escribirArchivo();
        String [] option = {"Salir", "Agregar","Eliminar","Buscar","Imprimir Lista"};
        int opcion;
        
        do{
            opcion = JOptionPane.showOptionDialog(null, "Bienvenido, escoge una opción", "Diccionario (Español - Zapoteco - Mixteco)", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, option, null);
            if(option[opcion] == option[4]){
                String [] impresion = {"Salir","In Orden", "Pre Orden", "Pos Orden"};
                int imprime;
                do{
                    imprime = JOptionPane.showOptionDialog(null, "Como quieres imprimir el Diccionario", "Impresión", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, impresion, null);
                    if(impresion[imprime] == impresion[3]){
                        arbol.imprimirPosOrden();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                    } else if(impresion[imprime] == impresion[2]){
                        arbol.imprimirPreOrden();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                    } else if(impresion[imprime] == impresion[1]){
                        arbol.imprimirInOrden();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                    }
                } while(impresion[imprime] != impresion[0]);
            } else if(option[opcion] == option[3]){
                NodoArbol aux = arbol.buscar(UsarTeclado.leerCadena("Dame la palabra en español a buscar: "));
                if(aux == null){
                    JOptionPane.showMessageDialog(null, "Palabra no encontrada");
                } else {
                    JOptionPane.showMessageDialog(null, "Palabra:\nEspañol: "+ aux.getDato().getEspañol() + "\nZapoteco: " + aux.getDato().getMixteco() + "\nMixteco: " + aux.getDato().getZapoteco());
                }
            } else if(option[opcion] == option[2]){
                String cadena = UsarTeclado.leerCadena("Dame la palabra a eliminar: ");
                NodoArbol auxi = arbol.buscar(cadena);
                
                if(auxi == null){
                    JOptionPane.showMessageDialog(null, "Palabra no encontrada");
                }else {
                    arbol.eliminar(cadena);
                    JOptionPane.showMessageDialog(null, "Palabra eliminada:\nEspañol: "+ auxi.getDato().getEspañol() + "\nZapoteco: " + auxi.getDato().getMixteco() + "\nMixteco: " + auxi.getDato().getZapoteco());
                    arbol.escribirArchivo();
                    arbol.inOrdenArchivoEspañol();
                    arbol.inOrdenArchivoMixteco();
                    arbol.inOrdenArchivoZapoteco();
                    arbol.escribirArchivoEspañol();
                    arbol.escribirArchivoMixteco();
                    arbol.escribirArchivoZapoteco();
                }
            
            } else if(option[opcion] == option[1]){
                if(arbol.agregar(new Palabra(UsarTeclado.leerCadena("Dame la palabra en español: "),
                                          UsarTeclado.leerCadena("Dame la palabra en mixteco: "),
                                          UsarTeclado.leerCadena("Dame la palabra en zapoteco: ")))){
                                            JOptionPane.showMessageDialog(null,"Palabra agregada correctamente");
                                            } else {
                                                JOptionPane.showMessageDialog(null,"Error al agregar la palabra");
                                            }
                arbol.escribirArchivo();
                arbol.inOrdenArchivoEspañol();
                arbol.inOrdenArchivoMixteco();
                arbol.inOrdenArchivoZapoteco();
                arbol.escribirArchivoEspañol();
                arbol.escribirArchivoMixteco();
                arbol.escribirArchivoZapoteco();
            }
            
        }while(option[opcion] != option[0]);
    }
}
