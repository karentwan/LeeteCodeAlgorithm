package cn.karent.leetcode_v6;

/*******************************************
 * @author wan
 * @date: 2022-03-18 07:33
 * @description: 简易银行系统
 *******************************************/
public class Bank {

    private long[] balance;


    public Bank(long[] balance) {
        this.balance = balance;
    }

    private boolean valid(int account) {
        return account - 1 >= 0 && account - 1 < balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if ( valid(account1) && valid(account2) && balance[account1 - 1] >= money) {
            balance[account2-1] += money;
            balance[account1-1] -= money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (valid(account)) {
            balance[account-1] += money;
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if (valid(account) && balance[account-1] >= money) {
            balance[account-1] -= money;
            return true;
        }
        return false;
    }

}
