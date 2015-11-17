def bubbleSort(list):
    for i in range(len(list)):
        for j in range(len(list) - i - 1):
            if list[j] > list[j + 1]:
                list[j], list[j + 1] = list[j + 1], list[j]

    return list

def selectSort(list):
    for i in range(len(list) - 1):
        minIndex = i
        for j in range(i + 1, len(list)):
            if list[j] < list[minIndex]:
                minIndex = j
        if i != minIndex:
            list[i], list[minIndex] = list[minIndex], list[i]


def insertSort(list):
    for i in range(1, len(list)):
        for j in range(1, i + 1)[::-1]:
            if list[j - 1] > list[j]:
                //统统后移
                list[j - 1], list[j] = list[j], list[j - 1]
            else:
                break

def quickSort(lists):
    return quickSortHandler(lists, 0, len(lists)-1)

def quickSortHandler(lists, low, high):
    key = lists[low]
    i = low
    j = high
    if i >= j:
        return lists
    while i < j:
        while i < j and lists[j] >= key:
            j -= 1
        lists[i] = lists[j]
        while i < j and lists[i] <= key:
            i += 1
        lists[j] = lists[i]
    lists[i]=key
    quickSortHandler(lists, low, i-1)
    quickSortHandler(lists, i+1, high)
    return lists

def mergeSort(lists):
    if len(lists) <= 1:
        return lists
    num = int(len(lists) / 2)
    left = mergeSort(lists[:num])
    right = mergeSort(lists[num:])
    return merge(left, right)

def merge(left,right):
    l, r = 0, 0
    result = []
    while l < len(left) and r < len(right):
        if left[l] < right[r]:
            result.append(left[l])
            l+=1
        else:
            result.append(right[r])
            r+=1
    result += (left[l:])
    result += (right[r:])
    return result

def heapSort(list):
    pass;

list = list()
file_object = open('figure.dat')
try:
    for line in file_object.readlines():
        list.append(int(line.strip('\n')))
finally:
    file_object.close()

#bubbleSort(list)
#selectSort(list)
#insertSort(list)
#result = mergeSort(list)
result = quickSort(list)
print result



