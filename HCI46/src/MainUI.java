import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;
import javax.swing.*;
import java.awt.*;


public class MainUI extends JFrame  implements GLEventListener{

    private JComboBox<String> furnitureSelector;
    private static final long serialVersionUID = 1L;
    private GLJPanel gljpanel;


    private JPanel mainPanel;

    public MainUI() {
        setTitle("Furniture Renderer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create OpenGL panel
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        gljpanel = new GLJPanel(capabilities);
        gljpanel.setPreferredSize(new Dimension(800, 600));

        // Create furniture selector dropdown
        String[] furnitureItems = {"Chair", "Table", "Cupboard"};
        furnitureSelector = new JComboBox<>(furnitureItems);
        gljpanel.addGLEventListener(this);
        furnitureSelector.addActionListener(e -> {

        });

        // Add components to content pane
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(furnitureSelector, BorderLayout.NORTH);
        contentPane.add(gljpanel, BorderLayout.CENTER);

        // Set up OpenGL event listener
        gljpanel.addGLEventListener(this);

        pack();
        setLocationRelativeTo(null);
    }
    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f); // Background color
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        //Dispose
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        drawCupboard(gl);
//        furnitureSelector.addActionListener(e->{
//            String selectedItem = (String) furnitureSelector.getSelectedItem();
//            switch (selectedItem) {
//                case "Chair":
//                    drawChair(gl);
//                    break;
//                case "Table":
//                    drawTable(gl);
//                    break;
//                case "Cupboard":
//                    drawCupboard(gl);
//                    break;
//            }
//        });
        // Draw selected furniture item


        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int i, int i1, int i2, int i3) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-1.5, 1.5, -1.5, 1.5, -1.0, 1.0); // Adjust as necessary
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();

    }
    private void drawChair(GL2 gl) {
        // Draw chair seat
        gl.glColor3f(0.5f, 0.35f, 0.05f); // Brown color
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(-0.5f, -0.5f);
        gl.glVertex2f(0.5f, -0.5f);
        gl.glVertex2f(0.5f, 0.0f);
        gl.glVertex2f(-0.5f, 0.0f);
        gl.glEnd();

        // Draw chair back
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(-0.5f, 0.0f);
        gl.glVertex2f(0.0f, 0.0f);
        gl.glVertex2f(0.0f, 1.0f);
        gl.glVertex2f(-0.5f, 1.0f);
        gl.glEnd();

        // Draw chair legs
        gl.glColor3f(0.3f, 0.3f, 0.3f); // Gray color
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(-0.4f, -0.7f);
        gl.glVertex2f(-0.3f, -0.7f);
        gl.glVertex2f(-0.3f, -0.5f);
        gl.glVertex2f(-0.4f, -0.5f);

        gl.glVertex2f(0.3f, -0.7f);
        gl.glVertex2f(0.4f, -0.7f);
        gl.glVertex2f(0.4f, -0.5f);
        gl.glVertex2f(0.3f, -0.5f);
        gl.glEnd();
    }
    private void drawTable(GL2 gl) {
        // Draw table top
        gl.glColor3f(0.6f, 0.4f, 0.2f); // Wood color
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(-0.8f, -0.8f);
        gl.glVertex2f(0.8f, -0.8f);
        gl.glVertex2f(0.8f, -0.7f);
        gl.glVertex2f(-0.8f, -0.7f);
        gl.glEnd();

        // Draw table legs
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(-0.7f, -1.0f);
        gl.glVertex2f(-0.6f, -1.0f);
        gl.glVertex2f(-0.6f, -0.7f);
        gl.glVertex2f(-0.7f, -0.7f);

        gl.glVertex2f(0.6f, -1.0f);
        gl.glVertex2f(0.7f, -1.0f);
        gl.glVertex2f(0.7f, -0.7f);
        gl.glVertex2f(0.6f, -0.7f);
        gl.glEnd();
    }

    private void drawCupboard(GL2 gl) {
        // Draw cupboard body
        gl.glColor3f(0.2f, 0.2f, 0.6f); // Blue color
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(-0.8f, 0.2f);
        gl.glVertex2f(0.8f, 0.2f);
        gl.glVertex2f(0.8f, 0.8f);
        gl.glVertex2f(-0.8f, 0.8f);
        gl.glEnd();

        // Draw cupboard doors
        gl.glColor3f(0.4f, 0.4f, 0.4f); // Gray color
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(-0.8f, 0.2f);
        gl.glVertex2f(-0.6f, 0.2f);
        gl.glVertex2f(-0.6f, 0.8f);
        gl.glVertex2f(-0.8f, 0.8f);

        gl.glVertex2f(0.6f, 0.2f);
        gl.glVertex2f(0.8f, 0.2f);
        gl.glVertex2f(0.8f, 0.8f);
        gl.glVertex2f(0.6f, 0.8f);
        gl.glEnd();
    }
    public static void main(String[] args){
//        try {
//            MainUI loginFrame = new MainUI();
//            loginFrame.setVisible(true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        SwingUtilities.invokeLater(() -> {
            MainUI renderer = new MainUI();
            renderer.setVisible(true);
        });
    }


}
