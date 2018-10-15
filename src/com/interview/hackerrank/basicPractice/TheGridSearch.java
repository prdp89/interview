package com.interview.hackerrank.basicPractice;

public class TheGridSearch {

    //https://www.hackerrank.com/challenges/the-grid-search/problem
    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {

     /*   String[] G = {"1234567890",
                "0987654321",
                "1111111111",
                "1111111111",
                "2222222222"};

        String[] P = {"876543",
                "111111",
                "111111"};*/

      /*  String[] G = {"400453592126560",
                "114213133098692",
                "474386082879648",
                "522356951189169",
                "887109450487496",
                "252802633388782",
                "502771484966748",
                "075975207693780",
                "511799789562806",
                "404007454272504",
                "549043809916080",
                "962410809534811",
                "445893523733475",
                "768705303214174",
                "650629270887160"};

        String P[] = {"99",
                "99"};
*/
        String G[] = {"34889246430321978567",
                "58957542800420926643",
                "35502505614464308821",
                "14858224623252492823",
                "72509980920257761017",
                "22842014894387119401",
                "01112950562348692493",
                "16417403478999610594",
                "79426411112116726706",
                "65175742483779283052",
                "89078730337964397201",
                "13765228547239925167",
                "26113704444636815161",
                "25993216162800952044",
                "88796416233981756034",
                "14416627212117283516",
                "15248825304941012863",
                "88460496662793369385",
                "59727291023618867708",
                "19755940017808628326"};

        String P[] = {"1641",
                "7942",
                "6517",
                "8907",
                "1376",
                "2691",
                "2599"};

        int[][] gArr = new int[G.length][G[0].length()];
        int[][] pArr = new int[P.length][P[0].length()];

        //Instead of cArr[j] - '0' : use Character.getNumericValue();
        for (int i = 0; i < G.length; i++) {

            char[] cArr = G[i].toCharArray();
            for (int j = 0; j < cArr.length; j++) {

                gArr[i][j] = Character.getNumericValue(cArr[j]); // cArr[j] - '0';
            }
        }

        for (int i = 0; i < P.length; i++) {

            char[] cArr = P[i].toCharArray();
            for (int j = 0; j < cArr.length; j++) {

                pArr[i][j] = Character.getNumericValue(cArr[j]); // cArr[j] - '0';
            }
        }

        if (pArr.length > gArr.length && pArr[0].length > gArr[0].length)
            System.out.println("NO");

        int pRowLength = pArr.length;
        int pColLength = pArr[0].length;

        for (int i = 0; i < gArr.length; i++) {

            for (int j = 0; j < gArr[i].length; j++) {

                if (gArr[i][j] == pArr[0][0] &&
                        (gArr[i].length - j) >= pColLength &&
                        (gArr.length - i) >= pRowLength &&
                        gArr[i][j + pColLength - 1] == pArr[0][pColLength - 1] &&
                        gArr[i + pRowLength - 1][j] == pArr[pRowLength - 1][0] &&
                        gArr[i + pRowLength - 1][j + pColLength - 1] == pArr[pRowLength - 1][pColLength - 1]) {

                    if (gArr.length == pArr.length && gArr[0].length == pArr[0].length) {
                        System.out.println("True");
                        return;
                    }

                    boolean isNotFound = true;
                    for (int k = i, m = 0; k < pRowLength + i - 1; k++, m++) {
                        for (int l = j, n = 0; l < pColLength + j - 1; l++, n++) {

                            if (gArr[k][l] != pArr[m][n]) {
                                isNotFound = false;
                                break;
                            }
                        }
                        if (!isNotFound)
                            break;
                    }

                    if (isNotFound) {
                        System.out.println("YES");
                        return;
                    }
                }

            }

        }

        System.out.println("NO");
        //System.out.println(Arrays.deepToString(pArr));
    }
}
