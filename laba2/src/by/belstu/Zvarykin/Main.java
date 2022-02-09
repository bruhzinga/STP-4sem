package by.belstu.Zvarykin;

import java.util.Objects;

import static java.lang.Math.*;

class Main {

    /**
     * @param args
     * @return "nothing"
     * @throws "exceptions"
     */
    public static void main(String[] args) {
        System.out.println("B)---------------------------------------------------------");

        char cha;

        int x;
        byte byt;
        long lon;
        boolean bool;

        String string = "Bruh";
        double a = 4.12;
        cha = 'a';
        x = 2;
        byt = 22;
        lon = 2147483648l;
        bool = true;
        System.out.println("String + int = " + string + x);
        System.out.println("String + char = " + string + cha);
        System.out.println("String + double = " + string + a);
        byte byt2 = (byte) (byt + x);
        System.out.println("byte+int = " + byt2);
        int xx = (int) (a + lon);
        System.out.println("Double+int = " + xx);
        long lon2 = x + 2147483647l;
        System.out.println("int + 2147483647 = " + lon2);
           /* int sint = 0;
        System.out.println(sint);*/
        boolean bool2 = false, bool3;
        bool3 = bool2 && bool;
        System.out.println("True and false = " + bool3);
        bool3 = bool2 ^ bool;
        System.out.println("True or false = " + bool3);//исключающее или
        //bool3=bool2+bool;нельзя
        long lon3 = 9223372036854775807l;//для такого числа подходит Long от -9223372036854775808 до 9223372036854775807
        //double byte2=0x7fff_ffff_fff;
        System.out.println("3.45 % 2.4 = " + 3.45 % 2.4);
        System.out.println("1.0 / 0.0 = " + 1.0 / 0.0);
        System.out.println("0.0 / 0.0 = " + 0.0 / 0.0);
        System.out.println("log(-345) = " + log(-345));
        System.out.println("Float.intBitsToFloat(0x7F800000) = " + Float.intBitsToFloat(0x7F800000));
        System.out.println("Float.intBitsToFloat(0xFF800000) = " + Float.intBitsToFloat(0xFF800000));
        //в 2, в 10,в 16
        System.out.println("D)---------------------------------------------------------");
        var pi = PI;
        var e = E;
        System.out.printf("%s pi , %s E \n", pi, e);
        System.out.println(String.valueOf(min(pi, e)));
        System.out.println(random());
        System.out.println("E)---------------------------------------------------------");
        var C = new Character('B');
        var I = Integer.valueOf(12);
        var B = new Byte((byte) 1);
        var S = new Short((short) 12);
        var L = new Long(Long.MAX_VALUE);
        var D = Double.valueOf(Double.MAX_VALUE);
        System.out.printf("doub + int = %s%n", D + I);
        int i = I;
        Integer i2 = i;
        var str = Integer.toString(I);
        System.out.println(str);
        System.out.println("F)---------------------------------------------------------");
        var s34 = "2345";
        int s1 = Integer.parseInt(s34);
        int s2 = Integer.valueOf(s34);
        int s3 = new Integer(s34);
        var sb = s34.getBytes();
        var bs = sb.toString();
        //
        var B1 = Boolean.parseBoolean(s34);
        var B2 = Boolean.getBoolean(s34);
        //
        var str1 = "BRUH";
        String str2 = "BRUH";
        var b1 = str1 == str2;
        b1 = str1.equals(str2);
        var b2 = str1.compareTo(str2);
        //
        var strin = "Test sample";
        var a1 = strin.split(" ");
        var a2 = strin.contains("Te");
        var a3 = strin.hashCode();
        var a4 = strin.indexOf("T");
        strin.replace("T", "t");
        var a5 = strin.length();
        System.out.println("G)---------------------------------------------------------");
        char[][] c1;
        char[] c2[];
        char c3[][];
        char[] c4 = new char[0];
        c1 = new char[3][];
        c1[0] = new char[1];
        c1[1] = new char[2];
        c1[2] = new char[3];
        var d = c1.length;
        var d1 = c1[0].length;
        var d2 = c1[1].length;
        var d3 = c1[2].length;
        c1[0][0] = 'a';
        c1[1][0] = 'd';
        c1[1][1] = 'a';
        c1[2][0] = 'n';
        c1[2][1] = 'e';
        c1[2][2] = 't';
        for (char[] xz : c1) {
            System.out.println(xz);
        }


        class WrapperString {

            /**
             * Protected String
             */
            protected String str;

            public WrapperString(String str) {
                this.str = str;
            }

            public String getStr() {
                return str;
            }

            public void setStr(String str) {
                this.str = str;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                WrapperString that = (WrapperString) o;
                return Objects.equals(getStr(), that.getStr());
            }

            @Override
            public int hashCode() {
                return Objects.hash(getStr());
            }

            @Override
            public String toString() {
                return "WrapperString{" +
                        "str='" + str + '\'' +
                        '}';
            }

            /**
             * @param oldChar Char to be replaced
             * @param newChar replacing char
             */
            public void replace(char oldChar, char newChar) {
                str = str.replace(oldChar, newChar);
            }
            /*
              @author Dzmitry Zvor
             * @version  1.0.0

             */
        }
        var Wrapper = new WrapperString("BRUH");
        Wrapper.replace('B', 'R');
        System.out.println(Wrapper);

        var anon = new WrapperString("bruh") {


            @Override
            public void replace(char oldChar, char newChar) {
                str = str.replace(oldChar, 'C');
            }

            public void delete(String delete) {
                str = str.replace(delete, "");
            }
        };
        anon.replace('b', 'd');
        anon.delete("uh");


    }
    /*
      @author Dzmitry Zvor
     * @version 1.0.0.
     */
}
