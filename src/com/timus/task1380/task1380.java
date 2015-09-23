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

        Алгоритм работы:
        1. dataEnter() получает данные и формирует board[][] и moveList[][][]
        2. initialize() создаёт фигуры по board[][]
 */
public class task1380 {
    //Входящий поток данных
    public static int board[][] = new int[9][9];
    public static int P = 0;
    public static boolean isWhiteMove;
    public static int moveList[][][] = new int[61][2][2];

    //Объекты
    public static Figure figure[][] = new Figure[9][9]; //Отображение board[][] на множество оъектов
    public static ArrayList<Pawn> pawnsList = new ArrayList<Pawn>(); // Пешки, стоящие на доске
    public static ArrayList<Knight> knightsList = new ArrayList<Knight>(); // Кони, стоящие на доске
    public static ArrayList<Bishop> bishopsList = new ArrayList<Bishop>(); // Слоны, стоящие на доске
    public static ArrayList<Rook> rooksList = new ArrayList<Rook>(); // Ладьи, стоящие на доске

    public static void main(String[] args) throws Exception{
        dataEnter(); //Получает данные
        initialize(); //Создаёт фигуры по board[][]
        int i = 1; //какой-то ход
        move(i);//Делает ход фигурой согласно i ходу в moveList


    }

    public static class Figure{
        private boolean isEmpty = false;
        public Figure(){

        }

        public static Figure getFigure(int x,int y){
            Figure result = new Figure();

            if (Math.abs(board[x][y]) == 1){
                result = pawnsList.get(getIofPawn(x,y));
            }
            else if (Math.abs(board[x][y]) == 2){

            }

            return result;
        }
    }

    public static class Pawn extends Figure{
        protected int x;
        protected int y;
        protected boolean color; //true - белый
        public Pawn(boolean color, int x, int y){
            this.color = color;
            this.x = x;
            this.y = y;
        }
        //Проверка корректности ходов для пешки, король не должен быть под ударом после хода пешки!
        public boolean correct(int x1, int y1, int x2, int y2){
            return false;
        }

        public void move(int i){

            pawnsList.get(getIofPawn(moveList[i][0][0],moveList[i][0][1])).x = moveList[i][1][0];
            pawnsList.get(getIofPawn(moveList[i][0][0],moveList[i][0][1])).y = moveList[i][1][1];
        }
        //Метод поедания другой фигуры пешкой
    }

    public static class Knight extends Figure{
        protected int x;
        protected int y;
        protected boolean color; //true - белый
        public Knight(boolean color, int x, int y){
            this.color = color;
            this.x = x;
            this.y = y;
        }
        //Проверка корректности ходов для коня, король не должен быть под ударом после хода коня!
        public boolean correct(int x1, int y1, int x2, int y2){
            return false;
        }

        //Метод поедания другой фигуры конем
    }

    public static class Bishop extends Figure{
        protected int x;
        protected int y;
        protected boolean color; //true - белый
        public Bishop(boolean color, int x, int y){
            this.color = color;
            this.x = x;
            this.y = y;
        }
        //Проверка корректности ходов для слона, король не должен быть под ударом после хода слона!
        public boolean correct(int x1, int y1, int x2, int y2){
            return false;
        }

        //Метод поедания другой фигуры слоном
    }

    public static class Rook extends Figure{
        protected int x;
        protected int y;
        protected boolean color; //true - белый
        public Rook(boolean color, int x, int y){
            this.color = color;
            this.x = x;
            this.y = y;
        }
        //Проверка корректности ходов для ладьи, король не должен быть под ударом после хода ладьи!
        public boolean correct(int x1, int y1, int x2, int y2){
            return false;
        }

        //Метод поедания другой фигуры ладьей
    }

    public static class Queen extends Figure{
        protected int x;
        protected int y;
        protected boolean color; //true - белый
        public Queen(boolean color, int x, int y){
            this.color = color;
            this.x = x;
            this.y = y;
        }
        //Проверка корректности ходов для королевы, король не должен быть под ударом после хода королевы!
        public boolean correct(int x1, int y1, int x2, int y2){
            return false;
        }

        //Метод поедания другой фигуры ладьей
    }

    public static class King extends Figure{
        protected int x;
        protected int y;
        protected boolean color; //true - белый
        public King(boolean color, int x, int y){
            this.color = color;
            this.x = x;
            this.y = y;
        }
        //Проверка корректности ходов для королевы, король не должен быть под ударом после хода королевы!
        public boolean correct(int x1, int y1, int x2, int y2){
            return false;
        }

        //Метод поедания другой фигуры ладьей
    }

    public static int getIofPawn(int x, int y){ //Заведомо известно, что пешка находится по координатам (x,y) по broad
        int result = 0;
        for(int i = 1; i<=pawnsList.size(); i++){
            if (pawnsList.get(i).x == x & pawnsList.get(i).y == y){
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

    }

    //Создание объектов и матрицы объектов, как отображение board[][]

    public static void initialize(){
        for(int i = 1; i<=8; i++)
            for(int j = 1; j<=8; j++){
                if (Math.abs(board[j][i]) == 1){
                    if (board[j][i]>0) {
                        pawnsList.add(new Pawn(true, j, i));
                        figure[j][i] = new Pawn(true, j, i);
                    }
                    else if (board[j][i]<0){
                        pawnsList.add(new Pawn(false, j, i));
                        figure[j][i] = new Pawn(false, j, i);
                    }
                    else {
                        figure[j][i] = new Figure();
                        figure[j][i].isEmpty = true;
                    }
                }
        }
    }

    //Проверки

    public boolean isFigure(int x, int y){
        boolean result = false;
        if (Math.abs(board[x][y]) != 0)
            result = true;
        return result;
    }

    public boolean isKing(int x, int y){ //Короля нужно проверить на шах, мат и пат. Поэтому нужно знать, что эта фигура точно король.
        boolean result = false;
        if (Math.abs(board[x][y]) == 6)
            result = true;
        return result;
    }

    //Методы ввода и обработки данных

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
