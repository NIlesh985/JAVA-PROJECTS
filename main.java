package com.nilesh;
import java.util.*;

public class main {
    ArrayList arrayList=new ArrayList ();
        static ArrayList playerPosition = new ArrayList(){};
        static ArrayList CpuPosition = new ArrayList(){};

    public static void main(String[] args) {

        int pos =0;
        int cpuPos=0;
        char[][] gameboard = {
                {' ','|',' ','|',' ' },
                {'-','+','-','+','-'},
                {' ','|',' ','|' ,' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|' ,' '},
                };
        print_game_board(gameboard);
        while (true){
        Scanner scan=new Scanner(System.in);
        System.out.println("enter your placement (1-9): ");
        pos = scan.nextInt();


        while (playerPosition.contains(pos)|| CpuPosition.contains(pos)){
            System.out.println("position taken enter a correct position : ");
            pos = scan.nextInt();
        }

        System.out.println(pos);
        placepiece(gameboard,pos,"Player");

        String result = checkwinner();
        if (result.length() > 0){
            print_game_board(gameboard);
            System.out.println(result);
            break;
        }

        Random rand =new Random();
        cpuPos = rand.nextInt(9) +1;

            while (playerPosition.contains(cpuPos)|| CpuPosition.contains(pos)){
                System.out.println("position taken enter a correct position : ");
                cpuPos = rand.nextInt(9) +1;
            }
        placepiece(gameboard,cpuPos,"Cpu");

            result = checkwinner();
            if (result.length() > 0){
                print_game_board(gameboard);
                System.out.println(result);
                break;
            }
                print_game_board(gameboard);

        String winner = checkwinner();
            System.out.println(winner);
        }
    }

    public static void print_game_board(char[][] gameboard){
        for (char[]row : gameboard)
        {   for ( char c : row){
            System.out.print(c);;
        }
            System.out.println(" ");
        }

        }
    public static void placepiece(char[][] gameboard,int pos,String user){
    char symbol=' ';
        if (user.equals("Player")){
        symbol='X';
        playerPosition.add(pos);
    }else if(user.equals("Cpu")){
            symbol='O';
            CpuPosition.add(pos);
    }
        switch (pos){
            case 1:
                gameboard[0][0]= symbol;
                    break;
                    case 2:
                gameboard[0][2]= symbol;
                    break;
                    case 3:
                gameboard[0][4]= symbol;
                    break;
                    case 4:
                gameboard[2][0]= symbol;
                    break;
                    case 5:
                gameboard[2][2]= symbol;
                    break;
                    case 6:
                gameboard[2][4]= symbol;
                    break;
                    case 7:
                gameboard[4][0]= symbol;
                    break;
                    case 8:
                gameboard[4][2]= symbol;
                    break;
                    case 9:
                gameboard[4][4]= symbol;
                    break;
            default:
                break;
        }

}
    public static String checkwinner(){
        List TopRow = Arrays.asList(1,2,3);
        List MidRow = Arrays.asList(4,5,6);
        List BotRow = Arrays.asList(7,8,9);
        List LeftCol= Arrays.asList(1,4,7);
        List MidCol= Arrays.asList(2,5,8);
        List RightCol= Arrays.asList(3,6,9);
        List cross1= Arrays.asList(1,5,9);
        List cross2= Arrays.asList(7,5,3);

        List<List> winning =new ArrayList<List>();
        winning.add(TopRow);
        winning.add(MidRow);
        winning.add(BotRow);
        winning.add(LeftCol);
        winning.add(MidCol);
        winning.add(RightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning){
            if (playerPosition.containsAll(l)){
                return "***|YOU WIN|***";
            }else if (CpuPosition.containsAll(l)){
                return "***|YOU DID'NT WIN|***";
            }else if (playerPosition.size()+CpuPosition.size()== 9){
                return "***|!!!!CAT!!!!|***";
            }

    }

        return "";
}
}
