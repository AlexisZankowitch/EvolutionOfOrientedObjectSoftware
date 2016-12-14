# Main list
city_format = ["Nr.", "City", "Area", "Population"]

# Cities
Daugavpils = ["Daugavpils", 73.50, 110000]
Riga = ["Riga", 307.17, 740000]
Liepaja = ["Liepaja", 60.40, 86000]

nb = '0'
Cities = [Riga, Daugavpils, Liepaja]


def print_list(l):
    print("%1s%-17s%-17s%-17s" % (city_format[0], city_format[1], city_format[2], city_format[3]))
    for i in range(0, len(l)):
        print("%1d. %-17s%-17f%-17d" % (i + 1, l[i][0], l[i][1], l[i][2]))
    print("***************************")


def add_first(ele, l):
    l[0:0] = [ele]
    return l


def add_last(ele, l):
    l.insert(len(l), ele)
    return l


def remove_first(l):
    try:
        del l[0]
    except Exception:
        print("List is empty !!")
    return l


def remove_last(l):
    if len(l) > 0:
        del l[len(l) - 1]
    else:
        print("List is empty !!")
    return l


def sort_by_amount_inhabitant_asc(l):
    l.sort(key=lambda x: -x[2])
    return l


def sort_by_amount_inhabitant_desc(l):
    l.sort(key=lambda x: x[2])
    return l


def ask_city():
    n = input('City name: ')
    a = float(input('City Area: '))
    i = int(input('City inhabitants: '))
    return [n, a, i]


def choice_list():
    print("1-Add city as FIRST record.")
    print("2-Add city as LAST record.")
    print("3-Remove FIRST record.")
    print("4-Remove LAST record.")
    print("5-Order by population (ASCENDING).")
    print("6-Order by population (DESCENDING).")
    print("7-Exit.")


while nb != '7':
    choice_list()
    nb = input('Choose a number: ')
    if nb == '1':
        Cities = add_first(ask_city(), Cities)
    elif nb == '2':
        Cities = add_last(ask_city(), Cities)
    elif nb == '3':
        Cities = remove_first(Cities)
    elif nb == '4':
        Cities = remove_last(Cities)
    elif nb == '5':
        Cities = sort_by_amount_inhabitant_asc(Cities)
    elif nb == '6':
        Cities = sort_by_amount_inhabitant_desc(Cities)
    # Cities = choose(nb)
    print_list(Cities)
