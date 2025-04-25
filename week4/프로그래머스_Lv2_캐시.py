def solution(cacheSize, cities):
    cache = []
    time = 0
    
    for city in cities:
        city = city.lower()
        if city in cache:
            time += 1
            cache.append(cache.pop(cache.index(city)))
        else:
            if cacheSize != 0 and len(cache) == cacheSize:
                cache.pop(0)
            if cacheSize != 0: cache.append(city)
            time += 5
    
    return time
