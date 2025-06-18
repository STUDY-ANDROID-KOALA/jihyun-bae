import heapq

def solution(n, works):
    answer = 0
    works = [-work for work in works]
    heapq.heapify(works)
    
    for _ in range(n):
        work = heapq.heappop(works)
        heapq.heappush(works, work + 1)
    
    for w in works:
        if w < 0:
            answer += w * w
    
    return answer
