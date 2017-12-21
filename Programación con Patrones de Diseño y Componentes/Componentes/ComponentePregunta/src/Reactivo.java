
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pankecho
 */
public class Reactivo extends JPanel{
    private JLabel pregunta;
    private ButtonGroup grupo;
    private JRadioButton[] respuestas;
    private int respuestaCorrecta;
    private int ponderacion;

    public Reactivo() {
        removeAll();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.pregunta = new JLabel("");
        this.pregunta.setFont(new java.awt.Font("Avenir", 0, 13));
        this.grupo = new ButtonGroup();
        this.respuestas = new JRadioButton[3];
        
        for(int i = 0; i < respuestas.length; i++)
            respuestas[i] = new JRadioButton("Opcion " + (i+1));
        
        this.respuestaCorrecta = 0;
        this.ponderacion = 10;
        
        add(pregunta);
        
        for(int i = 0; i < respuestas.length; i++){
            respuestas[i].setFont(new java.awt.Font("Avenir", 0, 13));
            this.grupo.add(respuestas[i]);
            add(respuestas[i]);
        }
        setSize(500,400);
        setVisible(true);
    }

    public Reactivo(String pregunta, String[] respuestas, int respuestaCorrecta, int ponderacion) {
        removeAll();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.pregunta = new JLabel();
        this.pregunta.setFont(new java.awt.Font("Avenir", 0, 13));
        this.grupo = new ButtonGroup();
        this.respuestaCorrecta = respuestaCorrecta - 1;
        this.ponderacion = ponderacion;
        setPregunta(pregunta);
        
        add(this.pregunta);
        
        this.respuestas = new JRadioButton[respuestas.length];
        
        for(int i = 0; i < respuestas.length; i++){
            JRadioButton aux = new JRadioButton(respuestas[i]);
            aux.setFont(new java.awt.Font("Avenir", 0, 13));
            this.respuestas[i] = aux;
            this.grupo.add(aux);
            add(aux);
        }
        
        setSize(500,400);
        setVisible(true);
    }

    public String getPregunta() {
        return pregunta.getText();
    }

    public void setPregunta(String pregunta) {
        this.pregunta.setText(pregunta);
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta - 1;
    }

    public int getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(int ponderacion) {
        this.ponderacion = ponderacion;
    }
    
    public boolean isCorrecto(){
        return respuestas[respuestaCorrecta].isSelected();
    }
    
}
