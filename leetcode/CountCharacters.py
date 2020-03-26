class Solution(object):
    def countCharacters(self, words, chars):
        """
        :type words: List[str]
        :type chars: str
        :rtype: int
        """
        if (len(words) == 0) or (len(chars) == 0):
            return 0

        totalNum = 0
        for word in words:
            m = list(chars)
            l = 0;
            for char in word:
                if char in m:
                    l += 1
                    m.remove(char)
                else:
                    break
            
            if (len(word) == l):
                totalNum += l
        
        return totalNum

if __name__ == "__main__":
    words = ["cat","bt","hat","tree"]
    chars = "atach"
    s = Solution()
    cnt = s.countCharacters(words, chars)
    print cnt

    words = ["hello","world","leetcode"]
    chars = "welldonehoneyr"
    cnt = s.countCharacters(words, chars)
    print cnt

    words = ["dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin",
    "ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb",
    "ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl",
    "boygirdlggnh",
    "xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx",
    "nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop",
    "hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx",
    "juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr",
    "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo",
    "oxgaskztzroxuntiwlfyufddl",
    "tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp",
    "qnagrpfzlyrouolqquytwnwnsqnmuzphne",
    "eeilfdaookieawrrbvtnqfzcricvhpiv",
    "sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz",
    "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue",
    "hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv",
    "cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo",
    "teyygdmmyadppuopvqdodaczob",
    "qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs",
    "qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"]
    chars = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp"
    cnt = s.countCharacters(words, chars)
    print cnt
        


