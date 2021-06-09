@.str.0 = i8* "please input ten int number for bubble sort:\n"
@.str.1 = i8* "before bubble sort:\n"
@.str.2 = i8* "\n"
@.str.3 = i8* "after bubble sort:\n"
define i32 @main() #0 {
  %1 = alloca [10 x i32]
  %2 = getelementptr [48 x i8], [48 x i8]* @.str.0, i32 0, i32 0
  call void @Mars_PrintStr(i8* %2)
  %3 = alloca i32
  store i32 0, i32* %3
  br label %4
  4:
  %5 = load i32, i32* %3
  %6 = icmp slt i32 %5, 10
  br i1 %6, label 7, label %14
  7:
  %8 = load i32, i32* %3
  %9 = getelementptr [10 x i32], [10 x i32]* %1, i32 0, i32 %8
  %10 = call i32 @Mars_GetInt()
  store i32 %10, i32* %9
  br label %11
  11:
  %12 = load i32, i32* %3
  %13 = add i32 %12, 1
  store i32 %13, i32* %3
  br label %4
  14:
  %15 = getelementptr [23 x i8], [23 x i8]* @.str.1, i32 0, i32 0
  call void @Mars_PrintStr(i8* %15)
  %16 = alloca i32
  store i32 0, i32* %16
  br label %17
  17:
  %18 = load i32, i32* %16
  %19 = icmp slt i32 %18, 10
  br i1 %19, label 20, label %26
  20:
  %21 = load i32, i32* %16
  %22 = getelementptr [10 x i32], [10 x i32]* %1, i32 0, i32 %21
  call void @Mars_PrintInt(i32 %22)
  br label %23
  23:
  %24 = load i32, i32* %16
  %25 = add i32 %24, 1
  store i32 %25, i32* %16
  br label %17
  26:
  %27 = getelementptr [4 x i8], [4 x i8]* @.str.2, i32 0, i32 0
  call void @Mars_PrintStr(i8* %27)
  %28 = alloca i32
  store i32 0, i32* %28
  br label %29
  29:
  %30 = load i32, i32* %28
  %31 = icmp slt i32 %30, 10
  br i1 %31, label 32, label %68
  32:
  %33 = alloca i32
  store i32 0, i32* %33
  br label %34
  34:
  %35 = load i32, i32* %33
  %36 = load i32, i32* %28
  %37 = sub i32 10, %36
  %38 = sub i32 %37, 1
  %39 = icmp slt i32 %35, %38
  br i1 %39, label 40, label %64
  40:
  %41 = load i32, i32* %33
  %42 = getelementptr [10 x i32], [10 x i32]* %1, i32 0, i32 %41
  %43 = load i32, i32* %33
  %44 = add i32 %43, 1
  %45 = getelementptr [10 x i32], [10 x i32]* %1, i32 0, i32 %44
  %46 = icmp sgt i32 %42, %45
  br i1 %46, label %47, label %60
  47:
  %48 = alloca i32
  %49 = load i32, i32* %33
  %50 = getelementptr [10 x i32], [10 x i32]* %1, i32 0, i32 %49
  store i32 %50, i32* %48
  %51 = load i32, i32* %33
  %52 = getelementptr [10 x i32], [10 x i32]* %1, i32 0, i32 %51
  %53 = load i32, i32* %33
  %54 = add i32 %53, 1
  %55 = getelementptr [10 x i32], [10 x i32]* %1, i32 0, i32 %54
  store i32 %55, i32* %52
  %56 = load i32, i32* %33
  %57 = add i32 %56, 1
  %58 = getelementptr [10 x i32], [10 x i32]* %1, i32 0, i32 %57
  %59 = load i32, i32* %48
  store i32 %59, i32* %58
  br label %60
  60:
  br label %61
  61:
  %62 = load i32, i32* %33
  %63 = add i32 %62, 1
  store i32 %63, i32* %33
  br label %34
  64:
  br label %65
  65:
  %66 = load i32, i32* %28
  %67 = add i32 %66, 1
  store i32 %67, i32* %28
  br label %29
  68:
  %69 = getelementptr [22 x i8], [22 x i8]* @.str.3, i32 0, i32 0
  call void @Mars_PrintStr(i8* %69)
  %70 = alloca i32
  store i32 0, i32* %70
  br label %71
  71:
  %72 = load i32, i32* %70
  %73 = icmp slt i32 %72, 10
  br i1 %73, label 74, label %80
  74:
  %75 = load i32, i32* %70
  %76 = getelementptr [10 x i32], [10 x i32]* %1, i32 0, i32 %75
  call void @Mars_PrintInt(i32 %76)
  br label %77
  77:
  %78 = load i32, i32* %70
  %79 = add i32 %78, 1
  store i32 %79, i32* %70
  br label %71
  80:
  ret i32 0
}
