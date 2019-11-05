// Variant 1029
class Lab1 {
    public static void main(String[] args) {
        //Создание массива e типа Short(16-разрядное целое число, от -32768 до 32767)
        int n = 10;
        short[] e = new short[n];
        //Заполнение массива нечетными числами от 6 до 24 в порядке убывания(числа типа short)
        for (short x = 24; x >= 6; x-=2) {
            e[12 - (x / 2)] = x;
        }
        //Создание массива
        n = 20;
        float[] x = new float[n];
        //Константы min и max
        final float min = -13.0f;
        final float max = 15.0f;
        //Заполнение массива рандомными числами от min до max
        for (int z = 0; z < n; z++) {
            x[z] = min + (float)Math.random() * (max - min);
        }
        //Создание двумерного массива d
        double[][]d=new double[10][20];
        String result;
        //*******************Заполнение массива d********************
        for (int i = 0; i < 10; i++){
            for(int j = 0; j<20; j++) {
                if (e[i] == 18) {
                    d[i][j] = Math.asin(0.25 * ((x[j] + 1) / 28));
                } else if ((e[i] == 10) || (e[i] == 12) || (e[i] == 14) || (e[i] == 20) || (e[i] == 24)) {
                    d[i][j] = Math.pow(Math.pow(Math.tan(x[j]) * (Math.pow((0.5 / x[j]), 3) - 1),
                            Math.asin((x[j] + 1) / 28)), 0.5d / (2 * Math.atan((x[j] + 1) / 28) + 2));
                } else {
                    d[i][j] = Math.pow(Math.E, Math.pow(Math.E, Math.pow((2d/3) / Math.pow(Math.E, x[j]), 3)));
                }
            }
        }
        //********************Формирование вывода********************
        System.out.println("___________________________________________________________________________Lab_1__Variant_1029___________________________________________________________________________");
        System.out.print("|       |");
        //Формирование нумерации Столбцов
        for (int g = 1; g <=20; g++){
            result = String.format("[%d] |", g);
            //Длина строки
            int length = result.length();
            //Удлинение строки
            if (result.length()<8){
                while(length<8){
                    result=" "+result;
                    length = result.length();
                }
            }
            System.out.print(result);
        }
        System.out.println();
        //Основной вывод + нумерация строк
        for (int i = 0; i < 10; i++){
            System.out.print("|");
            result = String.format("[%d]  |", i + 1);
            if (result.length()<8) {
                while (result.length() < 8) {
                    result = " " + result;
                }
            }
            System.out.print(result);
            for(int j = 0; j<20; j++){
                //Замена Infinity на Inf
                if(Double.isNaN(d[i][j])) {
                    result = "NaN  |";
                } else if(Double.isInfinite(d[i][j])) {
                    result = "Inf  |";
                } else {
                    result = String.format("%.2f |", d[i][j]);
                }
                //Удлинение строки до 8
                int length = 8;
                if (result.length()<length) {
                    while (result.length() < length) {
                        result = " " + result;
                    }
                }
                System.out.print(result);
            }
            System.out.println();
        }
        System.out.println("_________________________________________________________________________________________________________________________________________________________________________");
    }
}
