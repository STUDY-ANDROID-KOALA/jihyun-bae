def solution(n, t, m, timetable):
    crew = []
    car = []
    answer = 0
    
    for times in timetable:
        crew.append(to_minute(times))
    crew.sort()
    
    time = to_minute("09:00")
    for i in range(n):
        car.append(time)
        time += t
    
    index = 0
    for c in car:
        count = 0
        
        while count < m and index < len(crew) and crew[index] <= c:
            count += 1
            index += 1
        
        if count < m: answer = c
        else: answer = crew[index - 1] - 1
    
    return to_time(answer)

def to_minute(t):
    hour, minute = map(int, t.split(":"))
    return hour * 60 + minute

def to_time(t):
    return f"{t//60:02d}:{t%60:02d}"
