package laboratorio.pkg3;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Animacion extends JFrame {
    
    private JLabel labelImagen;
    private JSlider sliderVelocidad;
    private Timer tiempo;  // Declaramos el temporizador a nivel de clase
    private int indiceimagen = 0;
    private ImageIcon[] imagenes;
    
    public Animacion() {
        imagenes = new ImageIcon[]{
            new ImageIcon("man1.jpg"),
            new ImageIcon("man2.jpg"),
            new ImageIcon("man3.jpg"),
            new ImageIcon("man4.jpg"),
            new ImageIcon("man5.jpg"),
            new ImageIcon("man6.jpg"),
            new ImageIcon("man7.jpg")
        };

        // Configurar la interfaz gráfica
        setTitle("Animacion de imagenes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
      
        // Crear un JLabel 
        labelImagen = new JLabel(imagenes[indiceimagen]);
        labelImagen.setHorizontalAlignment(JLabel.CENTER);
        add(labelImagen, BorderLayout.CENTER);
      
        // Crear un JSlider
        sliderVelocidad = new JSlider(JSlider.HORIZONTAL, 100, 2000, 1000);
        sliderVelocidad.setMajorTickSpacing(500);
        sliderVelocidad.setMinorTickSpacing(100);
        sliderVelocidad.setPaintTicks(true);
        sliderVelocidad.setPaintLabels(true);
        sliderVelocidad.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                cambiarVelocidad();
            }
        });
        add(sliderVelocidad, BorderLayout.SOUTH);
      
        // Temporizador para actualizar imagen, ahora es `javax.swing.Timer`
        tiempo = new Timer(1000, e -> actualizarImagen());
        tiempo.start();
    }
    
    // Método para actualizar imagen
    private void actualizarImagen() {
        indiceimagen = (indiceimagen + 1) % imagenes.length;
        labelImagen.setIcon(imagenes[indiceimagen]);
    }

    // Método para cambiar la velocidad
    private void cambiarVelocidad() {
        int delay = sliderVelocidad.getValue();
        tiempo.setDelay(delay);  // Ajustamos el nuevo delay
    }

    public static void main(String[] args) {
        Animacion animacion = new Animacion();
        animacion.setVisible(true);
    }
}
