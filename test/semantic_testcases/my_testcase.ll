target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"
declare i32 @f(i32, double) #1
define i32 @main() #0 {
%1 = alloca i32
store i32 none, i32* %1
%2 = alloca i32
%3 = add i32 0, 0
%4 = add i32 %3, 1
store i32 %4, i32* %2
ret i32 0
}
define i32 @f() #0 {
ret i32 1
}
