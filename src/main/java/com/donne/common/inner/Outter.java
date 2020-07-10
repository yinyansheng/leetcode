package com.donne.common.inner;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-19
 */
public class Outter {
    private String outerName;

    public class Inner {
        private String innerName;

        public String getInnerName() {
            return outerName + innerName;
        }

        public void setInnerName(String innerName) {
            this.innerName = innerName;
        }
    }

    public static class StaticInner {
        private String innerName;

        public String getInnerName() {
            return innerName;
        }

        public void setInnerName(String innerName) {
            this.innerName = innerName;
        }
    }


    public String getOuterName() {
        StaticInner inner = new StaticInner();
        return inner.getInnerName() + outerName;
    }

    public void setOuterName(String outerName) {
        this.outerName = outerName;
    }
}
