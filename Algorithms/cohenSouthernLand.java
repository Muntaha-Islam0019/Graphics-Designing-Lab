public class cohenSouthernLand {
    public static void main(String[] args) {
        final double xMin = -77;
        final double xMax = 78;

        final double yMin = -53;
        final double yMax = 73;

        double x1 = 2;
        double y1 = 19;
        double x2 = 341;
        double y2 = -59;
        int[] oc1 = calculateOutcode(x1, y1, xMax, xMin, yMax, yMin);
        int[] oc2 = calculateOutcode(x2, y2, xMax, xMin, yMax, yMin);

        System.out.print("oc1 ");
        for (int i = oc1.length - 1; i >= 0; i--) {
            System.out.print(oc1[i]);
        }
        System.out.println();
        System.out.print("oc2 ");
        for (int i = oc2.length - 1; i >= 0; i--) {
            System.out.print(oc2[i]);
        }
        System.out.println();

        while (true) {
            if (!(isAndZero(oc1, oc2))) {
                System.out.println("---------------");

                System.out.print("oc1 ");
                for (int i = oc1.length - 1; i >= 0; i--) {
                    System.out.print(oc1[i]);
                }
                System.out.println();
                System.out.print("oc2 ");
                for (int i = oc2.length - 1; i >= 0; i--) {
                    System.out.print(oc2[i]);
                }
                System.out.println();

                System.out.println("(oc1 && oc2)!=0000");
                System.out.println("completely outside");
                break;
            }

            else if (isZero(oc1) && isZero(oc2)) {
                System.out.println("---------------");

                System.out.print("oc1 ");
                for (int i = oc1.length - 1; i >= 0; i--) {
                    System.out.print(oc1[i]);
                }
                System.out.println();
                System.out.print("oc2 ");
                for (int i = oc2.length - 1; i >= 0; i--) {
                    System.out.print(oc2[i]);
                }
                System.out.println();

                System.out.println("oc1==oc2==0000");
                System.out.println("completely inside");
                break;
            } else {
                if (!(isZero(oc1))) {

                    System.out.println("-------------------");
                    System.out.println("oc1 && oc2 ==0000 ");
                    System.out.print("oc1=");
                    for (int i = oc1.length - 1; i >= 0; i--) {
                        System.out.print(oc1[i]);
                    }
                    System.out.println();

                    double m = (y2 - y1) / (x2 - x1);
                    double[] ar = intersection(oc1, x1, y1, m, xMax, xMin, yMax, yMin);
                    x1 = ar[0];
                    y1 = ar[1];
                    oc1 = calculateOutcode(x1, y1, xMax, xMin, yMax, yMin);

                    System.out.println("x1,y1 has been clipped to " + x1 + "," + y1);
                    System.out.print("oc1 now  ");
                    for (int i = oc1.length - 1; i >= 0; i--) {
                        System.out.print(oc1[i]);
                    }
                    System.out.println();

                } else {

                    System.out.println("-------------------");
                    System.out.println("oc1 && oc2 ==0000 ");
                    System.out.print("oc2=");
                    for (int i = oc2.length - 1; i >= 0; i--) {
                        System.out.print(oc2[i]);
                    }
                    System.out.println();

                    double m = (y2 - y1) / (x2 - x1);
                    double[] ar = intersection(oc2, x2, y2, m, xMax, xMin, yMax, yMin);
                    x2 = ar[0];
                    y2 = ar[1];
                    oc2 = calculateOutcode(x2, y2, xMax, xMin, yMax, yMin);

                    System.out.println("x2,y2 has been clipped to " + x2 + "," + y2);
                    System.out.print("oc2 now  ");
                    for (int i = oc2.length - 1; i >= 0; i--) {
                        System.out.print(oc2[i]);
                    }
                    System.out.println();

                }

            }
        }
    }

    public static boolean isZero(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0)
                return false;
        }
        return true;
    }

    public static boolean isAndZero(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if ((a[i] * b[i]) != 0)
                return false;
        }
        return true;
    }

    public static int[] calculateOutcode(double x, double y, double xMax, double xMin, double yMax, double yMin) {
        int[] array = new int[4];

        if (x < xMin)
            array[0] = 1;
        else
            array[0] = 0;
        if (x > xMax)
            array[1] = 1;
        else
            array[1] = 0;

        if (y < yMin)
            array[2] = 1;
        else
            array[2] = 0;

        if (y > yMax)
            array[3] = 1;
        else
            array[3] = 0;

        return array;
    }

    public static double[] intersection(int[] a, double x, double y, double m, double xMax, double xMin, double yMax,
            double yMin) {
        double[] b = new double[2];

        if (a[3] == 1) {

            System.out.println("applying top intersection");

            b[1] = yMax;
            b[0] = x + (1 / m) * (yMax - y);
            return b;
        } else if (a[2] == 1) {

            System.out.println("applying bottom intersection");

            b[1] = yMin;
            b[0] = x + (1 / m) * (yMin - y);
            return b;
        }

        else if (a[1] == 1) {

            System.out.println("applying right intersection");

            b[0] = xMax;
            b[1] = y + m * (xMax - x);
            return b;
        }

        else {

            System.out.println("applying left intersection");

            b[0] = xMin;
            b[1] = y + m * (xMin - x);
            return b;
        }

    }
}
