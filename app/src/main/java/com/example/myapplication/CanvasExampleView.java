package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Path;
import android.view.View;

/**
 * Created by zhaosong on 2018/6/18.
 */

public class CanvasExampleView extends View {

    private String action = "";

    public CanvasExampleView(Context context) {
        super(context);

        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();

        paint.setTextSize(100);

        paint.setColor(Color.GREEN);

        // Set the point, line width. If do not set this, the point is too small to see, the line is too thin also.
        paint.setStrokeWidth(3);

        // Fill out the background color to refresh the screen.
        canvas.drawColor(Color.BLUE);

        if(ConstantsUtil.DRAW_POINT.equals(action))
        {
            // Draw one point in pixel.
            canvas.drawPoint(100, 200, paint);
        }else if(ConstantsUtil.DRAW_TWO_POINT.equals(action))
        {
            // Draw multiple points ( two point ) in pixel.
            float pointsArray[] = {180, 260, 260, 300};
            canvas.drawPoints(pointsArray, paint);
        }else if(ConstantsUtil.DRAW_ARC.equals(action))
        {
            RectF rectF = new RectF(100, 200, 800, 900);
            paint.setAlpha(0x88);
            canvas.drawArc(rectF, 30, 100, true, paint);

        }else if(ConstantsUtil.DRAW_CIRCLE.equals(action))
        {
            // Draw a circle.
            canvas.drawCircle(600,800, 600, paint);
        }else if(ConstantsUtil.DRAW_CIRCLE_PATH_TEXT.equals(action))
        {
            Path arcPath = new Path();

            arcPath.addCircle(500, 800, 600, Path.Direction.CW);

            canvas.drawTextOnPath("dev2qa.com", arcPath, 600, 0, paint);

        }else if(ConstantsUtil.DRAW_LINE.equals(action))
        {
            // Draw the long line.
            canvas.drawLine(100, 500, 1000, 510, paint);
        }else if(ConstantsUtil.DRAW_OVAL.equals(action))
        {
            paint.setARGB(0x77, 0x11, 0x00, 0x66);
            RectF rectF = new RectF(100, 200, 800, 800);
            canvas.drawOval(rectF, paint);
        }else if(ConstantsUtil.DRAW_PATH.equals(action))
        {
            Path path = new Path();

            // Set start point.
            path.moveTo(100, 200);

            // Path one.
            path.lineTo(500, 800);

            // Path two.
            path.lineTo(300, 1000);

            //Path three.
            path.lineTo(350,400);

            // Path complete.
            path.close();

            canvas.drawPath(path, paint);

        }else if(ConstantsUtil.DRAW_RECTANGLE.equals(action))
        {
            paint.setStyle(Paint.Style.STROKE);
            // Draw rectangle
            canvas.drawRect(100, 1000, 800, 1300, paint);
        }else if(ConstantsUtil.DRAW_ROUND_RECTANGLE.equals(action))
        {
            RectF rectF = new RectF(100, 200, 800, 1000);
            canvas.drawRoundRect(rectF, 100, 200, paint);
        }else if(ConstantsUtil.DRAW_TEXT.equals(action))
        {
            paint.setTextAlign(Paint.Align.CENTER);
            // Draw text.
            canvas.drawText("dev2qa.com", 600, 600, paint);
        }else if(ConstantsUtil.DRAW_TWO_LINE.equals(action))
        {
            // Draw two short lines.
            float linePointsArray[] = {10, 550, 120, 600, 120, 600, 230, 620, 230, 620, 10, 550};
            canvas.drawLines(linePointsArray, paint);
        }
    }

    public void drawPoint()
    {
        action = ConstantsUtil.DRAW_POINT;
        invalidate();
    }

    public void drawTwoPoint()
    {
        action = ConstantsUtil.DRAW_TWO_POINT;
        invalidate();
    }

    public void drawLine()
    {
        action = ConstantsUtil.DRAW_LINE;
        invalidate();
    }

    public void drawTwoLine()
    {
        action = ConstantsUtil.DRAW_TWO_LINE;
        invalidate();
    }

    public void drawCircle()
    {
        action = ConstantsUtil.DRAW_CIRCLE;
        invalidate();
    }

    public void drawCirclePathText()
    {
        action = ConstantsUtil.DRAW_CIRCLE_PATH_TEXT;
        invalidate();
    }

    public void drawRectangle()
    {
        action = ConstantsUtil.DRAW_RECTANGLE;
        invalidate();
    }

    public void drawRoundRectangle()
    {
        action = ConstantsUtil.DRAW_ROUND_RECTANGLE;
        invalidate();
    }

    public void drawOval()
    {
        action = ConstantsUtil.DRAW_OVAL;
        invalidate();
    }

    public void drawArc()
    {
        action = ConstantsUtil.DRAW_ARC;
        invalidate();
    }

    public void drawPath()
    {
        action = ConstantsUtil.DRAW_PATH;
        invalidate();
    }

    public void drawText()
    {
        action = ConstantsUtil.DRAW_TEXT;
        invalidate();
    }
}