### 1.二分法基本写法
```
int start = 0 , end = arr.length , mid = 0;
while(start < end){
    // 逐步缩小区间
    mid = (start + end) / 2;
    if(...){
        start = mid + 1;
    }else if(...){
        end = mid - 1;
    }
}
// 循环结束后，必定是start=end

// TODO SOMETHING

```