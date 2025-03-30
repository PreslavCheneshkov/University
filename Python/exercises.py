def firstTask():
    def matchingEnds(words):
        count = 0
        for word in words:
            wordLength = len(word)
            if wordLength >= 2:
                if word[0] == word[wordLength - 1]:
                    count += 1

        return count

    print('Задача 1:')
    print(matchingEnds(['aba', 'xyz', 'aa', 'x', 'bbb']))
    print(matchingEnds(['', 'x', 'xy', 'xyx', 'xx']))
    print(matchingEnds(['aaa', 'be', 'abc', 'hello']))
    return

def secondTask():
    def front_x(words):
        xWords = []
        nonXWords = []
        
        for word in words:
            if word[0] == 'x' or word[0] == 'X':
                xWords.append(word)
            else:
                nonXWords.append(word)

        resultingWords = []
        for xWord in sorted(xWords):
            resultingWords.append(xWord)
        for nonXWord in sorted(nonXWords):
            resultingWords.append(nonXWord)
        return resultingWords

    print('Задача 2:')
    print(front_x(['bbb', 'ccc', 'axx', 'xzz', 'xaa']))
    print(front_x(['ccc', 'bbb', 'aaa', 'xcc', 'xaa']))
    print(front_x(['mix', 'xyz', 'apple', 'xanadu', 'aardvark']))
    return

def thirdTask():
    def last(n): return n[1]
    def sort_list_last(tuples):
        return sorted(tuples, key=last)

    
    print("Задача 3:")
    print(sort_list_last([(1, 3), (3, 2), (2, 1)]))
    return

def fourthTask():
    def remove_adjacent(nums):
        lastNumber = 'a'
        indexesToRemove = []
        for i in range(len(nums)):
            if lastNumber != 'a':
                if (nums[i] == lastNumber):
                    indexesToRemove.append(i)
            lastNumber = nums[i]
        for index in indexesToRemove:
            nums

#firstTask()
#secondTask()
#thirdTask()