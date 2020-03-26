class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        :example: gas  = [1,2,3,4,5]
                  cost = [3,4,5,1,2]
        """
        for i, gasi in enumerate(gas):
            if (gas[i] - cost[i]) < 0:
                continue

            remainGas = 0;
            for j in range(i, i + len(gas) + 1):
                if j == i + len(gas):
                    return i;
                remainGas += gas[j % len(gas)]
                if (remainGas - cost[j % len(gas)]) < 0:
                    break
                else:
                    remainGas = remainGas - cost[j % len(gas)]

        return -1


    def canCompleteCircuit2(self, gas, cost):
        leftDelt = 0
        rightDelt = 0
        index = 0
        flag = False
        for i, gasi in enumerate(gas):
            delta = gasi - cost[i]
            rightDelt += delta
            if rightDelt < 0:
                leftDelt = leftDelt + rightDelt
                rightDelt = 0
                flag = False
                continue
            else:
                if flag == False:
                    flag = True
                    index = i

        if rightDelt + leftDelt >= 0:
            return index
        else:
            return -1
            

if __name__ == "__main__":
    s = Solution()
    gas  = [1,2,3,4,5]
    cost = [3,4,5,1,2]
    # gas = [3,3,4]
    # cost = [3,4,4]
    # gas = [5,8,2,8]
    # cost = [6,5,6,6]
    ret = s.canCompleteCircuit2(gas, cost)
    print ret

                
