/* 
 * 
 * Author: Michael Vo
 *
 * Created on November 26, 2016, 12:31 PM
 */

#include <stdio.h>
#include <stdlib.h>
char *my_strcat(char[], char[]);
/*
 * 
 */

   int main(int argc, char** argv)
    {
       char lentest[] = "Hello";
       char cp[] = "Michael";
       char cp2[] = "gaas";
       char cp3[] = "Michael";
       char con1[] = "I'm";
       char con2[] = "Ready";
       char rever[] = "Class";
       
       int result = my_strlen(lentest);
       printf("The length of %s is %d \n", lentest, result);
       printf("The strings are %s and %s \n ", cp, cp2);
       int co = my_strcpy(cp, cp2);
       printf("result of the copy is: %d \n", co);
       printf("The strings are %s and %s \n ", cp2, cp);
       int co2 = my_strcpy(cp2, cp3);
       printf("result of the copy is: %d \n", co2);
       char *con = my_strcat(con1, con2);
       printf("The concatenation of con1 and con 2 is: %s \n", con);
       printf("The string is: %s \n", rever);
       my_strreverse(rever);
       printf("The reverse of the string is: %s \n", rever);
       
       return 0;
    }
  

    int my_strlen(char s[])
    {
        int i;
        int length = 0;
        for(i = 0;s[i] != '\0'; i++)
        {
            length++;
        }
      return length;
    }
    int my_strcpy(char s[], char t[])
    {
        int i;
        int copy;
        int len  = my_strlen(s);
        int len1 = my_strlen(t);
        if(len1>len)
        {
            copy = -1;
            return copy;
        }
        for(i = 0;i < len; i++)
        {
            s[i]=t[i];
        }
        s[i] = '\0';
         return 1;
    }
    
    
    char * my_strcat(char s[], char t[])
    {
        char *p;
        char *q;
        p = s;
        q = t;
        int len = my_strlen(s);
        int len1 = my_strlen(t);
        char *str = malloc(len + len1 + 2);
        char * strs = str;
        int i = 0, l=0;
        while (i < len)
         {
            *str = *p;
             str++;
             p++;
             i++;
         }
            *str = ' ';
            str++;
        while (l < len1)
        {
            *str = *q;
            str++;
            q++;
            l++;
        }
        *str = '\0';
        return strs;
    }

    void my_strreverse (char s[])
    {
        char *m = s;
        char y;
        if(s)
        {
            while(*m)
            {
                m++;
            }
            m--;
            while(s<m)
            {
                y = *s;
                *s++ = *m;
                *m-- = y;
            }
             
        }
        
    }
    