package com.mohsen.calculatebmi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {

    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> cricket = new ArrayList<String>();
        cricket.add("سویا");
        cricket.add("آجیل مخلوط");
        cricket.add("آجیل مغز");
        cricket.add("آدامس");
        cricket.add("بادام درختی");
        cricket.add("بادام زمینی");
        cricket.add("بادام هندی");
        cricket.add("برگه زرد آلو");
        cricket.add("برگه هلو");
        cricket.add("پسته");
        cricket.add("ذرت بوداده");
        cricket.add("تخمع آفتاب گردان");
        cricket.add("پفک");
        cricket.add("چیپس");
        cricket.add("سنجد");

        List<String> football = new ArrayList<String>();
        football.add("باقالی پلو");
        football.add("لوبیا پلو");
        football.add("استانبولی پلو");
        football.add("آلبالو پلو");
        football.add("پلو کته با روغن");
        football.add("ته چین گوشت");
        football.add("ته چین مرغ");
        football.add("ته دیگ برنج");
        football.add("ته سیب زمینی");
        football.add("دمپخت گوجه");
        football.add("رشته پلو");
        football.add("عدس پلو");
        football.add("سبزی پلو");
        football.add("کلم پلو");

        List<String> basketball = new ArrayList<String>();
        basketball.add("آبنبات");
        basketball.add("ارده");
        basketball.add("باقلوا");
        basketball.add("بامیه (شیرینی)");
        basketball.add("براونی");
        basketball.add("ساقه طلایی");
        basketball.add("ساقه طلایی شکلاتی");
        basketball.add("پای سیب");
        basketball.add("پشمک");
        basketball.add("پن کیک");
        basketball.add("پولکی");
        basketball.add("پیراشکی شیرین");
        basketball.add("تیرامیسو");
        basketball.add("حلوا ارده");
        basketball.add("خمیر کنجد");
        basketball.add("دونات");
        basketball.add("زولبیا");


        List<String> khoresht = new ArrayList<>();
        khoresht.add("باقلا قاتوق");
        khoresht.add("تاس کباب");
        khoresht.add("ترشی تره");
        khoresht.add("خورش تره");
        khoresht.add("خورش لوبیا سبز");
        khoresht.add("خورش آلو");
        khoresht.add("خورش آلو");

        expandableListDetail.put("تنقلات".concat("  (") + cricket.size() + ")" , cricket);
        expandableListDetail.put("پلو ها", football);
        expandableListDetail.put("شیرینی", basketball);
        expandableListDetail.put("خورشت", basketball);
        expandableListDetail.put("سبزیجات", basketball);
        expandableListDetail.put("میوه ها", basketball);
        expandableListDetail.put("نوشیدنی", basketball);
        expandableListDetail.put("متفرقه", basketball);
        expandableListDetail.put("حبوبات و غلات", basketball);
        expandableListDetail.put("گوشت و لبنیات", basketball);
        expandableListDetail.put("سالاد", basketball);
        expandableListDetail.put("فست فود", basketball);
        expandableListDetail.put("غذای رژیمی", basketball);


        return expandableListDetail;
    }
}
