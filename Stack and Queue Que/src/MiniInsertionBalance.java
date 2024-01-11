public class MiniInsertionBalance {
    public int minInsertions(String s) {
        int needP = 0, putP = 0;
        for (int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            if (p == '(') {
                // if we see a left p
                // expect 2 right p in the future string
                needP += 2;
                if (needP %2 == 1) {
                    // needP must be even, because for a left p, it must come with 2 consecutive right p
                    // so we should PUT a right P in this case
                    // since we put a right p, we need one less right p
                    needP--;
                    putP++;
                }
            } else {
                // p == ')', consume needRight if we still have it >0
                if(needP > 0) {
                    needP--;
                } else {
                    // needP==0, but we see a right p here,
                    // so we need a pair of ()
                    // we firstly PUT a left p, and we expect a right p in the future
                    // the key idea shows again, we always expect a right p will appear in the future char
                    // that's why for right p, we make it in needP variable, while for left p, we make it in putP variable
                    putP++;
                    needP = 1;
                }

            }
        }
        return needP+putP;
    }
}
