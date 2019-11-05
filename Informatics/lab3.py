# Variant 5
# Создание класса People с разными параметрами, который будет выполнять роль объекта
class People:
    def __init__(self):
        self.mas = {'Name': 'None', 'Birthday': 'None', 'Day': 'None', 'Ex1': 'None', 'Ex2': 'None', 'Ex3': 'None',
                    'Ex': 'None'}

    def set(self, param_name, value):
        self.mas[param_name] = value

    def get(self, param_name):
        return self.mas[param_name]


# Перевод string в int
def to_int(string_to_int):
    dictionary = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
    integer = 0
    r = 1
    for char in string_to_int[::-1]:
        n = 0
        for numeral in dictionary:
            if char == numeral:
                integer += n * r
            n += 1
        r = r * 10
    return integer


# Функция для вычисления среднего значения принимающяя string
def average_value(a, b, c):
    a = to_int(a)
    b = to_int(b)
    c = to_int(c)
    result = (a + b + c) / 3
    if (result*10)%10 == 0:
        result = round((a + b + c) / 3)
    return result


# Создание массива
bd = []
# Создание временной перемен
tmp = None
# Открытие файла и заполнение массива
with open('data.txt', 'r', encoding='utf-8') as data:
    for line in data:
        thirdName, name, birthday, day, ex1, ex2, ex3 = line.split()
        tmp = People()
        tmp.set('Name', '{} {}'.format(thirdName, name))
        tmp.set('Birthday', birthday)
        tmp.set('Day', day)
        tmp.set('Ex1', ex1)
        tmp.set('Ex2', ex2)
        tmp.set('Ex3', ex3)
        tmp.set('Ex', average_value(tmp.get('Ex1'), tmp.get('Ex2'), tmp.get('Ex3')))
        bd.append(tmp)
# Сортировка массива выбором
for i in range(len(bd)):
    for j in range(i + 1, len(bd)):
        if bd[i].get('Name') > bd[j].get('Name'):
            bd[i], bd[j] = bd[j], bd[i]
# Вывод
for people in bd:
    print(
        "{} | {} | {} | {} {} {} -> {}".format(people.get('Name'), people.get('Birthday'), people.get('Day'),
                                               people.get('Ex1'),
                                               people.get('Ex2'), people.get('Ex3'), people.get('Ex')))
