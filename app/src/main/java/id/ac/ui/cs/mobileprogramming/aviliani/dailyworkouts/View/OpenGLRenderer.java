package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.View;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OpenGLRenderer implements GLSurfaceView.Renderer {

    private Context context;
    private Square square;

    public OpenGLRenderer(Context context) {
        this.context = context;
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
//        GLES20.glClearColor(0.302f, 0.318f, 0.451f,1f);

        square = new Square(context);
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int w, int h) {
        GLES20.glViewport(0, 0, w, h);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClearColor(0.302f, 0.318f, 0.451f,1f);
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);

        square.draw();
    }
}
