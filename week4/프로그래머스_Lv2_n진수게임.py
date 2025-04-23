def solution(n, t, m, p):
    talk = ''
    i = 0
    
    while len(talk) < m * t:
        change = change_n(i, n)
        i += 1
        talk += change
    
    answer = ''
    for i in range(len(talk)):
        if len(answer) < t and i % m == p - 1: answer += talk[i]
    
    return answer

def change_n(number, n):
    if number == 0:
        return '0'
    
    base = ''
    
    while number > 0:
        number, mod = divmod(number, n)
        base += str(mod) if mod < 10 else chr(mod - 10 + ord('A'))
    
    return base[::-1]
