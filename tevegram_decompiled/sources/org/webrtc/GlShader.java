package org.webrtc;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class GlShader {
    private static final String TAG = "GlShader";
    private int program;

    public GlShader(String str, String str2) {
        int compileShader = compileShader(35633, str);
        int compileShader2 = compileShader(35632, str2);
        int glCreateProgram = GLES20.glCreateProgram();
        this.program = glCreateProgram;
        if (glCreateProgram == 0) {
            throw new RuntimeException("glCreateProgram() failed. GLES20 error: " + GLES20.glGetError());
        }
        GLES20.glAttachShader(glCreateProgram, compileShader);
        GLES20.glAttachShader(this.program, compileShader2);
        GLES20.glLinkProgram(this.program);
        int[] iArr = {0};
        GLES20.glGetProgramiv(this.program, 35714, iArr, 0);
        if (iArr[0] == 1) {
            GLES20.glDeleteShader(compileShader);
            GLES20.glDeleteShader(compileShader2);
            GlUtil.checkNoGLES2Error("Creating GlShader");
        } else {
            Logging.e(TAG, "Could not link program: " + GLES20.glGetProgramInfoLog(this.program));
            m7.c.i(GLES20.glGetProgramInfoLog(this.program));
            throw null;
        }
    }

    private static int compileShader(int i9, String str) {
        int glCreateShader = GLES20.glCreateShader(i9);
        if (glCreateShader == 0) {
            throw new RuntimeException("glCreateShader() failed. GLES20 error: " + GLES20.glGetError());
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 1) {
            GlUtil.checkNoGLES2Error("compileShader");
            return glCreateShader;
        }
        Logging.e(TAG, "Compile error " + GLES20.glGetShaderInfoLog(glCreateShader) + " in shader:\n" + str);
        m7.c.i(GLES20.glGetShaderInfoLog(glCreateShader));
        return 0;
    }

    public int getAttribLocation(String str) {
        int i9 = this.program;
        if (i9 == -1) {
            m7.c.i("The program has been released");
            return 0;
        }
        int glGetAttribLocation = GLES20.glGetAttribLocation(i9, str);
        if (glGetAttribLocation >= 0) {
            return glGetAttribLocation;
        }
        m7.c.i(androidx.activity.g.n("Could not locate '", str, "' in program"));
        return 0;
    }

    public int getUniformLocation(String str) {
        int i9 = this.program;
        if (i9 == -1) {
            m7.c.i("The program has been released");
            return 0;
        }
        int glGetUniformLocation = GLES20.glGetUniformLocation(i9, str);
        if (glGetUniformLocation >= 0) {
            return glGetUniformLocation;
        }
        m7.c.i(androidx.activity.g.n("Could not locate uniform '", str, "' in program"));
        return 0;
    }

    public void release() {
        Logging.d(TAG, "Deleting shader.");
        int i9 = this.program;
        if (i9 != -1) {
            GLES20.glDeleteProgram(i9);
            this.program = -1;
        }
    }

    public void setVertexAttribArray(String str, int i9, int i10, FloatBuffer floatBuffer) {
        if (this.program == -1) {
            m7.c.i("The program has been released");
            return;
        }
        int attribLocation = getAttribLocation(str);
        GLES20.glEnableVertexAttribArray(attribLocation);
        GLES20.glVertexAttribPointer(attribLocation, i9, 5126, false, i10, (Buffer) floatBuffer);
        GlUtil.checkNoGLES2Error("setVertexAttribArray");
    }

    public void useProgram() {
        if (this.program == -1) {
            m7.c.i("The program has been released");
            return;
        }
        synchronized (EglBase.lock) {
            GLES20.glUseProgram(this.program);
        }
        GlUtil.checkNoGLES2Error("glUseProgram");
    }

    public void setVertexAttribArray(String str, int i9, FloatBuffer floatBuffer) {
        setVertexAttribArray(str, i9, 0, floatBuffer);
    }
}
