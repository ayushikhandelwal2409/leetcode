class Solution:
    import math

    def gcdOfStrings(self,str1: str, str2: str) -> str:
        def gcd(a: int, b: int) -> int:
            while b:
                a, b = b, a % b
            return a

        def check(s: str, x: str) -> bool:
            return s == x * (len(s) // len(x))

        gcd_len = gcd(len(str1), len(str2))
        candidate = str1[:gcd_len]

        if check(str1, candidate) and check(str2, candidate):
            return candidate
        else:
            return ""