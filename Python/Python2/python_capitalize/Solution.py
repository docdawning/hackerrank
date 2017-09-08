def capitalize(string):
    sentence=""
    
    #a word shall be defined as alphanums, trailed by whitespaces. A new word begins if there is leading whitespace
    #most real world cases would be happy to use .split() as we don't want to typically keep whitespace, but we do here
    
    word = ""
    wordProcessed = False
    for c in string:
        if (c != ' '):
            word += c
            wordProcessed = False
        else:
            if not wordProcessed:
                sentence += capitalizeWord(word)
                wordProcessed = True
                word  = ""
            sentence += c

    sentence += capitalizeWord(word)
    return sentence
            
def capitalizeWord(string):
    if len(string) < 1:
        return string
    if len(string) < 2:
        return string[0].upper()

    return string[0:1].upper()+string[1:]


if __name__ == '__main__':
    string = raw_input()
    capitalized_string = capitalize(string)
    print capitalized_string
