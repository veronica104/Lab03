package laboratorio.pkg3;

import java.awt.BorderLayout;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class Animacion {
    
    private JLabel  labelImagen;
    private JSlider sliderVelocidad;
    private Timer timer;
    private int indiceimagen = 0;
    private ImageIcon[] imagenes;
    
    public Animacion(){
        imagenes = new ImageIcon[]{
           new ImageIcon("man1.jpg"),
           new ImageIcon("man2.jpg"),
           new ImageIcon("man3.jpg"),
           new ImageIcon("man4.jpg"),
           new ImageIcon("man5.jpg"),
           new ImageIcon("man6.jpg"),
           new ImageIcon("man7.jpg")
        };
        
      //configurar interfaz g
      setTitle("Animacion de imagenes");
      setSize(400,300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new BorderLayout());
      
      //crear un jLabel 
      labelImagen = new JLabel(imagenes[indiceImagen]);
      labelImagen.setHorizontalAlignment(JLabel.CENTER);
      add(labelImagen,BorderLayout.CENTER);
      
      //crear un JSlider
      sliderVelocidad = new JSlider(JSlider.HORIZONTAL,100,2000,1000);
      
      
    } 
    
}
