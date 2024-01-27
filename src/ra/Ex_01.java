package ra;

import java.util.Scanner;

public class Ex_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[100];
        int crrIndex = 0;

        do {
            System.out.println("***MENU***");
            System.out.println("1. Nhập giá trị n phần tử của mảng");
            System.out.println("2. In các giá trị trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương");
            System.out.println("4. In vị trí các phần tử có giá trị = k (nhập từ bàn phím)");
            System.out.println("5. Sử dụng thuật toán sắp xếp nổi bọt sắp xếp mảng giảm dần");
            System.out.println("6. Tính số lượng các phần tử là số nguyên tố ");
            System.out.println("7. Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng theo thứ tự tăng dần, các phần tử lẻ chia hết cho 3 ở cuối mảng giảm dần," +
                    "các phần tử còn lại ở giữa tăng dần ");
            System.out.println("8. Nhập giá trị m, sắp xếp mảng giảm dần và chèn m vào đúng vị trí giảm dần");
            System.out.println("9. Thoát");
            System.out.println("Lựa chọn của bạn là:  ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Số phần tử nhập vào mảng là:");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.printf("arr[%d]: ", crrIndex);
                        arr[crrIndex] = Integer.parseInt(scanner.nextLine());
                        crrIndex++;
                    }

                    break;
                case 2:
                    for (int i = 0; i < crrIndex; i++) {
                        System.out.printf("%d\t", arr[i]);
                    }
                    System.out.println("\n");
                    break;
                case 3:
                    float sum = 0f;
                    int a = 0;
                    float TBC = 0F;
                    for (int i = 0; i < crrIndex; i++) {
                        if (arr[i] > 0) {
                            sum += arr[i];
                            a += 1;
                        }
                    }
                    TBC =  sum / a;
                    System.out.printf("TBC các phần tử > 0 là: %.2f\n", TBC);
                    break;
                case 4:
                    boolean temp = true;
                    System.out.println("Nhập giá trị k: ");
                    int k = Integer.parseInt(scanner.nextLine());
                    System.out.println("Vị trí các phần tử có giá trị bằng k là:");
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] == k) {
                            System.out.printf("%d\t", i);
                            temp = false;
                        }
                    }
                    if (temp) {
                        System.out.println("không có phần tử nào!!");
                    }
                    System.out.println("\n");
                    break;
                case 5:
                    for (int i = 0; i < crrIndex - 1; i++) {
                        for (int j = i + 1; j < crrIndex; j++) {
                            if (arr[i] < arr[j]) {
                                int b = arr[i];
                                arr[i] = arr[j];
                                arr[j] = b;
                            }
                        }
                    }
                    break;
                case 6:
                    int temp6 = 0;
                    for (int i = 0; i < crrIndex; i++) {
                        if (arr[i] >= 2) {
                            int times = 0;

                            for (int j = 1; j <= arr[i]; j++) {
                                if (arr[i] % j == 0) {
                                    times += 1;
                                }
                            }
                            if (times <= 2) {
                                temp6 += 1;
                            }
                        }
                    }
                    System.out.printf("Số lượng các phần tử nguyên tố là: %d", temp6);
                    System.out.println("\n");
                    break;
                case 7:
                    int[] newArr1 = new int[crrIndex];
                    int[] newArr2 = new int[crrIndex];
                    int[] newArr3 = new int[crrIndex];
                    int[] newArr4 = new int[crrIndex];
                    int x = 0;
                    int y = 0;
                    int z = 0;


                    for (int i = 0; i < crrIndex; i++) {
                        for (int j = i + 1; j < crrIndex; j++) {
                            if (arr[i] > arr[j]) {
                                int temp7 = arr[i];
                                arr[i] = arr[j];
                                arr[j] = temp7;
                            }
                        }
                    }

                    for (int i = 0; i < crrIndex; i++) {
                        if (arr[i] % 2 == 0 && arr[i] % 3 == 0) {
                            newArr1[x] = arr[i];
                            x++;
                        } else if (arr[i] % 2 == 1 && arr[i] % 3 == 0) {
                            newArr2[y] = arr[i];
                            y++;
                        } else {
                            newArr3[z] = arr[i];
                            z++;
                        }
                    }

                    for (int i = 0; i < y; i++) {
                        for (int j = i + 1; j <= y; j++) {
                            if (newArr2[i] < newArr2[j]) {
                                int tempArr2 = newArr2[i];
                                newArr2[i] = newArr2[j];
                                newArr2[j] = tempArr2;
                            }
                        }
                    }

                    int time1 = 0;
                    int time2 = 0;
                    for (int i = 0; i < newArr4.length; i++) {
                        if (i < x) {
                            newArr4[i] = newArr1[i];

                        } else if (i < (x + z)) {
                            newArr4[i] = newArr3[time1];
                            time1++;
                        } else {
                            newArr4[i] = newArr2[time2];
                            time2++;
                        }

                    }

                    for (int i = 0; i < newArr4.length; i++) {
                        System.out.printf("%d\t", newArr4[i]);
                    }
                    System.out.println("\n");

                    break;
                case 8:
                    for (int i = 0; i < crrIndex - 1; i++) {
                        for (int j = i + 1; j < crrIndex; j++) {
                            if (arr[i] < arr[j]) {
                                int temp8 = arr[i];
                                arr[i] = arr[j];
                                arr[j] = temp8;
                            }
                        }
                    }
                    System.out.println("Nhập giá trị m =");
                    int m = Integer.parseInt(scanner.nextLine());
                    int[] newArr = new int[crrIndex + 1];

                    for (int i = 0; i < newArr.length; i++) {
                        newArr[i] = arr[i];
                        if (arr[i] < m) {
                            newArr[i] = m;
                            for (int j = i + 1; j < newArr.length; j++) {
                                newArr[j] = arr[i];
                                i++;
                            }
                            break;
                        }

                    }
                    for (int i = 0; i < newArr.length; i++) {
                        System.out.printf("%d\t", newArr[i]);
                    }
                    System.out.println("\n");
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-8");
            }

        } while (true);


    }
}
