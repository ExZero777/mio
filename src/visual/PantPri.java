
package visual;

import Vinculos.Letras;
import Vinculos.Numeros;
import Vinculos.Simbolos;
import control.BorBa;
import control.BorMouse;
import control.ContCons;
import control.EspMouse;
import control.GuarTexto;
import control.SalirPro;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;



public class PantPri extends JFrame {
    
    private JButton borrar = new JButton("Borrar Letra");
    private JButton espacio = new JButton("__");
    private JButton guardar = new JButton("Guardar Registraso");
    private JButton borrarBa = new JButton("Borrar De Base");
    private JButton consulta = new JButton("Consulta De Texto");
    private JTextField texto = new JTextField();
    //private JTextField texId= new  JTextField();
    private Integer id;
    private ArrayList<Letras> arrLetra = new ArrayList();
    private ArrayList<Numeros> arrLetra2 = new ArrayList();
    private ArrayList<Simbolos> arrLetra3 = new ArrayList();
    private GridLayout contenedor = new GridLayout(5,10);
    
    
    private BorMouse borra = new BorMouse(texto);
    private EspMouse espac = new EspMouse(texto);
    private GuarTexto guar = new GuarTexto(texto);
    private BorBa borrBa = new BorBa(id,texto);
    private ContCons consul = new ContCons(texto);
    
    private SalirPro  sali = new SalirPro();
    
    private JButton salir = new JButton("Salir");
    
    public PantPri() {
        this.setSize(3000, 3000);
        this.setLayout(contenedor);
        this.agregarComponentes();
        this.setVisible(true);
       
    }
    private void agregarComponentes(){
        Integer i;
        //this.add(textId);
        this.add(consulta);
        consulta.addMouseListener(consul);
        this.add(borrarBa);
        borrarBa.addMouseListener(borrBa);
        this.add(guardar);
        guardar.addMouseListener(guar);
        this.add(borrar);
        borrar.addMouseListener(borra);
        this.add(espacio);
        espacio.addMouseListener(espac); 
        this.add(salir);        
        salir.addMouseListener(sali);
        this.cargarTodo();
        //this.cargarLetras();
        //this.cargarNumeros();
        //this.cargarSimbolos();
        this.add(texto);
        for (i = 0; i < arrLetra.size(); i++){
            this.add(arrLetra.get(i));
        }
        for (i = 0; i < arrLetra2.size(); i++){
            this.add(arrLetra2.get(i));
        }
        for (i = 0; i < arrLetra3.size(); i++){
            this.add(arrLetra3.get(i));
        }
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }
    
  /*  private void cargarLetras(){
        Integer i;
        for (i = 97; i <= 122; i++){
           arrLetra.add(new Letras(String.valueOf((char)(int) i), texto));
        }
    }        

    private void cargarNumeros() {
        Integer f;
        for (f = 48; f <= 57; f++){
           arrLetra2.add(new Numeros(String.valueOf((char)(int) f), texto));
        }

    }

    private void cargarSimbolos() {
        Integer g;
        for (g = 123; g <= 254; g++){
           arrLetra3.add(new Simbolos(String.valueOf((char)(int) g), texto));
        }
    }
  */
    private void cargarTodo(){
        Integer i;
        for (i = 48; i <= 254; i++){
           arrLetra.add(new Letras(String.valueOf((char)(int) i), texto));
        }
    }        
}
