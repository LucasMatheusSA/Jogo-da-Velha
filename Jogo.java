
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
        s.close();
    }
    
    public static void menuJogo(){
        int[][] jogo = new int[3][3];
        Scanner s=new Scanner(System.in);
        int op=4;
        limparJogo(jogo);
        do{
            System.out.println("---MENU---");
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

    public static void jogador(int jogo[][],int num){
        Scanner s = new Scanner(System.in);
        do{
            if(num==10){
                System.out.print("Posicao ocupada! Digite novamente:");num=s.nextInt();
            }
            if(num==11){
                System.out.print("Digite novamente:");num=s.nextInt();
            }
            switch(num){ 
                case 1:if(jogo[2][0]==0)jogo[2][0]=1;else num=10;break;
                case 2:if(jogo[2][1]==0)jogo[2][1]=1;else num=10;break;
                case 3:if(jogo[2][2]==0)jogo[2][2]=1;else num=10;break;
                case 4:if(jogo[1][0]==0)jogo[1][0]=1;else num=10;break;
                case 5:if(jogo[1][1]==0)jogo[1][1]=1;else num=10;break;
                case 6:if(jogo[1][2]==0)jogo[1][2]=1;else num=10;break;
                case 7:if(jogo[0][0]==0)jogo[0][0]=1;else num=10;break;
                case 8:if(jogo[0][1]==0)jogo[0][1]=1;else num=10;break;
                case 9:if(jogo[0][2]==0)jogo[0][2]=1;else num=10;break;
                default:System.out.println("jogada invalida!");num=11;break;
            }
        }while(num<0 || num >9);
    }

    public static void aleatorio(int jogo[][]){
        Random r = new Random();
        int x=r.nextInt(3),y=r.nextInt(3);
        while(jogo[x][y]!=0){
            x=r.nextInt(3);
            y=r.nextInt(3);
        }
        jogo[x][y]=2;
    }

    public static void fase1(int jogo[][]){
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int num=0;
        int x=r.nextInt(2);
        if(x==1){
            System.out.println("Jogador comeca jogando");
            while(gameOver(jogo)==0){
                printJogo(jogo);
                System.out.print("Digite sua jogada:");
                num=s.nextInt();
                jogador(jogo, num);
                if(gameOver(jogo)!=0){
                    break;
                }
                aleatorio(jogo);
                limpar();
            }
        }else{
            System.out.println("Computador comeca jogando");
            while(gameOver(jogo)==0){
                aleatorio(jogo);
                if(gameOver(jogo)!=0){
                    break;
                }
                printJogo(jogo);
                System.out.print("Digite sua jogada:");
                num=s.nextInt();
                jogador(jogo, num);
                limpar();
            }
        }
        limpar();
        if(gameOver(jogo)==1){
            System.out.println("PARABENS JOGADOR!");
            printJogo(jogo);
        }else if(gameOver(jogo)==2){
            System.out.println("COMPUTADOR E VENCEU!");
            printJogo(jogo);
        }else{
            System.out.println("EMPATE!!!");
            printJogo(jogo);
        }
        limparJogo(jogo);
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
        if(jogo[2][0]!=0 && jogo[2][1]!=0 && jogo[2][2]!=0 && jogo[1][0]!=0 && jogo[1][1]!=0 && jogo[1][2]!=0 
                && jogo[0][0]!=0 && jogo[0][1]!=0 && jogo[0][2]!=0)
                return 3;
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