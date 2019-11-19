package lnrcoder.weekly.contest.one.six.three;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName L1262
 * @description 可被三整除的最大和
 * @Author LiaNg
 * @Date 2019-11-19
 */
public class L1262 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 5, 1, 8};
        System.out.println("maxSumDivThree(nums) = " + maxSumDivThree(nums));
    }

    public static int maxSumDivThree(int[] nums) {

        int result = 0;

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int num : nums) {
            if (num % 3 == 1) {
                list1.add(num);
            } else if (num % 3 == 2) {
                list2.add(num);
            }
            result += num;
        }
        list1 = list1.stream().sorted().collect(Collectors.toList());
        list2 = list2.stream().sorted().collect(Collectors.toList());

        int num = result % 3;

        if (num == 0) {
            return result;
        }

        int min = Integer.MAX_VALUE;
        if (num == 1) {
            if (!list1.isEmpty()) {
                min = Math.min(list1.get(0), min);
            }
            if (list2.size() >= 2) {
                min = Math.min(min, list2.get(0) + list2.get(1));
            }
            if (!list1.isEmpty() && list2.size() >= 2) {
                min = Math.min(Math.min(list1.get(0), list2.get(0) + list2.get(1)), min);
            }
        } else {
            if (list1.size() >= 2) {
                min = Math.min(list1.get(0) + list1.get(1), min);
            }
            if (!list2.isEmpty()) {
                min = Math.min(list2.get(0), min);
            }
            if (list1.size() >= 2 && !list2.isEmpty()) {
                min = Math.min(Math.min(list1.get(0) + list1.get(1), list2.get(0)), min);
            }
        }

        if (min == Integer.MAX_VALUE) {
            return result;
        }

        return result - min;
    }

    /**
     * LeetCode 耗时最短前 3
     */
    public int maxSumDivThree1(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 3 == 0) {
            return sum;
        }
        int ans = 0;
        int min = -1;
        for (int value : nums) {
            if (value % 3 == sum % 3) {
                if (min == -1 || min > value) {
                    min = value;
                }
            }
        }
        if (min != -1) {
            ans = sum - min;
        }
        min = -1;
        int min2 = -1;
        for (int num : nums) {
            if (num % 3 != 0 && num % 3 != sum % 3) {
                if (min == -1) {
                    min = num;
                } else if (min2 == -1) {
                    min2 = num;
                } else {
                    int t = Math.max(min, min2);
                    if (t > num) {
                        min = Math.min(min, min2);
                        min2 = num;
                    }
                }
            }
        }
        return Math.max(ans, min != -1 && min2 != -1 ? sum - min - min2 : ans);
    }

    /**
     * LeetCode 耗时最短前 3
     */
    public int maxSumDivThree2(int[] nums) {
        int sum = 0;

        int num11 = Integer.MAX_VALUE;
        int num12 = Integer.MAX_VALUE;
        int num21 = Integer.MAX_VALUE;
        int num22 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num % 3 == 1) {
                if (num <= num11) {
                    num12 = num11;
                    num11 = num;
                } else if (num < num12) {
                    num12 = num;
                }
            } else if (num % 3 == 2) {
                if (num <= num21) {
                    num22 = num21;
                    num21 = num;
                } else if (num < num22) {
                    num22 = num;
                }
            }
            sum += num;
        }
        int res = 0;
        if (sum % 3 == 0) {
            res = sum;
        } else if (sum % 3 == 1) {
            if (num11 == Integer.MAX_VALUE) {
                if (num21 == Integer.MAX_VALUE || num22 == Integer.MAX_VALUE) {
                    res = 0;
                } else {
                    res = sum - num21 - num22;
                }
            } else {
                if (num21 == Integer.MAX_VALUE || num22 == Integer.MAX_VALUE) {
                    res = sum - num11;
                } else {
                    res = sum - Math.min(num11, num21 + num22);
                }
            }
        } else {
            if (num21 == Integer.MAX_VALUE) {
                if (num11 == Integer.MAX_VALUE || num12 == Integer.MAX_VALUE) {
                    res = 0;
                } else {
                    res = sum - num11 - num12;
                }
            } else {
                if (num11 == Integer.MAX_VALUE || num12 == Integer.MAX_VALUE) {
                    res = sum - num21;
                } else {
                    res = sum - Math.min(num21, num11 + num12);
                }
            }

        }

        return res;
    }
}
