import random
file_obj = open('figure.dat', 'w')
try:
    for i in range(0, 10000):
        num = random.randint(0,100000)
        digit = str(num) + "\n"
        file_obj.write(digit)
finally:
    file_obj.close()

