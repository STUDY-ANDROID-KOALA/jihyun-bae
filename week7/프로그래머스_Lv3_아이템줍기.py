from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    maps = [[0] * 102 for _ in range(102)]
    
    for rect in rectangle:
        for i in range(rect[0] * 2, rect[2] * 2 + 1):
            for j in range(rect[1] * 2, rect[3] * 2 + 1):
                maps[j][i] = 1
    
    for rect in rectangle:
        for i in range(rect[0] * 2 + 1, rect[2] * 2):
            for j in range(rect[1] * 2 + 1, rect[3] * 2):
                maps[j][i] = 0
                
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    visited = [[0] * 102 for _ in range(102)]
    queue = deque()
    queue.append([characterY * 2, characterX * 2])
    visited[characterY * 2][characterX * 2] = 1
    
    while queue:
        now = queue.popleft()
        
        for i in range(4):
            next = [now[0] + dx[i], now[1] + dy[i]]
            
            if 0 <= now[0] < 102 and 0 <= now[1] < 102 and maps[next[0]][next[1]] == 1 and visited[next[0]][next[1]] == 0:
                queue.append(next)
                visited[next[0]][next[1]] = visited[now[0]][now[1]] + 1
    
    return (visited[itemY * 2][itemX * 2] - 1) // 2
