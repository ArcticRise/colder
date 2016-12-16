//Michael Vo
// Asgn4


#include <stdio.h>
#include <string.h>

int main(int argc, char**argv[])
{
   char a[80];
   char b[80];
   char str[80];
   int i = 0, z = 0, k = 0, sum = 0, len = 0;
        if(argc != 3)
        {
          printf("Error \n");
          return 0;
        }
        else
        {
          FILE *in =fopen(argv[2], "r");
          FILE *out = fopen(argv[1], "w");

        len = strlen(a);
        while ((fgets(a,80,in)) != NULL)
        {
                char * c = a;
                z = 0; i = 0;
                while(isdigit(*c))
                {
                  sum = sum + atoi(a);
                  z = 0;
                  while(isdigit(*c) != 0)
                        {
                          a[i] = str[z];
                          i++;
                          z++;
                        }
                 c++;
                }
                k = 0;
                while(a[i] != '\0')
                {
                   b[k] = a[i];
                   i++;
                   k++;
                }
                b[k] = '\0';
                fputs(b, out);
         }
        fprintf(out,"%d\n",sum);
        fclose(in);
        fclose(out);
}
return 0;
}
