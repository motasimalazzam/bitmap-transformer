# bitmap-transformer

## Architecture

The programing language used to build this project is Java.

**Authors**: Motasim Al-Azzam and Maryam Najjar

## Overview

In this project, we built a bitmap(`.bmp`) transformer CLI. It reads a bitmap from disk and applies 3 methods in the (`.bmp`) file to change it and then Write it out to a new file. Also, we run `./gradlew run --args 'input output transform'` to run our application.

## Methods

### In Bitmap class

In this class we declared four variables:

1. **inputFilePath**: It is a `String` variable, and its purpose to store the path of the input (`.bmp`) file.

2. **outputFilePath**: It is a `String` variable, and its purpose to store the path of a new (`.bmp`) file.

3. **newFileName**: It is a `String` variable, and its purpose to store the name of a new (`.bmp`) file.

4. **image**: It is `BufferedImage` variable, and we use this variable to store the image in it and apply the methods on it.

* **readFile()**: This method reads the file that contains the image that we want to apply the change on it by creating a new variable from `File` class and store the path file in **file** variable. Also, we use the `ImageIO.read(file)` class to read the image and store it in image variable.  

* **saveFile()**: This method saves the new file after we applied the methods that make changes to it.

* **grayScale()**: This is the first method for changing image color. It changes the image color to a gray color by calculating the average value of **RGB** and use this value to convert it into a gray image.

* **imageFlipHorizontal()**: This method for flipping the image horizontally.

* **imageFlipVertical()**: This method for flipping the image vertically.

### In UserInput class

* **userInput()**: This method has two main purposes, the first is to display an indicative text to the user to guide him in the input process, such as entering the file and choosing a name for the file. The second purpose is to store the choice number that the user wrote in `transformerChoice`  variable. Also in this method, we call the **manipulateBitmap()**.

* **manipulateBitmap()**: This method to check which number that user chose after that call **setBitmapClass()** method.

* **setBitmapClass()**: This method to apply the method that in **Bitmap class** depends on the value of `transformerChoice`. If `transformerChoice` equal one it will apply ``grayScale()`` method and if it equal two it will apply `imageFlipHorizontal()` method and if it equal three it will apply `imageFlipVertical()` method.