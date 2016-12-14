import os
import sys

StartPath = os.path.dirname(sys.argv[0]) + "/"
file = open(StartPath + "Data.txt", "rt")
List = file.readlines()

Data = {"PYTHON": [], "PERL": []}
i = 0
choice = ''

# List creation
while i < len(List):
    name = List[i][:-1]
    if List[i + 1] and isinstance(int(List[i + 1]), int):
        counter = int(List[i + 1])
        j = i + 2
        while j < i+2+counter:
            Data[name].append(List[j][:-1])
            j += 1
        i += j


def print_list():
    for elem in Data:
        print("Theme: "+elem + " --- Documents: " + ' '.join(Data[elem]))


def append_document():
    key = input("Key: ").upper()
    if key not in Data:
        print(key + " not found !!")
    else:
        document = input("Document: ").lower()
        Data[key].append(document)


def saving():
    s = 0
    save = open(StartPath + "Data.txt", "w")
    for elem in Data:
        save.write(elem+'\n')
        save.write(str(len(Data[elem]))+'\n')
        for s in range(s, len(Data[elem])):
            save.write(Data[elem][s]+'\n')
        s = 0

# processing
while choice != 'E':
    print_list()
    choice = input("A - APPEND \nE - EXIT\n").upper()
    if choice == 'A':
        append_document()

saving()
print("File saved")
