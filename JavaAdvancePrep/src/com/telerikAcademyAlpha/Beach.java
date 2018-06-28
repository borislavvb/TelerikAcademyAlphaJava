package com.telerikAcademyAlpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Beach {
    public static void main(String[] args) throws IOException {
        Scanner bf = new Scanner(System.in);
        String[] beach = bf.nextLine().split(" ");
        //String[] monisBeach = bf.nextLine().split(" ");
        StringBuilder sbb = new StringBuilder();

        int startHourLoni = Integer.parseInt(beach[0]);
        int startMinutesLoni = Integer.parseInt(beach[1]);
        int endHoursLoni = Integer.parseInt(beach[2]);
        int endMinLoni = Integer.parseInt(beach[3]);

        int startHourMoni = Integer.parseInt(beach[4]);
        int startMinutesMoni = Integer.parseInt(beach[5]);
        int endHoursMoni = Integer.parseInt(beach[6]);
        int endMinMoni = Integer.parseInt(beach[7]);

        if (endHoursLoni < startHourMoni || endHoursMoni < startHourLoni) {
            sbb.append("No");
        } else {
            if (startHourLoni > startHourMoni) {
                sbb.append(String.format("%s %s ", beach[0], beach[1]));
            } else if (startHourMoni > startHourLoni) {
                sbb.append(String.format("%s %s ", beach[4], beach[5]));
            } else {
                if (startMinutesLoni > startMinutesMoni) {
                    sbb.append(String.format("%s %s ", beach[0], beach[1]));
                } else {
                    sbb.append(String.format("%s %s ",beach[4], beach[5]));
                }
            }

            if (endHoursLoni < endHoursMoni) {
                sbb.append(String.format("%s %s", beach[2], beach[3]));
            } else if (endHoursMoni < endHoursLoni) {
                sbb.append(String.format("%s %s", beach[6], beach[7]));
            } else {
                if (endMinLoni < endMinMoni) {
                    sbb.append(String.format("%s %s", beach[2], beach[3]));
                } else {
                    sbb.append(String.format("%s %s", beach[6], beach[7]));
                }
            }
        }

        System.out.println(sbb);
    }
}
