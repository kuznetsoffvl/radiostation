package main;

import radiostation.logic.presenters.*;
import radiostation.logic.broadcasts.*;
import radiostation.patterns.*;


public class Main {
    public static void main(String[] args) {
        new Main().runSession();
    }

    private void runSession(){

        // 1 variant - ads and songs (without interviews) filled by ABSTRACT FABRIC pattern

        BroadcastList firstList = new BroadcastList();
        StuffPresenter stuffPresenter = new StuffPresenter("John Smith", 15, firstList);

        BroadcastSession firstSession = new BroadcastSession(
                stuffPresenter,
                60*60*1,
                firstList);

        BroadcastFactory firstFactory = new MixWithAdsFactory();
        Content paidContent = firstFactory.createPaidContent(firstSession.getPaidDurationSec());
        Content freeContent = firstFactory.createFreeContent(firstSession.getTotalDurationSec() - paidContent.getContent().getTotalDurationSec());

        firstSession.addAllFromBroadcastList(paidContent.getContent());
        firstSession.addAllFromBroadcastList(freeContent.getContent());

        System.out.println(firstSession);


        // 2 variant - ads, interviews and songs filled by ABSTRACT FABRIC pattern with static method

        BroadcastList secondList = new BroadcastList();
        BroadcastSession secondSession = new BroadcastSession(
                stuffPresenter,
                60*60*2 + 60*3 + 8,
                secondList);

        Content mixContent = MixMasterFactory.createContent(secondSession);
        secondSession.addAllFromBroadcastList(mixContent.getContent());

        System.out.println(secondSession);
        //System.out.println(stuffPresenter);


        // 3 variant - ads, interviews and songs filled by BUILDER pattern

        BroadcastList thirdList = new BroadcastList();
        GuestPresenter guestPresenter = new GuestPresenter("Helen Jackson", new CurriculumVitae("There should be text of Bill Morrison CV "));
        BroadcastSession thirdSession = new BroadcastSession(
                guestPresenter,
                60*60*3 + 60*15 + 13,
                thirdList);

        MixMasterFactory.fillContentWithBuilder(thirdSession, 60*15, 60*5, 60*60 + 60*10);
        System.out.println(thirdSession);

    }
}


