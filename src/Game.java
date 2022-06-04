

import java.util.Scanner;

public class Game {
    Scanner input = new Scanner(System.in);
    String[][] gameArea;
    String[][] bomb;



    public void Start() {
        System.out.print("Satır sayısı giriniz : ");
        int row = input.nextInt();
        System.out.print("Sütun sayısı giriniz : ");
        int col = input.nextInt();

        setGameArea(row,col);
        System.out.println();
        setBomb(row,col);

        int round=(row*col)-(int)((row*col)/4);
        System.out.println("Mayin Tarlasi Oyuna Hosgeldiniz !");
        while (round>0) {
            System.out.print("Satır giriniz ");
            int rowInLine = input.nextInt();
            System.out.print("Sütun giriniz ");
            int colInLine = input.nextInt();

            if(colInLine <0 || colInLine >=col || rowInLine<0 || rowInLine>=row) {
                System.out.println("Yanlıs değer girdiniz!");
                continue;
            }else {
                if(bomb[rowInLine][colInLine].equals("*")) {
                    System.out.println("Oyunu kaybettiniz!");
                    break;
                }else {
                    int sum = 0;
                    if(rowInLine==0 && colInLine==0 ) {
                        for(int i=rowInLine;i<=rowInLine+1;i++) {
                            for(int j=colInLine;j<=colInLine+1;j++) {
                                if(bomb[i][j].equals("*")) {sum++;}
                            }
                        }
                    }else if (rowInLine==row-1 && colInLine==col-1 ) {
                        for(int i=rowInLine-1;i<=rowInLine;i++) {
                            for(int j=colInLine-1;j<=colInLine;j++) {
                                if(bomb[i][j].equals("*")) {sum++;}
                            }
                        }
                    }else if((rowInLine>0 && colInLine>0) && (rowInLine< row-1 && colInLine < col-1)) {
                        for(int i=rowInLine-1;i<=rowInLine+1;i++) {
                            for(int j=colInLine-1;j<=colInLine+1;j++) {
                                if(bomb[i][j].equals("*")) {sum++;}
                            }
                        }
                    }else if(rowInLine==0 && colInLine != col-1 && colInLine!=0) {
                        for(int i=rowInLine;i<=rowInLine+1;i++) {
                            for(int j=colInLine-1;j<=colInLine+1;j++) {
                                if(bomb[i][j].equals("*")) {sum++;}
                            }
                        }
                    }else if(rowInLine==row-1 && colInLine != 0 && colInLine!=col-1) {
                        for(int i=rowInLine-1;i<=rowInLine;i++) {
                            for(int j=colInLine-1;j<=colInLine+1;j++) {
                                if(bomb[i][j].equals("*")) {sum++;}
                            }
                        }
                    }else if(rowInLine!=row-1 && rowInLine != 0 && colInLine==0) {
                        for(int i=rowInLine-1;i<=rowInLine+1;i++) {
                            for(int j=colInLine;j<=colInLine+1;j++) {
                                if(bomb[i][j].equals("*")) {sum++;}
                            }
                        }
                    }else if(rowInLine!=row-1 && rowInLine != 0 && colInLine== col-1) {
                        for(int i=rowInLine-1;i<=rowInLine+1;i++) {
                            for(int j=colInLine-1;j<=colInLine;j++) {
                                if(bomb[i][j].equals("*")) {sum++;}
                            }
                        }
                    }else if(rowInLine == 0 && colInLine == col-1) {
                        for(int i=rowInLine;i<=rowInLine+1;i++) {
                            for(int j=colInLine-1;j<=colInLine;j++) {
                                if(bomb[i][j].equals("*")) {sum++;}
                            }
                        }
                    }else {
                        for(int i=rowInLine-1;i<=rowInLine;i++) {
                            for(int j=colInLine;j<=colInLine+1;j++) {
                                if(bomb[i][j].equals("*")) {sum++;}
                            }
                        }
                    }
                    gameArea[rowInLine][colInLine] = String.valueOf(sum);
                    round--;
                }if (round==0){
                    for(String[] k : gameArea){
                        for(String elem : k) {
                            System.out.print(elem + " ");
                        }
                        System.out.println();
                    }
                    System.out.println("Oyunu Kazandiniz !");
                    break;

                }
                for(String[] k : gameArea){
                    for(String elem : k) {
                        System.out.print(elem + " ");
                    }
                    System.out.println();
                }
            }


        }
    }

    public void setGameArea (int row, int col) {

        gameArea = new String[row][col];
        bomb =new String[row][col];
        for (int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                bomb[i][j] = "-";
                gameArea[i][j] = "-";

            }

        }

        for(String[] k : gameArea){
            for(String elem : k) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }

    }

    public void setBomb (int row, int col) {
        int minesNum=(int)((row*col)/4);

        for (int i=0;i<minesNum;i++)
        {
            int randomX=(int)(Math.random()*row);
            int randomY=(int)(Math.random()*col);
            if (bomb[randomX][randomY]=="*"){
                minesNum++;
            }
            else {
                bomb[randomX][randomY]="*";
            }
        }
        for(String[] k : bomb){
            for(String elem : k) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }

    }
}