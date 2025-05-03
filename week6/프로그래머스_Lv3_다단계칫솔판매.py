def solution(enroll, referral, seller, amount):
    result = [0] * len(enroll)
    people = {}
    
    for i in range(len(enroll)):
        people[enroll[i]] = i
        
    for i in range(len(seller)):
        sell = seller[i]
        money = amount[i] * 100
        
        while sell != "-" and money > 0:
            result[people[sell]] += money - money // 10
            money //= 10
            sell = referral[people[sell]]
    
    return result
