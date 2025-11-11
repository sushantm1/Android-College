package com.example.graphicdesign;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;

/**
 * A custom View, now named DrawEverything, that allows the user to draw on it.
 */
public class GraphicDesign extends View { // Renamed from DrawingView

    private Path drawPath;
    private Paint drawPaint;

    // This constructor is called when the view is inflated from XML
    public GraphicDesign(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupDrawing();
    }

    private void setupDrawing() {
        drawPath = new Path();
        drawPaint = new Paint();

        // Configure the Paint object for drawing
        drawPaint.setColor(Color.RED);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(12f);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    /**
     * This is where the drawing happens.
     * @param canvas The canvas to draw on.
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Draw the path that has been created by the user's touch events.
        canvas.drawPath(drawPath, drawPaint);
    }

    /**
     * Captures the user's finger movements.
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // Start a new line at the touch point
                drawPath.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                // Draw a line to the new touch point
                drawPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                // User lifted their finger
                break;
            default:
                return false;
        }

        // Tell the view to redraw itself, which triggers a call to onDraw()
        invalidate();
        return true;
    }

    /**
     * Clears the drawing from the canvas.
     */
    public void clearCanvas() {
        drawPath.reset(); // Clears the path
        invalidate();     // Redraw the now-empty view
    }
}