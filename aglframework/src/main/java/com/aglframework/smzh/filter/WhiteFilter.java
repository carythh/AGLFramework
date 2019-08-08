package com.aglframework.smzh.filter;

import android.content.Context;
import android.opengl.GLES20;

import com.aglframework.smzh.AGLFilter;
import com.aglframework.smzh.OpenGlUtils;
import com.aglframework.smzh.aglframework.R;

public class WhiteFilter extends AGLFilter {


    private int glUniformLevel;

    private float level;


    public WhiteFilter(Context context) {
        super(context);
    }

    @Override
    protected void onInit() {
        programId = OpenGlUtils.loadProgram(context, R.raw.single_input_v,R.raw.light_f);
        glAttrPosition = GLES20.glGetAttribLocation(programId, "position");
        glAttrTextureCoordinate = GLES20.glGetAttribLocation(programId, "inputTextureCoordinate");
        glUniformTexture = GLES20.glGetUniformLocation(programId, "inputImageTexture");
        glUniformLevel = GLES20.glGetUniformLocation(programId, "level");
    }

    @Override
    protected void onDrawArraysPre(Frame frame) {
        GLES20.glUniform1f(glUniformLevel, level);
    }

    public void setWhiteLevel(float level) {
        this.level = level;
    }
}