def solution(n, s):
    if s < n:
        return [-1]
    
    num = s // n
    rest = s % n
    
    answer = [num] * n
    
    index = n - 1
    
    for _ in range(rest):
        answer[index] += 1
        
        if index == 0:
            index = n -1
        else:
            index -= 1
            
    return answer
