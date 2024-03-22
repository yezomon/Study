using System;
namespace CShap{
            class Program{
                static void Main(){
                    var s = Console.ReadLine().Split();
                     int[] nn = new int [int.Parse(s[0])+1];
        for (int i = 0; i < nn.Length;i++) {
            if (i < 2) nn[i] = i;
            else nn[i] = nn[i - 1] + nn[i-2];
        }
                    Console.Write(nn[nn.Length-1]);
                }
}}