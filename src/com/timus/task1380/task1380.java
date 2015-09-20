package com.timus.task1380;

import java.util.ArrayList;
import java.util.Scanner;

/*
            Документация
   Переменные:
        board[x][y] = {0 - пустая клетка, 1 - пешка, 2 - конь, 3 - слон, 4 - ладья, 5 - ферьзь, 6 - король}
            координата a1 это x=1 и y=1
        P количестко сделанных по условию ходов
        isWhiteMove = true если ход после начальной позиции белых
        moveList[номер хода][было|стало][x|y] (было => 0, стало => 1; x => 0, y => 1; Например для a1-h1 moveList[1][1][0] = 8 (потому что это h)
        ArrayList<Peshka> peshkaList = new ArrayList<Peshka>(); Массив лист живых пешок на доске.
            peshkaList.add(new peshke(true,x,y) Добавляет пешку белого (true) цвета с координатами (x,y)
            peshkaList.get(getIofPeshka(x,y)) - пешка стоящая на (x,y) причём заведомо известно, что она там есть после проверки board[][]
            peshkaList.remove(getIofPeshka(x,y)) - удаление съеденой пешки (известно, что пешку действительно едят)
        Анологично для слонов, коней и ладей.

        Проблема: как типу фигуры в board[][] выйти на сам объект фигуры да ещё и прописать метод поедания если нужно?
        
        P.S. ООП подход представляется довольно сложным, но интересным. Не хочется полностью от него отказываться.

 */
public class Solution {
    public static int board[][] = new int[9][9];
    public static int P = 0;
    public static boolean isWhiteMove;
    public static int moveList[][][] = new int[61][2][2];

    public static ArrayList<Peshka> peshkaList = new ArrayList<Peshka>(); // Пешки, стоящие на доске

    public static void main(String[] args) throws Exception{
        dataEnter(); //Получает данные
        initialize(); //Создаёт фигуры по board[][]
        int i = 1; //какой-то ход
        move(i);//Делает ход фигурой согласно i ходу в moveList
    }



    public static class Peshka{
        public int x;
        public int y;
        public boolean color;
        public Peshka(boolean color, int x, int y){
            this.color = color;
            this.x = x;
            this.y = y;
        }
        //Проверка корректности ходов для пешки, король не должен быть под ударом после хода пешки!
        //Метод поедания другой фигуры пешкой
    }

    public static int getIofPeshka(int x, int y){ //Заведомо известно, что пешка находится по координатам (x,y) по broad
        int result = 0;
        for(int i = 1; i<=peshkaList.size(); i++){
            if (peshkaList.get(i).x == x & peshkaList.get(i).y == y){
                result = i;
            }
        }
        return result;
    }

    public static void move(int i){
        //кто стоит на moveList[i][0][0] moveList[i][0][1] находим по board[][]
        //проверка на корректность хода для данной фигуры
        //проверяем есть ли на moveList[i][1][0] moveList[i][1][1] фигура, которую съедят и если да, то делаем метод поедания.
        //Меняем борд
        //Ниже пример движения пешки
        peshkaList.get(getIofPeshka(moveList[i][0][0],moveList[i][0][1])).x = moveList[i][1][0];
        peshkaList.get(getIofPeshka(moveList[i][0][0],moveList[i][0][1])).y = moveList[i][1][1];
    }

    public static void initialize(){
        for(int i = 1; i<=8; i++)
            for(int j = 1; j<=8; j++){
                if (Math.abs(board[j][i]) == 1){
                    if (board[j][i]>0)
                        peshkaList.add(new Peshka(true,j,i));
                    else
                        peshkaList.add(new Peshka(false,j,i));
                }
            }
    }

    public static void dataEnter(){
        Scanner sc = new Scanner(System.in);
        for(int i = 8; i>=1; i--)
            for(int j = 1; j<=8; j++){
                board[j][i] = sc.nextInt();
            }

        P = sc.nextInt();
        sc.nextLine();
        if (sc.nextLine().equals("White"))
            isWhiteMove = true;
        else
            isWhiteMove = false;
        String m;
        for (int i = 1; i<=P; i++){
            m = sc.nextLine();
            parsingInt(m.charAt(1));
            System.out.print(parsingInt(m.charAt(1)));
            moveList[i][0][0] = parsingInt(m.charAt(0));
            moveList[i][0][1] = parsingInt(m.charAt(1));
            moveList[i][1][0] = parsingInt(m.charAt(3));
            moveList[i][1][1] = parsingInt(m.charAt(4));
        }
    }

    public static int parsingInt(char s){
        int result = 0;
        if (s == 'a')
            result = 1;
        else if (s == 'b')
            result = 2;
        else if (s == 'c')
            result = 3;
        else if (s == 'd')
            result = 4;
        else if (s == 'e')
            result = 5;
        else if (s == 'f')
            result = 6;
        else if (s == 'g')
            result = 7;
        else if (s == 'h')
            result = 8;
        else if (s == '1')
            result = 1;
        else if (s == '2')
            result = 2;
        else if (s == '3')
            result = 3;
        else if (s == '4')
            result = 4;
        else if (s == '5')
            result = 5;
        else if (s == '6')
            result = 6;
        else if (s == '7')
            result = 7;
        else if (s == '8')
            result = 8;
        return result;
    }
}
