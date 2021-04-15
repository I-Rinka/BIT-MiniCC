int main()
{
    int a[5], i, j, t;
    for (i = 0; i < 5; i++)
    {
        a[i] = MARS_GETI();
    }
    a[0] = 9;
    for (i = 0; i < 4; i++)
    {
        for (j = 0; j < 5 - i; j++)
        {
            if (a[j] > a[j + 1])
            {
                t = a[j];
                a[j] = a[j + 1];
                a[j + 1] = t;
                break;
            }
            continue;
        }
    }
    ++i;
    sizeof(i);
    i = i + 1 + j++;
    double z = (double)i;
    t ? i++ : i--;
    goto id;
id:
{
    t = a[1] + i;
}
    return 0;
}
