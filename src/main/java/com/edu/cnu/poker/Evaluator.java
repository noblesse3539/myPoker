package com.edu.cnu.poker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cse on 2017-04-17.
 */
public class Evaluator {
    public String evaluate(List<Card> cardList) {
        Map<Suit, Integer> tempMap = new HashMap<Suit, Integer>();
        Map<Integer, Integer> tempMap2 = new HashMap<Integer, Integer>();

        for (Card card : cardList) {
            if (tempMap.containsKey(card.getSuit())) {
                Integer count = tempMap.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getSuit(), count);
            } else {
                tempMap.put(card.getSuit(), new Integer(1));
            }
        }

        for (Suit key : tempMap.keySet()) {
            if (tempMap.get(key) == 5) {
                return "FLUSH";
            }
        }
        for (Card card : cardList) {
            if (tempMap2.containsKey(card.getRank())) {
                Integer count = tempMap2.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                tempMap2.put(card.getRank(), count);

            }else {
                tempMap2.put(card.getRank(), new Integer(1));
            }
        }
        for (Integer key : tempMap2.keySet()) {
            if (tempMap2.get(key) == 4) {
                return "FOURCARD";
            }else if (tempMap2.get(key) == 2) {
                tempMap2.remove(key);
                for (Integer key2 : tempMap2.keySet()){
                    if(tempMap2.get(key2) == 2){
                        return "TWOPAIR";
                    }else if(tempMap2.get(key2) == 3){
                        return "FULLHOUSE";
                    }else return "ONEPAIR";
                }
            }else if (tempMap2.get(key) == 3) {
                return "TRIPLE";
            }
        }
        return "NOTHING";
    }
}
