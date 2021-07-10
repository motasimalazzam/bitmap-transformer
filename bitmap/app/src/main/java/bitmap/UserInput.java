package bitmap;

import java.util.Scanner;

class UserInput {
    private static final int EXIT = 0;
    private static int transformerChoice;
    private static String fileToManipulate;
    private static String newFileName;

    private static Scanner scan = new Scanner(System.in);


    static void userInput() {
        System.out.println("Enter a Bitmap file to manipulate (must include '.bmp') or 0 to exit: ");
        fileToManipulate = scan.nextLine();
        if (fileToManipulate.equals("0")) return;
        System.out.println("Enter a name for your new file (do not include a file extension): ");
        newFileName = scan.nextLine();
        do {
            System.out.println("Transformation Choice: \n" +
                    "---------------------------------\n" +
                    "0 : Exit\n" +
                    "1 : gray-scale\n" +
                    "2 : Flip Horizontal\n" +
                    "3 : Flip Vertical\n");
            System.out.println("Enter a transformation type (enter a number only): ");
            try {
                transformerChoice = Integer.parseInt(scan.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("You did not enter a number, please try again\n");
            }
        } while (true);
        System.out.println();
        manipulateBitmap();
    }

    private static void manipulateBitmap() {
        if (transformerChoice == EXIT) return;
        else {
            if (transformerChoice == 1 || transformerChoice == 2 || transformerChoice == 3) {
                setBitmapClass();
            }
            else System.out.println("\nNot a correct option\n");
        }
        userInput();
    }

    private static void setBitmapClass() {
        String imageFilePath = "C:\\Users\\Motas\\asac\\401\\bitmap\\bitmap-transformer\\bitmap\\app\\src\\main\\resources\\" + fileToManipulate;
        String newFilePath = "C:\\Users\\Motas\\asac\\401\\bitmap\\bitmap-transformer\\bitmap\\app\\src\\main\\resources\\";
        String newFile = newFileName + ".bmp";

        Bitmap newImage = new Bitmap(imageFilePath, newFilePath, newFile);
        newImage.readFile();

        if (transformerChoice == 1) {
            newImage.grayScale();
        } else if (transformerChoice == 2) {
            newImage.imageFlipHorizontal();
        } else {
            newImage.imageFlipVertical();
        }

        newImage.saveFile();
        System.out.println(String.format("%s created, viewable upon exit\n", newFileName));
    }
}