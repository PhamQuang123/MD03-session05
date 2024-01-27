package ra;

import java.util.Scanner;

public class Ex_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào n của mảng:");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào m của mảng:");
        int m = Integer.parseInt(scanner.nextLine());
        int[][] arr = new int[n][m];
        do {
            System.out.println("***MENU***");
            System.out.println("1. Nhập giá trị phần tử của mảng");
            System.out.println("2. In các giá trị trong mảng theo ma trận");
            System.out.println("3. Tính số lượng các phần tử chia hết cho 2 & 3");
            System.out.println("4. In các phần tử và tổng các phần tử nằm trên đường biên, đường chéo chính và\n" +
                    "đường chéo phụ");
            System.out.println("5. Sử dụng thuật toán sắp xếp lựa chọn sắp xếp các phần tử tăng dần theo cột của\n" +
                    "mảng");
            System.out.println("6. In ra các phần tử là số nguyên tố trong mảng ");
            System.out.println("7. Sử dụng thuật toán chèn (Insertion sort) sắp xếp các phần tử trên đường chéo chính\n" +
                    "của mảng giảm dần ");
            System.out.println("8. Nhập giá trị một mảng 1 chiều gồm m phần tử và chỉ số dòng muốn chèn vào mảng,\n" +
                    "thực hiện chèn vào mảng 2 chiều");
            System.out.println("9. Thoát");
            System.out.println("Lựa chọn của bạn là:  ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.printf("arr[%d][%d] = ", i, j);
                            arr[i][j] = Integer.parseInt(scanner.nextLine());
                        }
                    }
                    break;

                case 2:
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.printf("%d\t", arr[i][j]);

                        }
                        System.out.println("\n");
                    }
                    break;

                case 3:
                    int result = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {

                            if (arr[i][j] % 3 == 0 && arr[i][j] % 2 == 0) {
                                result += 1;
                            }
                        }
                    }
                    System.out.printf("số lượng các phần tử chia hết cho 2 và 3 trong mảng là: %d", result);
                    System.out.println("\n");
                    break;

                case 4:
                    int temp1 = m, temp2 = m;
                    int sum1 = 0;
                    int sum2 = 0;
                    int sum3 = 0;
                    System.out.println("các phần tử trên đường biên là:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                                System.out.printf("%d\t", arr[i][j]);
                            }
                        }
                    }
                    System.out.println("\n");

                    System.out.println("các phần tử trên đường chéo chính là:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (i == j) {
                                System.out.printf("%d\t", arr[i][j]);
                            }
                        }
                    }
                    System.out.println("\n");

                    System.out.println("các phần tử trên đường chéo phụ là:");
                    for (int i = 0; i < n; i++) {
                        temp1 -= 1;
                        for (int j = 0; j < m; j++) {
                            if (j == temp1) {
                                System.out.printf("%d\t", arr[i][j]);
                            }
                        }
                    }

                    for (int i = 0; i < n; i++) {
                        temp2 -= 1;
                        for (int j = 0; j < m; j++) {
                            if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                                sum1 += arr[i][j];
                            }
                            if (i == j) {
                                sum2 += arr[i][j];
                            }
                            if (j == temp2) {
                                sum3 += arr[i][j];
                            }
                        }
                    }
                    System.out.println("\n");
                    System.out.printf("Tổng các phần tử trên đường biên là: %d", sum1);
                    System.out.println("\n");
                    System.out.printf("Tổng các phần tử trên đuờng chéo chính là: %d", sum2);
                    System.out.println("\n");
                    System.out.printf("Tổng các phần tử trên đường chéo phụ là: %d", sum3);
                    System.out.println("\n");
                    break;

                case 5:
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            for (int k = i + 1; k < n; k++) {
                                if (arr[i][j] > arr[k][j]) {
                                    int temp = arr[i][j];
                                    arr[i][j] = arr[k][j];
                                    arr[k][j] = temp;

                                }
                            }
                        }

                    }
                    break;

                case 6:
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (arr[i][j] >= 2) {
                                int times = 0;
                                for (int k = 1; k <= arr[i][j]; k++) {
                                    if (arr[i][j] % k == 0) {
                                        times += 1;
                                    }
                                }
                                if (times <= 2) {
                                    System.out.printf("%d\t", arr[i][j]);
                                }
                            }
                        }
                    }
                    System.out.println("\n");
                    break;

                case 7:
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (i == j) {
                                for (int k = i + 1; k < m; k++) {
                                    if (arr[i][j] < arr[k][k]) {
                                        int temp = arr[i][j];
                                        arr[i][j] = arr[k][k];
                                        arr[k][k] = temp;
                                    }

                                }
                            }

                        }

                    }
                    break;

                case 8:
                    int[] arr8 = new int[m];
                    int[][] newArr = new int[n + 1][m];
                    System.out.printf("Nhập các giá trị mảng 1 chiều gồm %d phần tử:",m);
                    for (int i = 0; i < m; i++) {
                        System.out.printf("arr8[%d]=", i);
                        arr8[i] = Integer.parseInt(scanner.nextLine());
                    }
                    System.out.println(" indexValue muốn chèn vào mảng = ");
                    int indexValue = Integer.parseInt(scanner.nextLine());
                    if (indexValue >= 0 && indexValue < n) {
                        for (int i = 0; i < n + 1; i++) {
                            for (int j = 0; j < m; j++) {
                                if (i < indexValue) {
                                    newArr[i][j] = arr[i][j];
                                } else if (i == indexValue) {
                                    for (int k = 0; k < arr8.length; k++) {
                                        newArr[indexValue][k] = arr8[k];
                                    }
                                } else {
                                    newArr[i][j] = arr[i - 1][j];
                                }

                            }
                        }
                        for (int i = 0; i < n + 1; i++) {
                            for (int j = 0; j < m; j++) {
                                System.out.printf("%d\t", newArr[i][j]);
                            }
                            System.out.println("\n");
                        }
                    } else {
                        System.out.printf("Nhập chỉ số muốn chèn từ 1 - %d", n);
                    }
                    break;

                case 9:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn 1-9");
            }
        } while (true);
    }
}
