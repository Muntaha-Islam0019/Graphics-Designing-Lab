import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import java.lang.Math;
import javax.swing.JFrame;

class ThirdGLEventListener implements GLEventListener {
/**
 * Interface to the GLU library.
 */
private GLU glu;

/**
 * Take care of initialization here.
 */
public void init(GLAutoDrawable gld) {
    GL2 gl = gld.getGL().getGL2();
    glu = new GLU();

    gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    gl.glViewport(-250, -150, 250, 150);
    gl.glMatrixMode(GL2.GL_PROJECTION);
    gl.glLoadIdentity();
    glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
}

/**
 * Take care of drawing here.
 */
public void display(GLAutoDrawable drawable) {
    GL2 gl = drawable.getGL().getGL2();

    gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
    /*
     * put your code here
     */
    
    // As my ID is 18101079, I'll be drawing an F.
    // As it's instructed to make at least 1 line dashed, I'll try to make all the lines dashed.
    
    gl.glBegin(GL2.GL_POINTS);
    
    dashedDDA(gl, 0.0f, 100.0f, 75.0f, 100.0f);
    dashedDDA(gl, 0.0f, 100.0f, 5.0f, 0.0f);
    dashedDDA(gl, 0.0f, 50.0f, 50.0f, 50.0f);
    
    gl.glEnd();
}

private void dashedDDA(GL2 gl, float x1, float y1, float x2, float y2) {
	
	gl.glColor3d(0, 1, 1);
//	gl.glPointSize(5.0f);
	
	float copyOfx1 = x1;
	float copyOfy1 = y1;
	   
//	gl.glBegin(GL2.GL_POINTS);

	float length =  ((x2-x1) > (y2-y1)) ? (x2-x1) : (y2-y1);

	float dx = (x2-x1) / length;

	float dy = (y2-y1) / length;

	gl.glVertex2d(copyOfx1, copyOfy1);

	int i = 0;
	while (i < length) {

		copyOfx1 += dx;
		copyOfy1 += dy;
		
		gl.glVertex2d(copyOfx1, copyOfy1);
		
		i++;

	}
    
//    gl.glEnd();
}

public void reshape(GLAutoDrawable drawable, int x, int y, int width,
        int height) {
}

public void displayChanged(GLAutoDrawable drawable,
        boolean modeChanged, boolean deviceChanged) {
}

public void dispose(GLAutoDrawable arg0)
{
 
}
}
public class Task_02
{
public static void main(String args[])
{
 //getting the capabilities object of GL2 profile
 final GLProfile profile=GLProfile.get(GLProfile.GL2);
 GLCapabilities capabilities=new GLCapabilities(profile);
 // The canvas
 final GLCanvas glcanvas=new GLCanvas(capabilities);
 ThirdGLEventListener b=new ThirdGLEventListener();
 glcanvas.addGLEventListener(b);
 glcanvas.setSize(400, 400);
 //creating frame
 final JFrame frame=new JFrame("Basic frame");
 //adding canvas to frame
 frame.add(glcanvas);
 frame.setSize(640,480);
 frame.setVisible(true);
}
}