package laboratorio.pkg3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Animacion extends JFrame {
    
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
      labelImagen = new JLabel(imagenes[indiceimagen]);
      labelImagen.setHorizontalAlignment(JLabel.CENTER);
      add(labelImagen,BorderLayout.CENTER);
      
      //crear un JSlider
      sliderVelocidad = new JSlider(JSlider.HORIZONTAL,100,2000,1000);
      sliderVelocidad.setMajorTickSpacing(500);
      sliderVelocidad.setMinorTickSpacing(100);
      sliderVelocidad.setPaintTicks(true);
      sliderVelocidad.setPaintLabels(true);
      sliderVelocidad.addChangeListener(new ChangeListener(){
          public void stateChanged(ChangeEvent e){
              cambiarVelocidad();
          }
      });
        add(sliderVelocidad, BorderLayout.SOUTH);
      
      //temporizador para actualizar imagen
      timer = new Timer (1000,new ActionListener() {
            @Override
         public void actionPerformed(ActionEvent e) {
                actualizarImagen(); 
      }
    }); 
      timer.start();
      
    }
    
//metodo para actualizar imagen
    private void actualizarImagen(){
        indiceimagen = (indiceimagen + 1) % imagenes.length;
        labelImagen.setIcon(imagenes[indiceimagen]);
    }

//metodo para cambiar la velocidad
    private void cambiarVelocidad(){
        int delay = sliderVelocidad.getValue();
        timer.setDelay(delay);
    }
}