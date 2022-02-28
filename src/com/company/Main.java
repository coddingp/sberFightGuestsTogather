package com.sberFightGuestsTogather.src.com.company;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class HashMap {
//
//    public static void main(String[] args) {
//
//    }
//
//    public static boolean getResult(int invitedList, List<String> dislikeList) {
//        return true;
//    }

//    invited_list = 4
//    dislike_list = ["1-2", "3-4"]
//    getResult(invited_list, dislike_list) = True // [1, 4, 2, 3]
//}


//// 1: invitedList: Integer
//5
//// 2: dislikeList: String[]
//        ["1-2,3", "3-4,5", "2-3"]

//// 1: invitedList: Integer
//4
//// 2: dislikeList: String[]
//        ["1-2,3", "3-4"]


//package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> dislikeList = new ArrayList<String>();
        dislikeList.add(0, "1-2");
        dislikeList.add(1, "3-4");
        dislikeList.add(2, "2-3");
        int invitedList = 5;
        System.out.println(getResult(invitedList, dislikeList));
    }

    public static boolean getResult(int invitedList, List<String> dislikeList) {
        boolean guestsAreGlad = true;

        ArrayList<String> invitedArrayList = new ArrayList<>();
        ArrayList<String> newInvitedArrayList = new ArrayList<>();

        for (int i = 1; i <= invitedList; i++) {
            invitedArrayList.add(i + "");
        }
        newInvitedArrayList = invitedArrayList;
        System.out.println("invitedArrayList :" + invitedArrayList);

        ArrayList<String> dislikerArrayList = new ArrayList<>();
        int countDislakedGuests = 0;
        int tempCountDislikedGuests = 0;
        for (int i = 0; i < dislikeList.size(); i++) {
            String tempCompare = String.valueOf(dislikeList.get(i).charAt(tempCountDislikedGuests));
            dislikerArrayList.add(tempCompare);
        }
        System.out.println("dislikerArrayList: " + dislikerArrayList);

        ArrayList<String> dislikedDetailsArrayList = new ArrayList<String>();
        String[] dislikedStringArray = new String[dislikeList.size()];
        for (int i = 0; i < dislikeList.size(); i++) {
            for (int b = 0; b < dislikeList.get(i).length(); b++) {
                String tempCompare = String.valueOf(dislikeList.get(i).charAt(b));
                if (tempCompare.equals("-")) {
                    b++;
                    for (int j = b; j < dislikeList.get(i).length(); j++) {
                        tempCompare = String.valueOf(dislikeList.get(i).charAt(j));
                        if (!tempCompare.equals("-") && !tempCompare.equals(",") && !tempCompare.equals(" ")) {
                            dislikedDetailsArrayList.add(tempCompare);
                        }
                        b++;
                    }
                }
            }
            dislikedStringArray[i] = String.valueOf(dislikedDetailsArrayList);
            dislikedDetailsArrayList.clear();
        }
        String tempRestoreDeleted = "0";
        boolean noDisliked = false;
        for (int a = 0; a < dislikerArrayList.size(); a++) {
            for (int b = 0; b < invitedArrayList.size(); b++) {
                if (newInvitedArrayList.get(b).equals(dislikerArrayList.get(a))) {
                    tempRestoreDeleted = invitedArrayList.get(b);
                    newInvitedArrayList.remove(tempRestoreDeleted);
                    for (int c = 0; c < dislikedStringArray.length; c++) {
                        for (int d = 0; d < dislikedStringArray[c].length(); d++) {
                            int f = 1;//tempCountDislikedChars;
                            for (int e = 0; e < invitedArrayList.size(); e++) {
                                if (invitedArrayList.size() == 2) {
                                    invitedArrayList.add(tempRestoreDeleted);
                                } else {
                                    if (e + 1 < invitedArrayList.size()) {
                                        if (!invitedArrayList.get(e).equals(String.valueOf(dislikedStringArray[c].charAt(f)))
                                                && !invitedArrayList.get(e + 1).equals(String.valueOf(dislikedStringArray[c].charAt(f)))
                                                && invitedArrayList.size() < invitedList) {
                                            invitedArrayList.add(e, tempRestoreDeleted);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // проверяем новый массив на довольство клиентов результатами размещения
        for (int a = 0; a < dislikerArrayList.size(); a++) {
            for (int b = 0; b < invitedArrayList.size(); b++) {
                if (invitedArrayList.get(b).equals(dislikerArrayList.get(a))) {
                    if (invitedArrayList.indexOf(dislikerArrayList.get(a)) > 0
                            && a + 1 < invitedArrayList.size()
                            && invitedArrayList.indexOf(dislikerArrayList.get(a)) < invitedArrayList.size() - 1) {
                        for (int c = 0; c < dislikedStringArray[a].length(); c++) {
                            if (invitedArrayList.get(invitedArrayList.indexOf(dislikerArrayList.get(a)) - 1)
                                    .equals(String.valueOf(dislikedStringArray[a].charAt(c))) ||
                                    invitedArrayList.get(invitedArrayList.indexOf(dislikerArrayList.get(a)) + 1)
                                            .equals(String.valueOf(dislikedStringArray[a].charAt(c)))) {
                                guestsAreGlad = false;
                            }
                        }
                    } else {
                        for (int c = 0; c < dislikedStringArray[a].length(); c++) {
                            if ((invitedArrayList.get(1))
                                    .equals(String.valueOf(dislikedStringArray[a].charAt(c)))) {
                                guestsAreGlad = false;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("dislikedStringArray" + Arrays.toString(dislikedStringArray));
        System.out.println("invitedArrayList new " + invitedArrayList);
        return guestsAreGlad;
    }
}
