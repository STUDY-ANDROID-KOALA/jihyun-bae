def solution(n, stations, w):
    now = 1
    answer = 0
    
    for station in stations:
        count = station - w - now
        now = station + w + 1
        
        answer += count // (2 * w + 1)
        if count % (2 * w + 1) != 0: 
            answer += 1
    
    if now <= n:
        count = n - now + 1
        
        answer += count // (2 * w + 1)
        if count % (2 * w + 1) != 0:
            answer += 1
    
    return answer
