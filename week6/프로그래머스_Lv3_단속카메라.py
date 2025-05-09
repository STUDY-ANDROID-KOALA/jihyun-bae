def solution(routes):
    routes.sort(key=lambda x: x[1])
    key = -30000
    answer = 0
    
    for i in range(len(routes)):
        if routes[i][0] > key:
            answer += 1
            key = routes[i][1]
    
    return answer
