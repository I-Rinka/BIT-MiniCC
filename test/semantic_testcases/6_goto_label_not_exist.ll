target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

define i32 @main() #0 {
  1:  
  br label %3
  2:  
  br label %3
  3:  
  br label %1
  4:  
  br label
  5:  
  ret i32 0
}