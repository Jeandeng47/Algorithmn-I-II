char *append(const char* s1, const char* s2){
    const int MAXSIZE = 128;
    char result[MAXSIZE];
    int i = 0, j = ;
    for (; i < MAXSIZE - 1 && j < strlen(s1); i++, j++)
        result[i] = s1[j];
    
    for (j = 0; i < MAXSIZE - 1 && j < strlen(s2); i++, j++)
        result[i] = s2[j];
    result[++i] = '\0';
    return result;

}