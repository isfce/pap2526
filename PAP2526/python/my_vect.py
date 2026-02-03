def fusion(l1, l2):
    l3 = [0] * (len(l1) + len(l2))
    i,j,k = 0,0,0

    while(i < len(l1) and j < len(l2)):
        if l1[i] <= l2[j]:
            l3[k] = l1[i]
            i = i + 1
        else:
            l3[k] = l2[j]
            j = j + 1
        k = k + 1
        
    #Maintenant l1 et ou l2 sont vides    
        
    # vide L1 si l1 n'est pas vide
    if i < len(l1):
        l3[k:] = l1[i:]
    # vide L2 si L2 n'est pas vide    
    if j < len(l2):
        l3[k:] = l2[j:]
    return l3

if __name__ == "__main__":
    print(fusion([1,3,7],[2,4,9,10]))