package org.example;
import org.example.entity.entity.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] counters = new int[300]; //количество точек банкоматов, офисов
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean isFace = true;
        System.out.println("Выберете, пожалуйста, являетесь ли вы Юридическим лицом или Физическим лицом");
        System.out.println("Юр лицо");
        //код если ты юр лицо
        System.out.println("Физ лицо");
        //по дефолту
        int counter = 0;
        Date date = new Date();
        Calendar c = new GregorianCalendar();
        SimpleDateFormat formater = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat formater2 = new SimpleDateFormat("HH");
        double myX = 0.0;
        double myY = 0.0;
        String myAddress = scanner.nextLine();
        //далее оно должно определять место на карте и найти его X и Y,
        // потом после ввода адреса банкомата взять X и Y банкомата и определить расстояние

        Atm atm = new Atm();
        Atms atms = new Atms();
        Blind blind = new Blind();
        NfcForBankCards nfcForBankCards = new NfcForBankCards();
        Office office = new Office();
        OpenHour openHour = new OpenHour();
        OpenHoursIndividual openHoursIndividual = new OpenHoursIndividual();
        QrRead qrRead = new QrRead();
        Services services = new Services();
        SupportsChargeRub supportsChargeRub = new SupportsChargeRub();
        SupportsEur supportsEur = new SupportsEur();
        SupportsRub supportsRub = new SupportsRub();
        SupportsUsd supportsUsd = new SupportsUsd();
        Wheelchair wheelchair = new Wheelchair();

        atm.address = "";
        atm.latitude = 0.0;
        atm.longitude = 0.0;
        atm.allDay = true;
        atm.getAdditionalProperties();

        atms.getAdditionalProperties();

        blind.serviceCapability = "";
        blind.serviceActivity = "";
        blind.getAdditionalProperties();

        nfcForBankCards.serviceActivity = "";
        nfcForBankCards.serviceCapability = "";
        nfcForBankCards.getAdditionalProperties();

        office.salePointName = "";
        office.address = "";
        office.status = "";
        office.rko = "";
        office.officeType = "";
        office.salePointFormat = "";
        office.suoAvailability = "";
        office.hasRamp = "";
        office.latitude = 0.0;
        office.longitude = 0.0;
        office.metroStation = "";
        office.distance = 0;
        office.kep = true;
        office.myBranch = true;
        office.getAdditionalProperties();

        openHour.hours = "";
        openHour.days = "";
        openHour.getAdditionalProperties();

        openHoursIndividual.days = "";
        openHoursIndividual.hours = "";
        openHoursIndividual.getAdditionalProperties();

        qrRead.serviceActivity = "";
        qrRead.serviceCapability = "";
        qrRead.getAdditionalProperties();

        services.isBlind = false;
        services.isNfcForBankCards = false;
        services.isQrRead = false;
        services.isSupportsChargeRub = false;
        services.isSupportsEur = false;
        services.isSupportsRub = false;
        services.isSupportsUsd = false;
        services.isWheelchair = false;

        supportsChargeRub.serviceActivity = "";
        supportsChargeRub.serviceCapability = "";
        supportsChargeRub.getAdditionalProperties();

        supportsEur.serviceActivity = "";
        supportsEur.serviceCapability = "";
        supportsEur.getAdditionalProperties();

        supportsRub.serviceActivity = "";
        supportsRub.serviceCapability = "";
        supportsRub.getAdditionalProperties();

        supportsUsd.serviceActivity = "";
        supportsUsd.serviceCapability = "";
        supportsUsd.getAdditionalProperties();

        wheelchair.serviceActivity = "";
        wheelchair.serviceCapability = "";
        wheelchair.getAdditionalProperties();

        if (atm.allDay) {
            counter += 1;
        }

        //Начало работы офиса
        int d1 = Integer.parseInt(openHour.hours);
        //Окончание работы офиса
        int d2 = Integer.parseInt(openHour.hours);
        for (int i = d1; i < d2; i++) {
            if (c.get(Calendar.HOUR_OF_DAY) < d1 || c.get(Calendar.HOUR_OF_DAY) > d2 || openHour.hours == null){
                counter -= 1000;
            }else {
                counter += 1;
            }
        }

        switch (openHour.days) {
            case ("пн"): if (c.get(Calendar.DAY_OF_WEEK) == 1){
                counter += 1;
            }
            case ("вт"): if (c.get(Calendar.DAY_OF_WEEK) == 2){
                counter += 1;
            }
            case ("ср"): if (c.get(Calendar.DAY_OF_WEEK) == 3){
                counter += 1;
            }
            case ("чт"): if (c.get(Calendar.DAY_OF_WEEK) == 4){
                counter += 1;
            }
            case ("пт"): if (c.get(Calendar.DAY_OF_WEEK) == 5){
                counter += 1;
            }
            case ("сб"): if (c.get(Calendar.DAY_OF_WEEK) == 6){
                counter -= 1000;
            }
            case ("вс"): if (c.get(Calendar.DAY_OF_WEEK) == 7){
                counter -= 1000;
            }
            case ("Не обслуживает ЮЛ"): if (isFace = false){
                counter -= 1000;
            }
        }

        //Начало работы офиса
        int d3 = Integer.parseInt(openHoursIndividual.hours);
        //Окончание работы офиса
        int d4 = Integer.parseInt(openHoursIndividual.hours);
        for (int i = d3; i < d4; i++) {
            if (c.get(Calendar.HOUR_OF_DAY) < d1 || c.get(Calendar.HOUR_OF_DAY) > d2){
                counter -= 1000;
            }else {
                counter += 1;
            }
        }

        switch (openHoursIndividual.days) {
            case ("пн"): if (c.get(Calendar.DAY_OF_WEEK) == 1){
                counter += 1;
            }
            case ("вт"): if (c.get(Calendar.DAY_OF_WEEK) == 2){
                counter += 1;
            }
            case ("ср"): if (c.get(Calendar.DAY_OF_WEEK) == 3){
                counter += 1;
            }
            case ("чт"): if (c.get(Calendar.DAY_OF_WEEK) == 4){
                counter += 1;
            }
            case ("пт"): if (c.get(Calendar.DAY_OF_WEEK) == 5){
                counter += 1;
            }
            case ("сб"): if (c.get(Calendar.DAY_OF_WEEK) == 6){
                counter += 1;
            }
            case ("вс"): if (c.get(Calendar.DAY_OF_WEEK) == 7){
                counter -= 1000;
            }
        }

        //потом в андроид приложении надо будет добавить вкл/выкл для сервисов

        if (services.isWheelchair){
            switch (services.wheelchair.serviceCapability){
                case ("SUPPORTED"): counter += 1;
                case ("UNKNOWN"): counter += 0;
                case ("UNSUPPORTED"): counter -= 1;
            }

            switch (services.wheelchair.serviceActivity){
                case ("AVAILABLE"): counter += 1;
                case ("UNKNOWN"): counter += 0;
                case ("UNAVAILABLE"): counter -= 1;
            }
        }

        if (services.isBlind){
            switch (services.blind.serviceCapability){
                case ("SUPPORTED"): counter += 1;
                case ("UNKNOWN"): counter += 0;
                case ("UNSUPPORTED"): counter -= 1;
            }

            switch (services.blind.serviceActivity){
                case ("AVAILABLE"): counter += 1;
                case ("UNKNOWN"): counter += 0;
                case ("UNAVAILABLE"): counter -= 1;
            }
        }

        if (services.isNfcForBankCards){
            switch (services.nfcForBankCards.serviceCapability){
                case ("SUPPORTED"): counter += 1;
                case ("UNKNOWN"): counter += 0;
                case ("UNSUPPORTED"): counter -= 1;
            }

            switch (services.nfcForBankCards.serviceActivity){
                case ("AVAILABLE"): counter += 1;
                case ("UNKNOWN"): counter += 0;
                case ("UNAVAILABLE"): counter -= 1;
            }
        }

        if (services.isQrRead){
            switch (services.qrRead.serviceCapability){
                case ("SUPPORTED"): counter += 1;
                case ("UNKNOWN"): counter += 0;
                case ("UNSUPPORTED"): counter -= 1;
            }

            switch (services.qrRead.serviceActivity){
                case ("AVAILABLE"): counter += 1;
                case ("UNKNOWN"): counter += 0;
                case ("UNAVAILABLE"): counter -= 1;
            }
        }

        if (services.isSupportsChargeRub){
            switch (services.supportsChargeRub.serviceCapability){
                case ("SUPPORTED"): counter += 1;
                case ("UNKNOWN"): counter += 0;
                case ("UNSUPPORTED"): counter -= 1;
            }

            switch (services.supportsChargeRub.serviceActivity){
                case ("AVAILABLE"): counter += 1;
                case ("UNKNOWN"): counter += 0;
                case ("UNAVAILABLE"): counter -= 1;
            }
        }

        if (services.isSupportsEur){
            switch (services.supportsEur.serviceCapability){
                case ("SUPPORTED"): counter += 1;
                case ("UNKNOWN"): counter += 0;
                case ("UNSUPPORTED"): counter -= 1;
            }

            switch (services.supportsEur.serviceActivity){
                case ("AVAILABLE"): counter += 1;
                case ("UNKNOWN"): counter += 0;
                case ("UNAVAILABLE"): counter -= 1;
            }
        }

        if (services.isSupportsRub) {
            switch (services.supportsRub.serviceCapability){
                case ("SUPPORTED"): counter += 1;
                case ("UNKNOWN"): counter += 0;
                case ("UNSUPPORTED"): counter -= 1;
            }

            switch (services.supportsRub.serviceActivity){
                case ("AVAILABLE"): counter += 1;
                case ("UNKNOWN"): counter += 0;
                case ("UNAVAILABLE"): counter -= 1;
            }
        }

        if (services.isSupportsUsd){
            switch (services.supportsUsd.serviceCapability){
                case ("SUPPORTED"): counter += 1;
                case ("UNKNOWN"): counter += 0;
                case ("UNSUPPORTED"): counter -= 1;
            }

            switch (services.supportsUsd.serviceActivity){
                case ("AVAILABLE"): counter += 1;
                case ("UNKNOWN"): counter += 0;
                case ("UNAVAILABLE"): counter -= 1;
            }
        }


        switch (office.suoAvailability){
            case ("Y"): counter += 1;
            case ("N"): counter += 0;
        }

        switch (office.hasRamp){
            case ("Y"): counter += 1;
            case ("N"): counter += 0;
        }

        if (office.myBranch){
            counter += 1;
        }

        if (office.kep){
            counter += 1;
        }

        if (office.metroStation != null){
            counter += 3;
        }

        if (office.rko.equals("нет РКО")){
            counter -= 1;
        } else {
            counter += 1;
        }

        String[] ofName = new String[168];
        String g = new String(office.salePointName);
        //количество офисов втб
        for (int i = 0; i < 168; i++) {
            ofName[i] = g;
        }

        //сопоставляем номера банкоматов и их заполненность
        int[] fullness = new int[168];
        for (int i = 0; i < 168; i++) {
            fullness[i] = (int) Math.random() * 65;
        }

        //потом мы смотрим местоположение банкоматов и смотрим на их заполненность и близость к нам

        double[] distanses = new double[n];
        //300 - условное количество точек банкоматов втб
        //когда приложение закрывается - массив должен очищаться
        for (int i = 0; i < n; i++) {
            distanses[i] = Math.sqrt(Math.pow(atm.latitude-myX, 2) + Math.pow(atm.longitude-myY, 2));
        }

        Arrays.sort(distanses);

        if (distanses.length == n){
            for (int i = 0; i < 10; i++) {
                switch ((int) distanses[i]){
                    case (0): counter += 10;
                    case (1): counter += 9;
                    case (2): counter += 8;
                    case (3): counter += 7;
                    case (4): counter += 6;
                    case (5): counter += 5;
                    case (6): counter += 4;
                    case (7): counter += 3;
                    case (8): counter += 2;
                    case (9): counter += 1;
                }
            }
        }

        for (int i = 0; i < 300; i++) {
            counters[i] += counter;
        }

        Arrays.sort(counters);

    }
    }