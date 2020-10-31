package com.bham.pij.assignments.edgedetector;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.*;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class EdgeDetector {
    public Image filterImage(Image image){
        Color[][] imgArray = getPixelDataExtended(image);
        imgArray = applyGreyscale(imgArray);
        imgArray = applyFilter(imgArray,createFilter());

        WritableImage writableImage = new WritableImage(imgArray.length, imgArray.length);
        PixelWriter pw = writableImage.getPixelWriter();
        for (int i = 1; i < imgArray.length-1; i++) {
            for (int j = 1; j < imgArray.length-1; j++) {
                pw.setColor(i-1, j-1, imgArray[i][j]); }
        }
        return writableImage;
    }

    public float[][] createFilter(){
        return new float[][]{{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};
    }
    
    public Color[][] getPixelDataExtended(Image image) {
        int imgHeight = (int)image.getHeight();
        int imgWidth = (int)image.getWidth();
        Color[][] imgArray = new Color[imgHeight+2][imgWidth+2];

        PixelReader pixelReader = image.getPixelReader();

        for(int i = 0; i < imgHeight+2; i++) {
            for (int j = 0; j < imgWidth+2; j++) {

                if(i == 0 || j==0||i == imgHeight+1||j==imgWidth+1){
                    imgArray[i][j] = new Color(0,0,0,1);
                }
                else {
                    imgArray[i][j] = pixelReader.getColor(i-1, j-1);
                }
            }
        }
        return imgArray;
    }

    public Color[][] getPixelData(Image image){
        int imgHeight = (int)image.getHeight();
        int imgWidth = (int)image.getWidth();
        Color[][] imgArray = new Color[imgHeight][imgWidth];
        PixelReader pixelReader = image.getPixelReader();
        for(int i = 0; i < imgHeight+2; i++) {
            for (int j = 0; j < imgWidth+2; j++) {
                imgArray[j][i] = pixelReader.getColor(j, i);
            }
        }
        return imgArray;
    }
    public Color[][] applyGreyscale(Color[][] pixels){
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels.length; j++) {
                double newColor = (pixels[i][j].getRed()+pixels[i][j].getBlue()+pixels[i][j].getGreen())/3;
                pixels[i][j] = new Color(newColor,newColor,newColor,1);
            }

        }
        return pixels;
    }
    //error lies in these loops
    public Color[][] applyFilter(Color[][] pixels, float[][] filter){
        Color[][] newPixels = new Color[pixels.length][pixels.length];
        for (int i = 1; i < pixels.length-1; i++) {
            for (int j = 1; j < pixels.length-1; j++) {
                double newRed = 0;
                double newGreen = 0;
                double newBlue = 0;
                for (int k = 0; k < filter.length; k++) {
                    for (int l = 0; l < filter.length; l++) {
                        newRed += pixels[i-1+k][j-1+l].getRed()*filter[k][l];
                        newGreen += pixels[i-1+k][j-1+l].getGreen()*filter[k][l];
                        newBlue += pixels[i-1+k][j-1+l].getBlue()*filter[k][l];
                    }
                }

                newPixels[i][j] = new Color(colourValidation(newRed),colourValidation(newGreen),colourValidation(newBlue),1);
            }

        }
        return newPixels;
    }

    public float colourValidation(double colour) {
        if (colour>1){
            return 1;
        }
        else if (colour<0){
            return 0;
        }
        else {
            return (float) colour;
        }
    }
}
