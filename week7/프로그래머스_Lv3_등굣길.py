from collections import deque

def solution(m, n, puddles):
    maps = [[0] * m for _ in range(n)]
    visited = [[0] * m for _ in range(n)]
    
    for puddle in puddles:
        maps[puddle[1] - 1][puddle[0] - 1] = -1
        
    queue = deque()
    dx = [0, 1]
    dy = [1, 0]
    
    queue.append([0, 0])
    maps[0][0] = 1
    visited[0][0] = 1
    
    while queue:
        now = queue.popleft()
        for i in range(2):
            next = [now[0] + dx[i], now[1] + dy[i]]
            
            if 0 <= next[0] < n and 0 <= next[1] < m and maps[next[0]][next[1]] != -1:
                if maps[next[0]][next[1]] == 0:
                    queue.append(next)
                    maps[next[0]][next[1]] = maps[now[0]][now[1]] + 1
                    visited[next[0]][next[1]] = (visited[next[0]][next[1]] + visited[now[0]][now[1]]) % 1000000007
                elif maps[next[0]][next[1]] == maps[now[0]][now[1]] + 1:
                    visited[next[0]][next[1]] = (visited[next[0]][next[1]] + visited[now[0]][now[1]]) % 1000000007
    
    return visited[n - 1][m - 1]
