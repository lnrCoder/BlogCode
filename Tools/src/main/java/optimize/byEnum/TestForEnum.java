package optimize.byEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Test
 * @Description: 111
 * @Author: LiaNg
 * @Date: 2020/1/17 10:38
 */
public class TestForEnum {
    public static void main(String[] args) {
        List<Map<String, Object>> list1 = new ArrayList<>();
        List<Map<String, Object>> list2 = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", "1");
        map1.put("result", 0);
        list1.add(map1);
        map1 = new HashMap<>();
        map1.put("id", "2");
        map1.put("result", 0);
        list1.add(map1);
        map1 = new HashMap<>();
        map1.put("id", "3");
        map1.put("result", 0);
        list1.add(map1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "AAA");
        map2.put("result", 200);
        list2.add(map2);
        map2 = new HashMap<>();
        map2.put("name", "BBB");
        map2.put("result", 3000);
        list2.add(map2);
        map2 = new HashMap<>();
        map2.put("name", "CCC");
        map2.put("result", 100);
        list2.add(map2);


        for (Map<String, Object> listMap1 : list1) {
            for (Map<String, Object> listMap2 : list2) {

                String idName = User2Ohter.getNameById(String.valueOf(listMap1.get("id")));
                if(idName!=null && idName.equals(String.valueOf(listMap2.get("name")))){
                    listMap1.put("result", listMap2.get("result"));
                }

//                if("1".equals(String.valueOf(listMap1.get("id"))) && "AAA".equals(String.valueOf(listMap2.get("name")))){
//                    listMap1.put("result", listMap2.get("result"));
//                }else
//                if("2".equals(String.valueOf(listMap1.get("id"))) && "BBB".equals(String.valueOf(listMap2.get("name")))){
//                    listMap1.put("result", listMap2.get("result"));
//                }else
//                if("3".equals(String.valueOf(listMap1.get("id"))) && "CCC".equals(String.valueOf(listMap2.get("name")))){
//                    listMap1.put("result", listMap2.get("result"));
//                }
            }
        }

        for (Map<String, Object> stringObjectMap : list1) {
            System.out.println(stringObjectMap.get("id")+"==" + stringObjectMap.get("result"));
        }
    }
}
