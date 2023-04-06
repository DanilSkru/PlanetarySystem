import javax.swing.*;

public class PlanetarySystem {
    public PlanetarySystem() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        GUIplanetarySystem app = new GUIplanetarySystem();
        app.setVisible(true);
    }
    public static void main(String[] arg) {
        new PlanetarySystem();
    }
}
class GUIplanetarySystem extends JFrame{
    JLabel label_sun = new JLabel();
    JLabel label_mercury = new JLabel();
    JLabel label_venus = new JLabel();
    JLabel label_earth = new JLabel();
    JLabel label_mars = new JLabel();
    JLabel label_jupiter = new JLabel();
    JLabel label_saturn = new JLabel();
    JLabel label_uranus = new JLabel();
    JLabel label_neptune = new JLabel();
    JLabel label_pluto = new JLabel();
    public GUIplanetarySystem() {
        super("PlanetarySystem");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon space = new ImageIcon("space.jpg");
        setContentPane(new JLabel(space));
        pack();
        ImageIcon sun = new ImageIcon("sun.png");
        ImageIcon venus = new ImageIcon("venus.png");
        ImageIcon mercury = new ImageIcon("mercury.png");
        ImageIcon earth = new ImageIcon("earth.png");
        ImageIcon mars = new ImageIcon("mars.png");
        ImageIcon jupiter = new ImageIcon("jupiter.png");
        ImageIcon saturn = new ImageIcon("saturn.png");
        ImageIcon uranus = new ImageIcon("uranus.png");
        ImageIcon neptune = new ImageIcon("uranus.png");
        ImageIcon pluto = new ImageIcon("pluto.png");
        label_sun.setBounds(space.getIconWidth()/2-sun.getIconWidth()/2, space.getIconHeight()/2-sun.getIconHeight()/2, sun.getIconWidth(), sun.getIconHeight());
        label_mercury.setBounds(100, 100, mercury.getIconWidth(), mercury.getIconHeight());
        label_venus.setBounds(100, 100, venus.getIconWidth(), venus.getIconHeight());
        label_earth.setBounds(100, 100, earth.getIconWidth(), earth.getIconHeight());
        label_mars.setBounds(100, 100, mars.getIconWidth(), mars.getIconHeight());
        label_jupiter.setBounds(100, 100, jupiter.getIconWidth(), jupiter.getIconHeight());
        label_saturn.setBounds(100, 100, saturn.getIconWidth(), saturn.getIconHeight());
        label_uranus.setBounds(100, 100, uranus.getIconWidth(), uranus.getIconHeight());
        label_neptune.setBounds(100, 100, neptune.getIconWidth(), neptune.getIconHeight());
        label_pluto.setBounds(100, 100, pluto.getIconWidth(), pluto.getIconHeight());
        label_sun.setIcon(sun);
        label_mercury.setIcon(mercury);
        label_venus.setIcon(venus);
        label_earth.setIcon(earth);
        label_mars.setIcon(mars);
        label_jupiter.setIcon(jupiter);
        label_saturn.setIcon(saturn);
        label_uranus.setIcon(uranus);
        label_neptune.setIcon(uranus);
        label_pluto.setIcon(pluto);
        add(label_sun);
        add(label_mercury);
        add(label_venus);
        add(label_earth);
        add(label_mars);
        add(label_jupiter);
        add(label_saturn);
        add(label_uranus);
        add(label_neptune);
        add(label_pluto);
        setVisible(true);
        new MovingWay("MercuryWay", label_mercury, 60, 25, space.getIconWidth()/2, space.getIconHeight()/2, mercury.getIconWidth(), mercury.getIconHeight()).start();
        new MovingWay("VenusWay", label_venus, 80, 35, space.getIconWidth()/2, space.getIconHeight()/2, venus.getIconWidth(), venus.getIconHeight()).start();
        new MovingWay("EarthWay", label_earth, 105, 45, space.getIconWidth()/2, space.getIconHeight()/2, earth.getIconWidth(), earth.getIconHeight()).start();
        new MovingWay("MarsWay", label_mars, 128, 55, space.getIconWidth()/2, space.getIconHeight()/2, mars.getIconWidth(), mars.getIconHeight()).start();
        new MovingWay("JupiterWay", label_jupiter, 165, 65, space.getIconWidth()/2, space.getIconHeight()/2, jupiter.getIconWidth(), jupiter.getIconHeight()).start();
        new MovingWay("SaturnWay", label_saturn, 230, 75, space.getIconWidth()/2, space.getIconHeight()/2, saturn.getIconWidth(), saturn.getIconHeight()).start();
        new MovingWay("UranusWay", label_uranus, 280, 85, space.getIconWidth()/2, space.getIconHeight()/2, uranus.getIconWidth(), uranus.getIconHeight()).start();
        new MovingWay("NeptuneWay", label_neptune, 310, 95, space.getIconWidth()/2, space.getIconHeight()/2, neptune.getIconWidth(), neptune.getIconHeight()).start();
        new MovingWay("PlutoWay", label_pluto, 335, 105, space.getIconWidth()/2, space.getIconHeight()/2, pluto.getIconWidth(), pluto.getIconHeight()).start();
    }
}
class MovingWay extends Thread {
    JLabel label;
    int R;
    int pause_sleep;
    int x0;
    int y0;
    int w;
    int h;
    MovingWay(String name, JLabel label, int R, int pause_sleep, int x0, int y0, int w, int h) {
        super(name);
        this.label = label;
        this.R = R;
        this.pause_sleep = pause_sleep;
        this.x0 = x0;
        this.y0 = y0;
        this.w = w;
        this.h = h;
    }
    public void run() {
        try {
            while(true) {
                for (double deg=0; deg<360; deg+=1) {
                    label.setLocation((int) (x0+R*Math.cos(Math.toRadians(deg)))-w/2,
                            (int) (y0+R*Math.sin(Math.toRadians(deg)))-h/2);
                    Thread.sleep(pause_sleep);
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
