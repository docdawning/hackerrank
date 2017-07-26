#Refs: https://www.hackerrank.com/challenges/python-string-formatting
def print_formatted(number):
    width=len(bin(n)[2:].__str__())
    for i in range(1,number+1):
        delimiter=" "
        binary=bin(i)[2:].__str__()
        hexadecimal=hex(i)[2:].__str__().upper()
        octal=oct(i).__str__().lstrip("0").upper()
        decimal=i.__str__()
        printString = formatString(decimal, width)
        printString = printString + formatString(octal, width)
        printString = printString + formatString(hexadecimal, width)
        printString = printString + formatString(binary, width)
        print printString
        
def formatString(string, width):
    return '{: >{}}'.format(string, width)+" "


if __name__ == '__main__':
    n = int(raw_input())
    print_formatted(n)
