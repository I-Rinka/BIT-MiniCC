@.str.0 = i8* "Please input a number:\n"
@.str.1 = i8* "The number of prime numbers within n is:\n"
define i32 @prime(i32 %0) #0 {
  %2 = alloca i32
  store i32 %0, i32* %2
  %3 = alloca i32
  store i32 0, i32* %3
  %4 = alloca i32
  %5 = alloca i32
  %6 = alloca i32
  store i32 1, i32* %6
  store i32 2, i32* %4
  br label %7
  7:
  %8 = load i32, i32* %4
  %9 = load i32, i32* %2
  %10 = icmp sle i32 %8, %9
  br i1 %10, label %11, label %40
  11:
  store i32 1, i32* %6
  store i32 2, i32* %5
  br label %12
  12:
  %13 = load i32, i32* %5
  %14 = load i32, i32* %5
  %15 = mul i32 %13, %14
  %16 = load i32, i32* %4
  %17 = icmp sle i32 %15, %16
  br i1 %17, label %18, label %29
  18:
  %19 = load i32, i32* %4
  %20 = load i32, i32* %5
  %21 = srem i32 %19, %20
  %22 = icmp eq i32 %21, 0
  br i1 %22, label %23, label %25
  23:
  store i32 0, i32* %6
  br label %29
  24:
  br label %25
  25:
  br label %26
  26:
  %27 = load i32, i32* %5
  %28 = add i32 %27, 1
  store i32 %28, i32* %5
  br label %12
  29:
  %30 = load i32, i32* %6
  %31 = icmp eq i32 %30, 1
  br i1 %31, label %32, label %36
  32:
  %33 = load i32, i32* %3
  %34 = add i32 %33, 1
  store i32 %34, i32* %3
  %35 = load i32, i32* %4
  call void @Mars_PrintInt(i32 %35)
  br label %36
  36:
  br label %37
  37:
  %38 = load i32, i32* %4
  %39 = add i32 %38, 1
  store i32 %39, i32* %4
  br label %7
  40:
  %41 = load i32, i32* %3
  ret i32 %41
}
define i32 @main() #0 {
  %1 = getelementptr [26 x i8], [26 x i8]* @.str.0, i32 0, i32 0
  call void @Mars_PrintStr(i8* %1)
  %2 = alloca i32
  %3 = call i32 @Mars_GetInt()
  store i32 %3, i32* %2
  %4 = alloca i32
  %5 = load i32, i32* %2
  %6 = call i32 @prime(i32 %5)
  store i32 %6, i32* %4
  %7 = getelementptr [44 x i8], [44 x i8]* @.str.1, i32 0, i32 0
  call void @Mars_PrintStr(i8* %7)
  %8 = load i32, i32* %4
  call void @Mars_PrintInt(i32 %8)
  ret i32 0
}
