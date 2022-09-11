package com.kaede.uml.composition;

/**
 * @author kaede
 * @create 2022-09-06 19:48
 */

public class Person {
    private IDCard idCard = new IDCard();    //Head不可以和Person分离
    private Head head;    //IDCard可以和Person分离

    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }
}
