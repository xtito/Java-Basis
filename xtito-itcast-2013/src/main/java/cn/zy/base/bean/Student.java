package cn.zy.base.bean;

/**
 * Created by [Zy]
 * 2016/6/30 13:15
 */
public class Student implements Comparable<Student> {

    private String name;
    private int cn, en, ma;
    private int sum;

    public Student() {
        super();
    }

    public Student(String name, int cn, int en, int ma) {
        super();
        this.name = name;
        this.cn = cn;
        this.en = en;
        this.ma = ma;
        this.sum = cn + en + ma;

    }


    @Override
    public int compareTo(Student o) {
        int temp = this.sum - o.sum;

        return temp == 0 ? this.name.compareTo(o.name) : temp;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cn;
        result = prime * result + sum;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Student other = (Student) obj;
        if (cn != other.cn) {
            return false;
        }

        if (sum != other.sum) {
            return false;
        }

        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCn() {
        return cn;
    }

    public void setCn(int cn) {
        this.cn = cn;
    }

    public int getEn() {
        return en;
    }

    public void setEn(int en) {
        this.en = en;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }


    @Override
    public String toString() {
        return "Student [name=" + name + ", sum=" + sum + "]";
    }
}
