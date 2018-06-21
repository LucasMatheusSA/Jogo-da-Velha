
import java.util.Scanner;
import java.util.Random;


public class Jogo {

    public static void main(String[] args) {
        int opMenu=1;
        Scanner s = new Scanner(System.in);
        do{
            limpar();
            System.out.println("---MENU---");
            System.out.println("");
            System.out.println("1-JOGAR");
            System.out.println("0-SAIR");
            opMenu=s.nextInt();
            switch (opMenu) {
                case 1:
                    limpar();
                    menuJogo();
                    break;
                case 0:break;
                default:
                    break;
            }
        }while(opMenu!=0);
    }
    
    public static void menuJogo(){
        int[][] jogo = new int[3][3];
        Scanner s=new Scanner(System.in);
        int op=4;
        limparJogo(jogo);
        do{
            System.out.println("1-Facil");
            System.out.println("2-Medio");
            System.out.println("3-Dificil");
            System.out.println("0-Voltar");
            op=s.nextInt();
            switch (op) {
            case 1:
                limpar();
                fase1(jogo);
                break;
            case 2:
                limpar();
                System.out.println("Medio");
                break;
            case 3:
                limpar();
                System.out.println("Dificil");
                break;
            default:
                break;
            }
        }while(op!=0);
    }

    public static void jogador(int jogo[][],Long num){
        Scanner s = new Scanner(System.in);
        do{
            switch(num){
                case 1:jogo[2][0]=1;break;
                case 2:jogo[2][1]=1;break;
                case 3:jogo[2][2]=1;break;
                case 4:jogo[1][0]=1;break;
                case 5:jogo[1][1]=1;break;
                case 6:jogo[1][2]=1;break;
                case 7:jogo[0][0]=1;break;
                case 8:jogo[0][1]=1;break;
                case 9:jogo[0][2]=1;break;
                default:System.out.println("jogada invalida!");num=s.nextInt();break;
            }
        }while(num<0 && num >9);
    }

    public static void aleatorio(int jogo[][]){
        Random r = new Random(4);
        int x=r.nextInt(4),y=r.nextInt(4);
        while(jogo[x][y]!=0){
            x=r.nextInt(4);
            y=r.nextInt(4);
        }
        jogo[x][y]=2;
    }

    public static void fase1(int jogo[][]){
        Random r = new Random(2);
        Scanner s = new Scanner(System.in);
        Long num=r.nextInt(2);
        if(num==1){
            System.out.println("Jogador comeca jogando");
            do{
                printJogo(jogo);
                System.out.print("Digite sua jogada:");
                num=s.nextInt();
                jogador(jogo, num);
                aleatorio(jogo);
            }while(gameOver(jogo)==0);
        }else{
            System.out.println("Computador comeca jogando");
            do{
                aleatorio(jogo);
                printJogo(jogo);
                System.out.print("Digite sua jogada:");
                num=s.nextInt();
                jogador(jogo, num);
            }while(gameOver(jogo)==0);
        }
    }

    public static void limparJogo(int jogo[][]){
        for(int x=0;x<3;x++){
            for(int y=0;y<3;y++){
                jogo[x][y]=0;
            }
        }
    }

    public static int gameOver(int jogo[][]){
        if((jogo[0][0]==1 && jogo[1][1]==1 && jogo[2][2]==1) || (jogo[2][0]==1 && jogo[1][1]==1 && jogo[0][2]==1)){
            return 1;
        }
        if((jogo[0][0]==1 && jogo[0][1]==1 && jogo[0][2]==1) || (jogo[1][0]==1 && jogo[1][1]==1 && jogo[1][2]==1) || (jogo[2][0]==1 && jogo[2][1]==1 && jogo[2][2]==1)){
            return 1;
        }
        if((jogo[0][0]==1 && jogo[1][0]==1 && jogo[2][0]==1) || (jogo[0][1]==1 && jogo[1][1]==1 && jogo[2][1]==1) || (jogo[0][2]==1 && jogo[1][2]==1 && jogo[2][2]==1)){
            return 1;
        }

        if((jogo[0][0]==2 && jogo[1][1]==2 && jogo[2][2]==2) || (jogo[2][0]==2 && jogo[1][1]==2 && jogo[0][2]==2)){
            return 2;
        }
        if((jogo[0][0]==2 && jogo[0][1]==2 && jogo[0][2]==2) || (jogo[1][0]==2 && jogo[1][1]==2 && jogo[1][2]==2) || (jogo[2][0]==2 && jogo[2][1]==2 && jogo[2][2]==2)){
            return 2;
        }
        if((jogo[0][0]==2 && jogo[1][0]==2 && jogo[2][0]==2) || (jogo[0][1]==2 && jogo[1][1]==2 && jogo[2][1]==2) || (jogo[0][2]==2 && jogo[1][2]==2 && jogo[2][2]==2)){
            return 2;
        }
		return 0;
    }

    public static char printX(int jogo){
        if(jogo == 1 ){
            return 'X';
        }else if(jogo==2){
            return 'O';
        }else{
            return ' ';
        }
    }

    public static void printJogo(int jogo[][]){
        System.out.println(printX(jogo[0][0])+" | "+printX(jogo[0][1])+" | "+printX(jogo[0][2]));
        System.out.println("_   _   _");
        System.out.println(printX(jogo[1][0])+" | "+printX(jogo[1][1])+" | "+printX(jogo[1][2]));
        System.out.println("_   _   _");
        System.out.println(printX(jogo[2][0])+" | "+printX(jogo[2][1])+" | "+printX(jogo[2][2]));
    }

    public static void limpar(){
        for (int i=0; i<50; i++)
        {
            System.out.println();
        }
     }
    
}