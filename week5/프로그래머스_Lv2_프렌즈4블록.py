def solution(m, n, board):
    answer = 0
    
    rotated = [list(row)[::-1] for row in zip(*board)]

    while(True):
        delete = set()
        
        for i in range(len(rotated) - 1):
            for j in range(len(rotated[i]) - 1):
                if j < len(rotated[i + 1]) - 1 and rotated[i][j] == rotated[i + 1][j] == rotated[i][j + 1] == rotated[i + 1][j + 1]:
                    delete.update([(i, j), (i + 1, j), (i, j+1), (i+1, j+1)])
        
        if delete:
            for index in delete:
                rotated[index[0]][index[1]] = ''
            
            for i in range(len(rotated)):
                rotated[i] = [x for x in rotated[i] if x != '']
            
            answer += len(delete)
            
        else:
            break
            
    return answer
