package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String USER_NAME_INPUT = "게임에 참여할 사람의 이름을 입력하세요. 쉼표 기준으로 분리";
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final String COMMA = ",";
    private static final int ZERO = 0;
    private static final int MAX_USER_COUNT = 8;
    private static final int MIN_USER_COUNT = 2;
    private static final String ERROR_NAME_INPUT = "유저의 수는 2~8명이며 동일인물, 공백은 입력할 수 없습니다.";
    private static final String INPUT_BETTING_MONEY = "님의 배팅금액은?";
    private static final String ERROR_FORMAT = "잘못된 형식입니다. 다시 입력해주세요.";
    private static final String ERROR_ZERO = "0은 입력할 수 없습니다.";

    public List<String> inputUserNames() throws IOException {
        System.out.println(USER_NAME_INPUT);
        String[] userNames = BR.readLine().trim().split(COMMA);
        if (checkBlankOk(userNames) && checkNotContainsSameUser(userNames) && checkUserCountOk(userNames))
            return Arrays.asList(userNames);
        System.out.println(ERROR_NAME_INPUT);
        return inputUserNames();
    }

    private boolean checkNotContainsSameUser(String[] userNames) {
        Set<String> set = new HashSet<>(Arrays.asList(userNames));
        return set.size() == userNames.length;
    }

    private boolean checkUserCountOk(String[] userNames) {
        return userNames.length >= MIN_USER_COUNT && userNames.length <= MAX_USER_COUNT;
    }

    public boolean checkBlankOk(String[] userNames) {
        return !Arrays.stream(userNames)
                .map(s -> s.length())
                .collect(Collectors.toList())
                .contains(ZERO);
    }

    public List<Double> inputBettingMoneys(List<String> userNames) throws IOException {
        List<Double> bettingMoneys = new ArrayList<>();
        for(int i=0; i<userNames.size(); i++){
            System.out.println(userNames.get(i)+ INPUT_BETTING_MONEY);
            bettingMoneys.add(checkBettingMoneyAndReturn());
        }
        return bettingMoneys;
    }

    private Double checkBettingMoneyAndReturn() throws IOException {
        try {
            return ifItIsNotZero(Double.parseDouble(BR.readLine().trim()));
        } catch (NumberFormatException e){
            System.out.println(ERROR_FORMAT);
            return checkBettingMoneyAndReturn();
        }
    }

    private Double ifItIsNotZero(double parseDouble) throws IOException {
        if(parseDouble != ZERO)
            return parseDouble;
        System.out.println(ERROR_ZERO);
        return checkBettingMoneyAndReturn();
    }
}
