#coding=utf-8
import sys

class Split(object):
    def split(self, text):
        # """
        # {语气前缀}电话[把|将|让|使](QQ|qq|扣扣|企鹅QQ|QQ企鹅)[消息|信息][重|重新]{发送}{语气后缀}
        # """
        left = ['{', '[', '(']
        right = ['}', ']', ')']
        l = []
        str = unicode(text, 'utf-8')
        for i in range(len(str)):
            ch = str[i]
            # print ch
            if ch  in left:
                index = left.index(ch)
                for j in range(i + 1, len(str)):
                    if str[j] == right[index]:
                        # print (i, j)
                        # print str[i:j+1]
                        l.append(str[i:j+1])
                        i = j + 1
                        break
        return l

if __name__ == "__main__":
    str = "{语气前缀}电话[把|将|让|使](QQ|qq|扣扣|企鹅QQ|QQ企鹅)[消息|信息][重|重新]{发送}{语气后缀}"
    s = Split()
    lst = s.split(str)
    msg = repr([x.encode(sys.stdout.encoding) for x in lst]).decode('string-escape')
    print msg

    

                

