package laboratorio.pkg3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;


public class Cronometro {
    
    private Timer timer;
    private TimerTask displayTask;
    private TimerTask alarmTask;
    private long delay;
    private long alarmInterval;
    
    public Cronometro(){
        timer = new Timer();
    }
   
    // iniciar cronometro
    public void iniciarcro(){
        displayTask = new TimerTask(){
          @Override
             public void run() {
                SimpleDateFormat sdf= new SimpleDateFormat ("HH:mm:ss");
                System.out.println(sdf.format(new Date()));
             }
        };
         
        timer.scheduleAtFixedRate(displayTask, 0, 1000);
        }
    
    //configurar alarma 
    public void configuAlarma(long minutos,long intervaloAla){
        //convertir de minutos a milisegundos
        this.delay=minutos*60*1000;
        //convertir de segundos a milisegundos
        this.alarmInterval=intervaloAla*1000;
        
        alarmTask = new TimerTask(){
            @Override
            public void run() {
               JOptionPane.showMessageDialog(null, "¡Alarma!");
            } 
        };
        
    //programar la alarma
    timer.schedule(new TimerTask(){
        @Override
         public void run() {
             timer.scheduleAtFixedRate(alarmTask,0,alarmInterval);
            }
        
    },delay);
    }
    
   Cronometro cronometro = new Cronometro();
   cronometro.iniciarcro();
   cronometro.conguiAlarma(2,10);
   
}
