target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

define void @hello() #0 {
ret void
}
define i32 @main() #0 {
%1 = alloca i32
%2 = alloca i32
call void () @hello
ret int 0
}
