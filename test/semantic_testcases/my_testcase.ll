e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128
x86_64-pc-linux-gnu

define i32 @main(i32 %0, i32 %1) #0 {
%3 = alloca i32
store i32 %0, i32* %3
%4 = alloca i32
store i32 %1, i32* %4
%5 = load i32, i32* %4
%6 = mul  2, 3
%7 = add  5, 6
%8 = mul  %6, %7
%9 = add  1, %8
store i32 %9, i32* %5
%10 = add i32 0, 0
ret i32 %10
}
