package com.algos.practice;

import com.sun.deploy.util.ArrayUtil;
import javafx.util.Pair;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cdeshpande on 8/10/17.
 *
 * >> next_server_number([5, 3, 1])
 2
 >> next_server_number([5, 4, 1, 2])
 3
 >> next_server_number([3, 2, 1])
 4
 >> next_server_number([2, 3])
 1
 >> next_server_number([])
 1

 apihost: []
 sitehost: []

 [a2,s1]

 */
public class StripeInterview {

    private static final int LOWEST = 1;
    private Map<String, List<Integer>> hostToAllocatedSrvrMap = new HashMap<>();

    protected int nextServerNumber(List<Integer> allocatedServers) {
        int [] srv = new int[allocatedServers.size()];
        int idx = 0;
        for(Integer i : allocatedServers) {
            srv[idx] = i;
            idx++;
        }
        return nextServerNumber(srv);
    }

    public int nextServerNumber(int [] allocatedServers) {
        boolean [] test = new boolean[allocatedServers.length + 1];
        for(int allocatedServer : allocatedServers) {
            int index = allocatedServer - 1;
            if(index < test.length) {
                test[index] = true;
            }

        }

        int result = -1;
        for(int i = 0; i < test.length; i++) {
            if(!test[i]) {
                // found the min nonset bit
                result = i + 1;
                break;
            }
        }
        return result;
    }

    public String allocate(String hostType) {
        int number;
        // apihost: [1,2,3], [1,3,2]
        if(hostToAllocatedSrvrMap.containsKey(hostType)) {
            List<Integer> allocated = hostToAllocatedSrvrMap.get(hostType);
            number = nextServerNumber(allocated);    
        } else {
            number = LOWEST;
            hostToAllocatedSrvrMap.put(hostType, new ArrayList<Integer>());
        }

        hostToAllocatedSrvrMap.get(hostType).add(number);
        return (hostType + number);
    }

    public void deallocate(String allocated) {
        Pair<Integer, String> pair = parseNumberAndHT(allocated);
        int number = pair.getKey();
        String hostType = pair.getValue();
        List<Integer> allocatedServers = hostToAllocatedSrvrMap.get(hostType);
        allocatedServers.remove((Integer) number);
    }

    protected Pair<Integer, String> parseNumberAndHT(String allocated) {
        String pattern = "[0-9]";
        Pattern word = Pattern.compile(pattern);
        Matcher match = word.matcher(allocated);

        if (match.find()) {
            int startIndex = match.start();
            //int endIndex = match.end();
            String numStr = allocated.substring(startIndex);
            try {
                int num = Integer.parseInt(numStr);
                String hostType = allocated.substring(0,startIndex);
                return new Pair<>(num, hostType);
            } catch(NumberFormatException e){
                // invalid condition
            }

        } else {
            // invalid condition
        }
        return null;
    }



}
