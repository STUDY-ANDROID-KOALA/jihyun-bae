def solution(msg):
    dictionary = [chr(i) for i in range(ord('A'), ord('Z') + 1)]
    
    answer = []
    
    num = 0
    temp = ''
    
    while num < len(msg):
        if temp + msg[num] in dictionary:
            temp += msg[num]
        else:
            print(temp)
            answer.append(dictionary.index(temp) + 1)
            dictionary.append(temp + msg[num])
            temp = msg[num]
        num += 1
    
    answer.append(dictionary.index(temp) + 1)
    
    return answer
