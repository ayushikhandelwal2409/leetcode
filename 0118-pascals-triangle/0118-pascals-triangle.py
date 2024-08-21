class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        if numRows == 0:
            return []

        pascal_triangle = [[1]]

        for i in range(1, numRows):
            row = [1]
            last_row = pascal_triangle[i-1]
            for j in range(1, i):
                row.append(last_row[j-1] + last_row[j])
            row.append(1)
            pascal_triangle.append(row)

        return pascal_triangle
            